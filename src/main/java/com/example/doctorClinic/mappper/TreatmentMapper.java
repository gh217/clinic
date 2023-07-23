package com.example.doctorClinic.mappper;

import com.example.doctorClinic.dto.TreatmentRequestDto;
import com.example.doctorClinic.dto.TreatmentResponseDto;
import com.example.doctorClinic.model.Treatment;
import org.springframework.stereotype.Component;

@Component
public class TreatmentMapper {

    public Treatment toTreatment(TreatmentRequestDto treatmentRequestDto){
        Treatment treatment=new Treatment();
        treatment.setName(treatmentRequestDto.getName());
        treatment.setExamination(treatmentRequestDto.getExamination());
        return treatment;
    }

    public TreatmentResponseDto toTreatmentResponseData(Treatment treatment){
        TreatmentResponseDto responseData=new TreatmentResponseDto();
        responseData.setId(treatment.getId());
        responseData.setName(treatment.getName());
        return responseData;
    }
}
