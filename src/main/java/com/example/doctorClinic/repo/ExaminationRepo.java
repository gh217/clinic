package com.example.doctorClinic.repo;

import com.example.doctorClinic.model.Examination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExaminationRepo extends JpaRepository<Examination,Integer> {

    List<Examination>findAllByUsersId(Integer usersId);

}
