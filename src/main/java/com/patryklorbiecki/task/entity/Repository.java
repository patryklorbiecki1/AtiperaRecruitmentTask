package com.patryklorbiecki.task.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class Repository {
    private String name;
    private Owner owner;
    private List<Branch> branches;
    private Boolean fork;
}
