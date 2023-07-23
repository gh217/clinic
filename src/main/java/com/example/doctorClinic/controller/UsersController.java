package com.example.doctorClinic.controller;

import com.example.doctorClinic.dto.UsersRequestDto;
import com.example.doctorClinic.dto.UsersUpdateRequestDto;
import com.example.doctorClinic.exception.BadRequest;
import com.example.doctorClinic.model.Users;
import com.example.doctorClinic.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping
    public Users addUsers(@RequestBody UsersRequestDto usersRequestDto){
        if(usersRequestDto ==null)throw new BadRequest("Not Null");
        return usersService.addUser(usersRequestDto);
    }

    @GetMapping("/{id}")
    public Users findById(@PathVariable int id){
        return usersService.findById(id);
    }

    @GetMapping("/findByName/{name}")
    public List<Users> findByName(@PathVariable String name){
        return usersService.findByName(name);
    }

    @PutMapping
    public Users users(@RequestBody UsersUpdateRequestDto usersUpdateRequestDto){
        if(usersUpdateRequestDto==null)throw new BadRequest("Null");
        return usersService.updateUsers(usersUpdateRequestDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUsers(@PathVariable int id){
        usersService.deleteUsers(id);
    }
}
