package com.patryklorbiecki.task.API;

import com.patryklorbiecki.task.entity.Branch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BranchApiImpl implements BranchApi {
    private static final String GITHUB_API_URL = "https://api.github.com";
    private final RestTemplate restTemplate;

    public List<Branch> getBranchDto(String username, String repositoryName) {
        final String apiUrl = getApiUrl(username, repositoryName);
        final Branch[] branches = Objects.requireNonNull(restTemplate.getForObject(apiUrl, Branch[].class));

        return Arrays.asList(branches);
    }

    private String getApiUrl(String username, String repositoryName) {
        return String.format("%s/repos/%s/%s/branches", GITHUB_API_URL, username, repositoryName);
    }
}
