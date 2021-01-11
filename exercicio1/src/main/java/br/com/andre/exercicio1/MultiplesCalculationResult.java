package br.com.andre.exercicio1;

import java.util.List;

public class MultiplesCalculationResult implements OfRelationshipCalculationResult {
    private List<Long> multiples;

    public MultiplesCalculationResult(List<Long> multiples) {
        this.multiples = multiples;
	}

	@Override
    public long[] get() {
        return multiples.stream().mapToLong(x -> x).toArray();
    }

    @Override
    public long sum() {
        return multiples.stream().reduce((prev, total) -> prev + total).get();
    }
}