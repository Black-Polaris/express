package com.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Kuaidichange implements Serializable {
    private String kuaidiNum;
    private String currentArea;
    private String nextArea;
}
