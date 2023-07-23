package com.example.doctorClinic.controller;

import com.example.doctorClinic.dto.TreatmentRequestDto;
import com.example.doctorClinic.dto.TreatmentResponseDto;
import com.example.doctorClinic.model.Treatment;
import com.example.doctorClinic.service.ExaminationService;
import com.example.doctorClinic.service.TreatmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/treatment")
public class TreatmentController {

    private final TreatmentService treatmentService;
    private final ExaminationService examinationService;

    public TreatmentController(TreatmentService treatmentService, ExaminationService examinationService) {
        this.treatmentService = treatmentService;
        this.examinationService = examinationService;
    }

//    @PostMapping("/examinationId/{examinationId}")
//    public Treatment treatment(@RequestBody Treatment treatment,@PathVariable int examinationId ){
//        return treatmentService.save(treatment,examinationId);
//    }

    @PostMapping
    public TreatmentResponseDto treatment(@RequestBody TreatmentRequestDto treatmentRequestDto ){

        return treatmentService.save(treatmentRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUsers(@PathVariable int id){
        treatmentService.deleteById(id);
    }

    @GetMapping("/examinationId/{id}")
    public List<TreatmentResponseDto> treatmentList(@PathVariable int id){
        return treatmentService.findAllByExaminationId(id);
    }

}
