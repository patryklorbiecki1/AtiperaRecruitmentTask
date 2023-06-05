package com.patryklorbiecki.task.service;

import com.patryklorbiecki.task.dto.BranchDto;

import java.util.List;

public interface BranchService {
    List<BranchDto> getBranchesForRepository(String username, String repositoryName);
}
