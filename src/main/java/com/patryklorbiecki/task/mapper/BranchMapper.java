package com.patryklorbiecki.task.mapper;

import com.patryklorbiecki.task.dto.BranchDto;
import com.patryklorbiecki.task.entity.Branch;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BranchMapper {
    @Mapping(target="lastCommit",source = "commit.sha")
    BranchDto toBranchDto(Branch branch);
    List<BranchDto> toBranchDtoList(List<Branch> branches);
    @Mapping(target="lastCommit",source = "commit.sha")
    List<Branch> dtoToBranchList(List<BranchDto> branch);
}
