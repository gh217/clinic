package com.example.doctorClinic.dto;

import lombok.Data;

@Data
public class UsersUpdateRequestDto {
    private Integer id;
    private int age;
    private String name;
}
