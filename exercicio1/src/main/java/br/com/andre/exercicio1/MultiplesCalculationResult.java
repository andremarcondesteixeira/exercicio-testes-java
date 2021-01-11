package br.com.andre.exercicio1;

import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MultiplesCalculationResult implements OfRelationshipCalculationResult {
    private List<Long> multiples;

    public @Override long[] get() {
        return multiples.stream().mapToLong(x -> x).toArray();
    }

    public @Override long sum() {
        return multiples.stream().reduce((prev, total) -> prev + total).get();
    }
}