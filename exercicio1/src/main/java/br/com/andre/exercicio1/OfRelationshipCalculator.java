package br.com.andre.exercicio1;

public interface OfRelationshipCalculator {
    OfRelationshipCalculationResult until(int limit);

    int[] getBaseOperands();

    MultiplesCalculationStrategy getCalculationStrategy();
}