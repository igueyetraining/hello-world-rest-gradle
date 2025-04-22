package com.igueyetraining.helloworldrestapis.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private String username;
    private String firstname;
    private String lastname;
    private int age;

    
}
