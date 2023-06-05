package com.patryklorbiecki.task.service;

import com.patryklorbiecki.task.dto.BranchDto;
import com.patryklorbiecki.task.entity.Repository;
import com.patryklorbiecki.task.mapper.BranchMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RepositoryApi {
    private static final String GITHUB_API_URL = "https://api.github.com/";
    private final RestTemplate restTemplate;
    private final BranchService branchService;
    private final BranchMapper branchMapper;

    public List<Repository> getRepositories(String username){
        final String apiUrl = getApiUrl(username);
        final Repository[] repositories = Objects.requireNonNull(restTemplate.getForObject(apiUrl, Repository[].class));
        return Arrays.stream(repositories)
                .filter(repository -> !repository.getFork())
                .map(repository -> fillWithBranches(repository,username))
                .collect(Collectors.toList());
    }

    private Repository fillWithBranches(Repository repository,String username) {
        final List<BranchDto> branches = branchService.getBranchesForRepository(username, repository.getName());
        repository.setBranches(branchMapper.dtoToBranchList(branches));
        return repository;
    }

    private String getApiUrl(String username){
        return GITHUB_API_URL + "users/" + username + "/repos";
    }
}
