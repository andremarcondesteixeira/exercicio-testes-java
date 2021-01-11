package br.com.andre.exercicio4.business;

import lombok.Data;

@Data
public class User {
    private final String name;
    private final ZipCode zipCode;
}