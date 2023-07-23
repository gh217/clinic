package com.example.doctorClinic.dto;

import com.example.doctorClinic.model.Users;
import lombok.Data;

@Data
public class ExaminationUpdateRequestDto {
    private Integer id;
    private String diagnosis;
    private Users users;
}
