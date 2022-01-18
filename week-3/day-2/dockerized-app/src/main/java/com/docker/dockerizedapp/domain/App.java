package com.docker.dockerizedapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class App {
    private long id;
    private int version;
    private String name;
    private LocalDate publishedDate;
    private boolean isFree;
}
