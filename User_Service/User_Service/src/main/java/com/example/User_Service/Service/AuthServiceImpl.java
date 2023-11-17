package com.example.User_Service.Service;

import com.example.User_Service.Model.Request.AuthRequest;
import com.example.User_Service.Service.IService.AuthService;
import com.example.User_Service.Util.JwtUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
@AllArgsConstructor

public class AuthServiceImpl implements AuthService {

 private final RestTemplate restTemplate;
 private final JwtUtils jwtUtils;

 public String register(AuthRequest authRequest){
  return null;
 }
}
