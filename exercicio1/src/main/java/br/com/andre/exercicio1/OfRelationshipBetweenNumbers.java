package br.com.andre.exercicio1;

import java.util.Set;

public interface OfRelationshipBetweenNumbers {
    OfRelationshipCalculator of(int operand);

    OfRelationshipCalculator ofAll(Set<Integer> baseOperands);

    OfRelationshipCalculator ofAny(Set<Integer> operands);
}