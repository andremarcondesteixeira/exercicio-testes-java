package br.com.andre.exercicio1;

import java.util.HashSet;
import java.util.Set;

import lombok.NoArgsConstructor;

// Abstract Factory design pattern
// 100% SOLID
@NoArgsConstructor
public final class Multiples implements OfRelationshipBetweenNumbers {
    public OfRelationshipCalculator of(long operand) {
        var baseOperands = new HashSet<Long>();
        baseOperands.add(operand);
        return new MultiplesCalculator(baseOperands, new MultiplesOfAll());
    }

    public OfRelationshipCalculator ofAll(long[] operands) {
        Set<Long> baseOperands = createOperandsSet(operands);
        return ofAll(baseOperands);
    }

    public OfRelationshipCalculator ofAll(Set<Long> baseOperands) {
        return new MultiplesCalculator(baseOperands, new MultiplesOfAll());
    }

    public OfRelationshipCalculator ofAny(long[] operands) {
        Set<Long> baseOperands = createOperandsSet(operands);
        return ofAny(baseOperands);
    }

    public OfRelationshipCalculator ofAny(Set<Long> operands) {
        return new MultiplesCalculator(operands, new MultiplesOfAny());
    }

    private Set<Long> createOperandsSet(long[] operands) {
        var baseOperands = new HashSet<Long>();

        for (var i = 0; i < operands.length; i++) {
            baseOperands.add(operands[i]);
        }

        return baseOperands;
    }
}