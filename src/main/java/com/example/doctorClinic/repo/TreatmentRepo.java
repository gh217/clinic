package com.example.doctorClinic.repo;

import com.example.doctorClinic.model.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreatmentRepo extends JpaRepository<Treatment,Integer> {

    List<Treatment>findAllByExaminationId(int id);
}
