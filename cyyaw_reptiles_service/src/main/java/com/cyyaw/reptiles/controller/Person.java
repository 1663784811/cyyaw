package com.cyyaw.reptiles.controller;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Person {
    @Id
    String id;
    String firstname;
    String lastname;
}