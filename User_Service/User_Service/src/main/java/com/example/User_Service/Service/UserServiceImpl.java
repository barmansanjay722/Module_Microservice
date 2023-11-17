package com.example.User_Service.Service;

import com.example.User_Service.Data.Entites.User;
import com.example.User_Service.Data.Repostiory.UserRepo;
import com.example.User_Service.Model.Request.CreateUserRequest;
import com.example.User_Service.Model.Response.CreateUserResponse;
import com.example.User_Service.Service.IService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public ResponseEntity<CreateUserResponse> saveUser(CreateUserRequest createUserRequest) {
        User user = new User();
        CreateUserResponse createUserResponse = new CreateUserResponse();
        user.setFirstName(createUserRequest.getFirstName());;
        user.setLastName(createUserRequest.getLastName());
        user.setEmail(createUserRequest.getEmail());
        user.setRole(createUserRequest.getRole());
        user.setPhoneNumber(createUserRequest.getPhoneNumber());
        user.setCreatedAt(new Date());
        user.setModifiedAt(new Date());
        userRepo.save(user);
        createUserResponse.setMessage("Saved Successfully");
        return new ResponseEntity<>(createUserResponse, HttpStatus.CREATED);

    }
}
