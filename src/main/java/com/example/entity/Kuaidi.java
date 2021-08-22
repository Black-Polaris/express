package com.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Timestamp;


@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Kuaidi implements Serializable {
    private int id;
    private String kuaidiNum;
    private String username;
    private String phone;
    private String sendAddress;
    private String receiveName;
    private String receivePhone;
    private String receiveAddress;
    private String kuaidiType;
    private Timestamp createTime;
}
