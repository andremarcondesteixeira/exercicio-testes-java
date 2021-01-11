package br.com.andre.exercicio1;

public interface OfRelationshipCalculator {
    OfRelationshipCalculationResult until(long limit);

    long[] getBaseOperands();

    MultiplesCalculationStrategy getCalculationStrategy();

	boolean isMultiple(long value);
}