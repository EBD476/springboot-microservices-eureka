package com.rad.springboot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Annotations
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "User")

public class User {
    
    @Id
    private String id;
    private String username;
    private String password;
}
