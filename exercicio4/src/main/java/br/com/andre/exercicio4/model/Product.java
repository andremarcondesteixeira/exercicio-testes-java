package br.com.andre.exercicio4.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private final String name;
    private final Money value;
}