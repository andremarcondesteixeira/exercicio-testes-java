package br.com.andre.exercicio1;

import java.util.Set;

public interface OfRelationshipBetweenNumbers {
    OfRelationshipCalculator of(long operand);

    OfRelationshipCalculator ofAll(Set<Long> baseOperands);

    OfRelationshipCalculator ofAny(Set<Long> operands);
}