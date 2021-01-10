package br.com.andre.exercicio1;

import java.util.List;

public class MultiplesCalculationResult implements OfRelationshipCalculationResult {
    private List<Integer> multiples;

    public MultiplesCalculationResult(List<Integer> multiples) {
        this.multiples = multiples;
	}

	@Override
    public int[] get() {
        return multiples.stream().mapToInt(x -> x).toArray();
    }

    @Override
    public int sum() {
        return multiples.stream().reduce((prev, total) -> prev + total).get();
    }
}