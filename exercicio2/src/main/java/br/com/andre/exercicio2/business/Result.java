package br.com.andre.exercicio2.business;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Result {
    private final @Getter long number;
    private final @Getter boolean isHappy;
    private final @Getter List<Step> steps;
}