package com.patryklorbiecki.task.API;

import com.patryklorbiecki.task.entity.Repository;

import java.util.List;

public interface RepositoryApi {
    List<Repository> getRepositories(String username);
}
