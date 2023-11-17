package com.example.User_Service.Service.IService;

import com.example.User_Service.Model.Request.CreateUserRequest;
import com.example.User_Service.Model.Response.CreateUserResponse;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<CreateUserResponse> saveUser(CreateUserRequest createUserRequest);

}
