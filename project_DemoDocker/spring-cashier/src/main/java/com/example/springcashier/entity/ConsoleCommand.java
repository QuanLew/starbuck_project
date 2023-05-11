package com.example.springcashier.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ConsoleCommand {

    private String action ;
    private String cardnum ;
    private String cardcode ;
    private String message ;

}

