package com.patryklorbiecki.task.API;

import com.patryklorbiecki.task.dto.BranchDto;
import com.patryklorbiecki.task.entity.Repository;
import com.patryklorbiecki.task.exception.NotFoundException;
import com.patryklorbiecki.task.mapper.BranchMapper;
import com.patryklorbiecki.task.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RepositoryApiImpl implements RepositoryApi {
    private final WebClient webClient;
    private final BranchService branchService;
    private final BranchMapper branchMapper;

    @Override
    public List<Repository> getRepositories(String username) {
        final String apiUrl = getApiUrl(username);
        final Mono<Repository[]> response = webClient
                .get()
                .uri(apiUrl)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, error->Mono.error(new NotFoundException("User not found")))
                .bodyToMono(Repository[].class);
        final Optional<Repository[]> repositories = response.blockOptional();
        return Arrays.stream(repositories.orElseThrow())
                .filter(repository -> !repository.getFork())
                .map(repository -> fillWithBranches(repository, username))
                .collect(Collectors.toList());
    }

    private Repository fillWithBranches(Repository repository, String username) {
        final List<BranchDto> branches = branchService.getBranchesForRepository(username, repository.getName());
        repository.setBranches(branchMapper.toEntityList(branches));
        return repository;
    }

    private String getApiUrl(String username) {
        return String.format("/users/%s/repos", username);
    }
}
