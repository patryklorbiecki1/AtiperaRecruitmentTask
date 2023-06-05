package com.patryklorbiecki.task.controller;

import com.patryklorbiecki.task.service.RepositoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(value = "github", produces = "application/json")
public class GithubController {

    private final RepositoryService repositoryService;

    @RequestMapping("{username}")
    public ResponseEntity<?> listAll(@PathVariable String username) throws Exception {
            return new ResponseEntity<>(repositoryService.getRepositories(username), HttpStatus.ACCEPTED);

    }

}
