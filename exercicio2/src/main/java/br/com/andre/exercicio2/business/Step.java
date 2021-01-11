package br.com.andre.exercicio2.business;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class Step {
    private final List<Long> digits;
    private final long result;
}