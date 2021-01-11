package br.com.andre.exercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

public class MultiplesCalculator implements OfRelationshipCalculator {
    private final Set<Long> baseOperands;
    private List<Long> multiples = new ArrayList<Long>();
    private @Getter @Setter MultiplesCalculationStrategy calculationStrategy;

    public MultiplesCalculator( //
            Set<Long> baseOperands, //
            MultiplesCalculationStrategy calculationStrategy //
    ) throws IllegalArgumentException {
        checkParameters(baseOperands, calculationStrategy);
        this.baseOperands = baseOperands;
        this.calculationStrategy = calculationStrategy;
    }

    private void checkParameters( //
            Set<Long> operands, //
            MultiplesCalculationStrategy strategy //
    ) throws IllegalArgumentException {
        if (operands == null || operands.size() == 0)
            throw new IllegalArgumentException("At least 1 operand must be provided");

        if (operands.contains(0l))
            throw new IllegalArgumentException("Zero is not allowed as operand");

        if (strategy == null)
            throw new IllegalArgumentException("No calculation strategy provided");
    }

    public OfRelationshipCalculationResult until(long limit) {
        multiples = calculationStrategy.calculateMultiples(limit, baseOperands);
        return new MultiplesCalculationResult(multiples);
    }

    public long[] getBaseOperands() {
        return baseOperands.stream().mapToLong(x -> x).toArray();
    }

    @Override
    public boolean isMultiple(long value) {
        return calculationStrategy.isMultiple(value, baseOperands);
    }
}