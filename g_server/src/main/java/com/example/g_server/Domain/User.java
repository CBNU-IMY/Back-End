package com.example.g_server.Domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.TypeAlias;

import javax.persistence.*;


@Entity
@Getter
@Setter
public class User {

    @Id
    private int user_id;
    private int user_pw;
    private String user_phone;
    private String user_auth;
}
