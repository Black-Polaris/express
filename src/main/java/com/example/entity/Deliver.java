package com.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Deliver implements Serializable {
    private int id;
    private String deliverName;
    private String phone;
    private String area;
}
