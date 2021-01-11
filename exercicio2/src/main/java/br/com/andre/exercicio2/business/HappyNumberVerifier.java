package br.com.andre.exercicio2.business;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class HappyNumberVerifier {
    private long number;
    private Deque<Long> digits;
    private List<Step> steps;

    public Result verify(long n) throws IllegalArgumentException {
        initialize(n);
        boolean isHappy = calculate();
        return new Result(n, isHappy, steps);
    }

    private void initialize(long n) {
        if (n < 0)
            throw new IllegalArgumentException("Happy numbers must be positive integers");

        digits = new LinkedList<Long>();
        steps = new ArrayList<Step>();
        number = n;
    }

    private boolean calculate() {
        if (number == 1) {
            return true;
        } else if (numberIsRepeated() || number == 0) {
            return false;
        } else {
            step();
            return calculate();
        }
    }

    private boolean numberIsRepeated() {
        return steps.stream().filter(step -> step.getResult() == number).count() > 1;
    }

    private void step() {
        extractDigits();
        sumSquares();
        List<Long> copyDigits = digits.stream().collect(Collectors.toList());
        steps.add(new Step(copyDigits, number));
    }

    private void extractDigits() {
        digits.clear();
        while (number >= 1) {
            digits.addFirst(number % 10);
            number /= 10;
        }
    }

    private void sumSquares() {
        number = digits.stream().map(n -> {
            return n * n;
        }).reduce((previous, sum) -> {
            return previous + sum;
        }).orElse(0l);
    }
}