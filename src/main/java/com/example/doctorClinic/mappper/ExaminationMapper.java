package com.example.doctorClinic.mappper;

import com.example.doctorClinic.dto.ExaminationRequestDto;
import com.example.doctorClinic.dto.ExaminationResponseDto;
import com.example.doctorClinic.dto.ExaminationUpdateRequestDto;
import com.example.doctorClinic.dto.TreatmentResponseDto;
import com.example.doctorClinic.model.Examination;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExaminationMapper {

    private final TreatmentMapper treatmentMapper;

    public ExaminationMapper(TreatmentMapper treatmentMapper) {
        this.treatmentMapper = treatmentMapper;
    }

    public Examination toExamination(ExaminationRequestDto examinationRequestDto){
        Examination examination =new Examination();
        examination.setDiagnosis(examinationRequestDto.getDiagnosis());
        examination.setUsers(examinationRequestDto.getUsers());
        return examination;
    }
    public Examination toExamination(ExaminationUpdateRequestDto examinationUpdateRequestDto){
        Examination examination =new Examination();
        examination.setId(examinationUpdateRequestDto.getId());
        examination.setDiagnosis(examinationUpdateRequestDto.getDiagnosis());
        examination.setUsers(examinationUpdateRequestDto.getUsers());
        return examination;
    }

    public ExaminationResponseDto toExaminationResponseDto(Examination examination){
        ExaminationResponseDto examinationResponseDto=new ExaminationResponseDto();
        examinationResponseDto.setId(examination.getId());
        examinationResponseDto.setDiagnosis(examination.getDiagnosis());

        List<TreatmentResponseDto>list=
                examination.getTreatmentList()
                        .stream()
                        .map(treatmentMapper::toTreatmentResponseData)
                        .toList();
        examinationResponseDto.setTreatmentResponseDtoList(list);
        return examinationResponseDto;
    }

}
