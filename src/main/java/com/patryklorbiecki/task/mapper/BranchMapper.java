package com.patryklorbiecki.task.mapper;

import com.patryklorbiecki.task.dto.BranchDto;
import com.patryklorbiecki.task.entity.Branch;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BranchMapper {
    BranchMapper INSTANCE = Mappers.getMapper(BranchMapper.class);
    @Mapping(target="lastCommit",source = "commit.sha")
    BranchDto toBranchDto(Branch branch);
    List<BranchDto> toBranchDtoList(List<Branch> branches);
    @Mapping(source = "lastCommit", target = "commit.sha")
    Branch toEntity(BranchDto branchDto);

    List<Branch> toEntityList(List<BranchDto> branchDtos);
}
