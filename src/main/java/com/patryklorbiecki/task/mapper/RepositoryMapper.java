package com.patryklorbiecki.task.mapper;

import com.patryklorbiecki.task.dto.RepositoryDto;
import com.patryklorbiecki.task.entity.Repository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",uses = {BranchMapper.class})
public interface RepositoryMapper {
    @Mapping(target = "login",source = "owner.login")
    RepositoryDto toRepositoryDto(Repository repository);
    List<RepositoryDto> toRepositoryDtoList(List<Repository> repositories);
}
