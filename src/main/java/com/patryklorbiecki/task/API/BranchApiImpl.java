package com.patryklorbiecki.task.API;

import com.patryklorbiecki.task.entity.Branch;
import lombok.RequiredArgsConstructor;
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
public class BranchApiImpl implements BranchApi {
    private final WebClient webClient;

    public List<Branch> getBranchDto(String username, String repositoryName) {
        final String apiUrl = getApiUrl(username, repositoryName);
        final Mono<Branch[]> response = webClient
                .get()
                .uri(apiUrl)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Branch[].class);
        final Optional<Branch[]> branches = response.blockOptional();
        return Arrays.stream(branches.orElseThrow()).collect(Collectors.toList());

    }

    private String getApiUrl(String username, String repositoryName) {
        return String.format("/repos/%s/%s/branches", username, repositoryName);
    }
}
