package com.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Expressarea implements Serializable {
    private String areaName;
    private String manageName;
    private String areaPhone;
    private String address;
    private String area;
}
