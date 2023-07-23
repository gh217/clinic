package com.example.doctorClinic.dto;

import com.example.doctorClinic.model.Examination;
import lombok.Data;

@Data
public class TreatmentRequestDto {
    private String name;
    private Examination examination;
}
