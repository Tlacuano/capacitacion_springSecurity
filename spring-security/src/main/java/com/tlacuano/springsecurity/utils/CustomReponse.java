package com.tlacuano.springsecurity.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomReponse <T>{
    T data;
    String message;
    boolean error;
    int status;
}
