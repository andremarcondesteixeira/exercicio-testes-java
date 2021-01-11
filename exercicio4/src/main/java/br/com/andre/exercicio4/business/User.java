package br.com.andre.exercicio4.business;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {
    private final String name;
    private final ZipCode zipCode;
}