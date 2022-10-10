package com.example.imy_server.Domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class User {

    @Id
    private Long user_id;
    private Long user_pw;
    private String user_name;
    private String user_phone;
    private String user_auth;
}
