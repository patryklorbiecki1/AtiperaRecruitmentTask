package com.patryklorbiecki.task.service;

import com.patryklorbiecki.task.API.RepositoryApi;
import com.patryklorbiecki.task.dto.RepositoryDto;
import com.patryklorbiecki.task.mapper.RepositoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RepositoryServiceImpl implements RepositoryService {

    private final RepositoryApi repositoryApi;
    private final RepositoryMapper repositoryMapper;

    @Override
    public List<RepositoryDto> getRepositories(String username) {
        return repositoryMapper.toRepositoryDtoList(repositoryApi.getRepositories(username));

    }

}
