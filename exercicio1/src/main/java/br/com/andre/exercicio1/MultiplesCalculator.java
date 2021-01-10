package br.com.andre.exercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

public class MultiplesCalculator implements OfRelationshipCalculator {
    private final Set<Integer> baseOperands;
    private List<Integer> multiples = new ArrayList<Integer>();
    private @Getter @Setter MultiplesCalculationStrategy calculationStrategy;

    public MultiplesCalculator( //
            Set<Integer> baseOperands, //
            MultiplesCalculationStrategy calculationStrategy //
    ) throws IllegalArgumentException {
        checkParameters(baseOperands, calculationStrategy);
        this.baseOperands = baseOperands;
        this.calculationStrategy = calculationStrategy;
    }

    private void checkParameters( //
            Set<Integer> operands, //
            MultiplesCalculationStrategy strategy //
    ) throws IllegalArgumentException {
        if (operands == null || operands.size() == 0)
            throw new IllegalArgumentException("At least 1 operand must be provided");

        if (operands.contains(0))
            throw new IllegalArgumentException("Zero is not allowed as operand");

        if (strategy == null)
            throw new IllegalArgumentException("No calculation strategy provided");
    }

    public OfRelationshipCalculationResult until(int limit) {
        multiples = calculationStrategy.calculateMultiples(limit, baseOperands);
        return new MultiplesCalculationResult(multiples);
    }

    public int[] getBaseOperands() {
        return baseOperands.stream().mapToInt(x -> x).toArray();
    }
}