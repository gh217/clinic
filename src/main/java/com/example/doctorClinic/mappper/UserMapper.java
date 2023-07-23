package com.example.doctorClinic.mappper;

import com.example.doctorClinic.dto.UsersRequestDto;
import com.example.doctorClinic.dto.UsersUpdateRequestDto;
import com.example.doctorClinic.model.Users;
import jakarta.persistence.Column;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UserMapper {

    public Users toUsers(UsersRequestDto usersRequestDto){
        Users users=new Users();
        users.setName(usersRequestDto.getName());
        users.setAge(usersRequestDto.getAge());
        users.setDate(new Date());
        return users;
    }

    public Users toUsers(UsersUpdateRequestDto usersUpdateRequestDto){
        Users users=new Users();
        users.setId(usersUpdateRequestDto.getId());
        users.setName(usersUpdateRequestDto.getName());
        users.setAge(usersUpdateRequestDto.getAge());
        return users;
    }
}
