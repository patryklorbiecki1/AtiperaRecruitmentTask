package com.patryklorbiecki.task.controller;

import com.patryklorbiecki.task.service.RepositoryServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("github")
public class GithubController {
    private final RepositoryServiceImpl repositoryService;

    @GetMapping("{username}")
    public ResponseEntity<?> listAll(@PathVariable String username) {
        return new ResponseEntity<>(repositoryService.getRepositories(username), HttpStatus.ACCEPTED);
    }

}
