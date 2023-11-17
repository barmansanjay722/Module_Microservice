package com.example.User_Service.Data.Entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "LastName")
    private String lastName;
    @Column(name = "Email")
    private String email;
    @Column(name = "PhoneNumber")
    private  String phoneNumber;
    @Column(name = "Role")
    private String role;
    @Column (name = "ModifiedAt")
    private Date modifiedAt;
    @Column(name = "CreatedAt")
    private Date createdAt;

}
