package com.patryklorbiecki.task.controller;

import com.patryklorbiecki.task.dto.RepositoryDto;
import com.patryklorbiecki.task.service.RepositoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "github", produces = "application/json")
public class GithubController {

    private final RepositoryService repositoryService;

    @RequestMapping("{username}")
    public List<RepositoryDto> listAll(@PathVariable String username) {
            return repositoryService.getRepositories(username);

    }

}
