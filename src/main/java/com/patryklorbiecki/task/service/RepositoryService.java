package com.patryklorbiecki.task.service;

import com.patryklorbiecki.task.dto.RepositoryDto;

import java.util.List;

public interface RepositoryService {
    List<RepositoryDto> getRepositories(String username);
}
