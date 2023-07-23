package com.example.doctorClinic.service;

import com.example.doctorClinic.dto.ExaminationRequestDto;
import com.example.doctorClinic.dto.ExaminationResponseDto;
import com.example.doctorClinic.dto.ExaminationUpdateRequestDto;
import com.example.doctorClinic.exception.NotContent;
import com.example.doctorClinic.exception.NotFound;
import com.example.doctorClinic.mappper.ExaminationMapper;
import com.example.doctorClinic.model.Examination;
import com.example.doctorClinic.model.Users;
import com.example.doctorClinic.repo.ExaminationRepo;
import com.example.doctorClinic.repo.UsersRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExaminationService {

    private final ExaminationRepo examinationRepo;
    private final UsersRepo usersRepo;

    private final ExaminationMapper examinationMapper;

    public ExaminationService(ExaminationRepo examinationRepo, UsersRepo usersRepo, ExaminationMapper examinationMapper) {
        this.examinationRepo = examinationRepo;
        this.usersRepo = usersRepo;
        this.examinationMapper = examinationMapper;
    }

    public ExaminationResponseDto save(ExaminationRequestDto examinationRequestDto) {

        Examination examination= examinationRepo.save(examinationMapper.toExamination(examinationRequestDto));
        return examinationMapper.toExaminationResponseDto(examination);
    }

    public List<ExaminationResponseDto> findAllByUsersId(int id) {
        List<Examination>examinationList=examinationRepo.findAllByUsersId(id);
        if(examinationList.isEmpty())throw new NotFound("NoFound Examination");

        return examinationList.stream()
                .map(examinationMapper::toExaminationResponseDto)
                .toList();

    }

    public ExaminationResponseDto update(ExaminationUpdateRequestDto examinationUpdateRequestDto) {
        if(!checkExamination(examinationUpdateRequestDto.getId()))throw new NotFound("Treatment Id Not Found");
        if(usersRepo.findById(examinationUpdateRequestDto.getUsers().getId()).isEmpty())throw new NotFound("This User Not Exist");
        Examination examination= examinationRepo.save(examinationMapper.toExamination(examinationUpdateRequestDto));
        return examinationMapper.toExaminationResponseDto(examination);
    }

    public void deleteById(int id) {
        if(!checkExamination(id))throw new NotContent("ID Treatment Not Found");
        examinationRepo.deleteById(id);
    }

    public ExaminationResponseDto findById(int id){
        if(!checkExamination(id))throw new NotFound("Id Examination Not Found");
        return examinationMapper.toExaminationResponseDto(examinationRepo.findById(id).get());
    }
    private boolean checkExamination(int id){
        return examinationRepo.findById(id).isPresent();
    }


}
