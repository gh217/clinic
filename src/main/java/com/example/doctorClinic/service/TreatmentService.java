package com.example.doctorClinic.service;

import com.example.doctorClinic.dto.TreatmentRequestDto;
import com.example.doctorClinic.dto.TreatmentResponseDto;
import com.example.doctorClinic.exception.NotContent;
import com.example.doctorClinic.model.Treatment;
import com.example.doctorClinic.mappper.TreatmentMapper;
import com.example.doctorClinic.repo.TreatmentRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TreatmentService {

    private final TreatmentRepo treatmentRepo;
    private final ExaminationService examinationService;

    private final TreatmentMapper treatmentMapper;

    public TreatmentService(TreatmentRepo treatmentRepo, ExaminationService examinationService, TreatmentMapper treatmentMapper) {
        this.treatmentRepo = treatmentRepo;
        this.examinationService = examinationService;
        this.treatmentMapper = treatmentMapper;
    }

    public TreatmentResponseDto save(TreatmentRequestDto treatmentRequestDto) {

         Treatment treatment= treatmentRepo.save(treatmentMapper.toTreatment(treatmentRequestDto));
         return treatmentMapper.toTreatmentResponseData(treatment);
    }

    public void deleteById(int id){
        if(!checkTreatmentId(id))throw new NotContent("Id Treatment Not Found");
        treatmentRepo.deleteById(id);
    }
    private boolean checkTreatmentId(int id){
        return treatmentRepo.findById(id).isPresent();
    }

    public List<TreatmentResponseDto>findAllByExaminationId(int examinationId){
        List<Treatment>treatmentList=treatmentRepo.findAllByExaminationId(examinationId);
        return treatmentList.stream().map(treatmentMapper::toTreatmentResponseData).toList();
    }

}