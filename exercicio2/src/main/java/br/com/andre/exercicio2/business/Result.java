package br.com.andre.exercicio2.business;

import java.util.List;

import lombok.Getter;

public class Result {
    private final @Getter boolean isHappy;
    private final @Getter List<Step> steps;

	public Result(boolean isHappy, List<Step> steps) {
        this.isHappy = isHappy;
        this.steps = steps;
    }
}