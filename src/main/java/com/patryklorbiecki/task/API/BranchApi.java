package com.patryklorbiecki.task.API;

import com.patryklorbiecki.task.entity.Branch;

import java.util.List;

public interface BranchApi {
    List<Branch> getBranchDto(String username, String repositoryName);
}
