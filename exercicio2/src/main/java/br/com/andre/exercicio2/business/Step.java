package br.com.andre.exercicio2.business;

import java.util.List;

import lombok.Getter;

@Getter
public class Step {
    private List<Long> digits;
    private long result;

    public Step(List<Long> digits, long result) {
        this.digits = digits;
        this.result = result;
    }
}