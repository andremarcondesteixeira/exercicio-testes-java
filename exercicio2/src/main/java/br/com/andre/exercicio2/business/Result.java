package br.com.andre.exercicio2.business;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class Result {
    private final long number;
    private final boolean isHappy;
    private final List<Step> steps;
}