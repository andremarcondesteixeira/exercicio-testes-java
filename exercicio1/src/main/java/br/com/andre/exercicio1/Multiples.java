package br.com.andre.exercicio1;

import java.util.HashSet;
import java.util.Set;

// Abstract Factory design pattern
// 100% SOLID
public final class Multiples implements OfRelationshipBetweenNumbers {
    public OfRelationshipCalculator of(int operand) {
        var baseOperands = new HashSet<Integer>();
        baseOperands.add(operand);
        return new MultiplesCalculator(baseOperands, new MultiplesOfAll());
    }

    public OfRelationshipCalculator ofAll(int[] operands) {
        Set<Integer> baseOperands = createOperandsSet(operands);
        return ofAll(baseOperands);
    }

    public OfRelationshipCalculator ofAll(Set<Integer> baseOperands) {
        return new MultiplesCalculator(baseOperands, new MultiplesOfAll());
    }

    public OfRelationshipCalculator ofAny(int[] operands) {
        Set<Integer> baseOperands = createOperandsSet(operands);
        return ofAny(baseOperands);
    }

    public OfRelationshipCalculator ofAny(Set<Integer> operands) {
        return new MultiplesCalculator(operands, new MultiplesOfAny());
    }

    private Set<Integer> createOperandsSet(int[] operands) {
        var baseOperands = new HashSet<Integer>();

        for (var i = 0; i < operands.length; i++) {
            baseOperands.add(operands[i]);
        }

        return baseOperands;
    }
}