package br.com.andre.exercicio2.business;

import java.util.List;

import lombok.Getter;

@Getter
public class Step {
    private List<Integer> digits;
    private int result;

    public Step(List<Integer> digits, int result) {
        this.digits = digits;
        this.result = result;
    }
}