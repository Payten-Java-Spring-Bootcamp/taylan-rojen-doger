package com.example.bootcampspringproject.homework1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String firstName;
    private String surName;
    private Integer number;
    private String schoolName;
}
