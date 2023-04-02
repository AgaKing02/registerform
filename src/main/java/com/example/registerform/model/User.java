package com.example.registerform.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "usrs")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String username;
    private String password;
}
