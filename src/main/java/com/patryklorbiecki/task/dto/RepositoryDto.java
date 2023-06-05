package com.patryklorbiecki.task.dto;

import java.util.List;

public record RepositoryDto(String name, String login, List<BranchDto> branches) { }
