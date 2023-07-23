package com.example.doctorClinic.controller;

import com.example.doctorClinic.dto.ExaminationRequestDto;
import com.example.doctorClinic.dto.ExaminationResponseDto;
import com.example.doctorClinic.dto.ExaminationUpdateRequestDto;
import com.example.doctorClinic.exception.BadRequest;
import com.example.doctorClinic.model.Examination;
import com.example.doctorClinic.service.ExaminationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/examination")
public class ExaminationController {

    private final ExaminationService examinationService;

    public ExaminationController(ExaminationService examinationService) {
        this.examinationService = examinationService;
    }

    @PostMapping
    public ExaminationResponseDto addExamination(@RequestBody ExaminationRequestDto examination){
        return examinationService.save(examination);
    }

    @GetMapping("/{id}")
    public ExaminationResponseDto examination(@PathVariable int id){

        return examinationService.findById(id);
    }

    @GetMapping("/usersId/{id}")
    public List<ExaminationResponseDto>examinations(@PathVariable int id) {
        return examinationService.findAllByUsersId(id);
    }

    @PutMapping
    public ExaminationResponseDto updateExamination(@RequestBody ExaminationUpdateRequestDto examinationUpdateRequestDto){
        if(examinationUpdateRequestDto==null||examinationUpdateRequestDto.getUsers()==null)throw new BadRequest("NO NULL");
        return examinationService.update(examinationUpdateRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        examinationService.deleteById(id);
    }


}
