package com.patryklorbiecki.task.service;

import com.patryklorbiecki.task.API.BranchApi;
import com.patryklorbiecki.task.dto.BranchDto;
import com.patryklorbiecki.task.mapper.BranchMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {
    private final BranchMapper branchMapper;
    private final BranchApi branchApi;

    @Override
    public List<BranchDto> getBranchesForRepository(String username, String repositoryName) {
        return branchMapper.toBranchDtoList(branchApi.getBranchDto(username, repositoryName));
    }

}
