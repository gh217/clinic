package com.example.doctorClinic.dto;

import com.example.doctorClinic.model.Users;
import lombok.Data;

@Data
public class ExaminationRequestDto {
    private String diagnosis;
    private Users users;
}
