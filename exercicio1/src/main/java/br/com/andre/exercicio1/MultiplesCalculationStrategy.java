package br.com.andre.exercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public interface MultiplesCalculationStrategy {
    boolean isMultiple(long number, Set<Long> baseOperands);

    default List<Long> calculateMultiples(long until, Set<Long> baseOperands) {
        var multiples = new ArrayList<Long>();
        long number;

        if (until > 0) {
            for (number = 1; number <= until; number++)
                if (isMultiple(number, baseOperands))
                    multiples.add(number);
        } else if (until < 0)
            for (number = -1; number >= until; number--)
                if (isMultiple(number, baseOperands))
                    multiples.add(number);

        return multiples;
    };
}