package com.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@NoArgsConstructor
@Data
@Accessors(chain = true)
public class User implements Serializable {
    private int id;
    private String username;
    private String userid;
    private String password;
    private String phone;
    private String permission;

}
