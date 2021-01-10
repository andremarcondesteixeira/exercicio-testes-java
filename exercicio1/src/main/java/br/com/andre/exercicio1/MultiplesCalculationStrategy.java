package br.com.andre.exercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public interface MultiplesCalculationStrategy {
    boolean isMultiple(int number, Set<Integer> baseOperands);

    default List<Integer> calculateMultiples(int until, Set<Integer> baseOperands) {
        var multiples = new ArrayList<Integer>();
        int number;

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