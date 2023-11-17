package com.example.User_Service.Controller;

import com.example.User_Service.Data.Repostiory.UserRepo;
import com.example.User_Service.Model.Request.CreateUserRequest;
import com.example.User_Service.Model.Response.CreateUserResponse;
import com.example.User_Service.Service.IService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/hii")
    public String Hello(){

        return "Hello User";
    }
    @PostMapping("/save")
    ResponseEntity<CreateUserResponse> saveUser(@RequestBody CreateUserRequest createUserRequest){
        return userService.saveUser(createUserRequest);
    }
}
