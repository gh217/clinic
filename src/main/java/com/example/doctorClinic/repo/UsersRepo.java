package com.example.doctorClinic.repo;

import com.example.doctorClinic.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepo extends JpaRepository<Users,Integer> {

    @Query("select u from Users u where u.name like %:name%")
    List<Users> findByName(String name);
}
