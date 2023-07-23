package com.example.doctorClinic.service;

import com.example.doctorClinic.dto.UsersRequestDto;
import com.example.doctorClinic.dto.UsersUpdateRequestDto;
import com.example.doctorClinic.exception.NotContent;
import com.example.doctorClinic.exception.NotFound;
import com.example.doctorClinic.mappper.UserMapper;
import com.example.doctorClinic.model.Users;
import com.example.doctorClinic.repo.UsersRepo;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    private final UsersRepo usersRepo;
    private final UserMapper userMapper;

    public UsersService(UsersRepo usersRepo, UserMapper userMapper) {
        this.usersRepo = usersRepo;
        this.userMapper = userMapper;
    }

    public Users addUser( UsersRequestDto usersRequestDto){
        return usersRepo.save(userMapper.toUsers(usersRequestDto));

    }
    public Users findById( int id){
        Optional<Users> users=usersRepo.findById(id);
        if(users.isEmpty())throw new NotFound("Id Not Found");
        return users.get();
    }
    public List<Users> findByName( String name){
        List<Users> usersList=usersRepo.findByName(name);
        if(usersList.isEmpty())throw new NotFound("Name Not Found") ;
        return usersList;
    }

    public Users updateUsers(UsersUpdateRequestDto usersUpdateRequestDto){
        if(checkId(usersUpdateRequestDto.getId()))throw new NotFound("This Id Not Found");
        return usersRepo.save(userMapper.toUsers(usersUpdateRequestDto));
    }

    public void deleteUsers(int id){
        if(checkId(id))throw new NotContent("This Id Not Found");
        usersRepo.deleteById(id);
    }

    private boolean checkId(int id){
        return usersRepo.findById(id).isEmpty();
    }
}
