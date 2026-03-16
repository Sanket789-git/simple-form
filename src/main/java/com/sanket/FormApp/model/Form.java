package com.sanket.FormApp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private String phoneNo;
    private String email;
    private String password;
    private LocalDate dob;
    private String gender;
    private String subscription;
    private String comment;

    private String imageName;
    private String imageUrl;
    private String imageType;

}
