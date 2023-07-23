package com.example.doctorClinic.dto;

import com.example.doctorClinic.model.Treatment;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ExaminationResponseDto {
    private Integer id;
    private String diagnosis;
    List<TreatmentResponseDto> treatmentResponseDtoList=new ArrayList<>();
}
