package com.example.springgumball;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class GumballModel {
    private String modelNumber ;
    private String serialNumber ;
    private Integer countGumballs ;
}