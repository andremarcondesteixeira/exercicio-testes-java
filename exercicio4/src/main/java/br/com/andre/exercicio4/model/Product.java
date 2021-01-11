package br.com.andre.exercicio4.model;

import lombok.Data;

@Data
public class Product {
    private final String name;
    private final Money value;

    public Product(String name, Money value) {
        this.name = name;
        this.value = new Money(value.getValue());
    }
}