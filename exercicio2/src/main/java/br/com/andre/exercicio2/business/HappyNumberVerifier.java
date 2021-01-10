package br.com.andre.exercicio2.business;

import java.util.ArrayList;
import java.util.List;

public class HappyNumberVerifier {
	private int number;
	private List<Integer> digits;
	private boolean repeated;
	private List<Step> steps;

	public Result verify(int n) throws IllegalArgumentException {
		initialize(n);
		boolean isHappy = calculate(n);
		return new Result(isHappy, steps);
	}

	private void initialize(int n) {
		if (n < 0)
			throw new IllegalArgumentException("Happy numbers must be positive integers");

		digits = new ArrayList<Integer>();
		steps = new ArrayList<Step>();
		repeated = false;
		number = n;
	}

	private boolean calculate(int n) {
		if (number == 1) {
			return true;
		} else if (repeated || n == 0) {
			return false;
		} else {
			step();
			return calculate(number);
		}
	}

	private void step() {
		extractDigits();
		sumSquares();
		repeated |= currentStepIsRepeated();
		steps.add(new Step(digits, number));
	}

	private void extractDigits() {
		digits.clear();
		while (number >= 1) {
			digits.add(number % 10);
			number /= 10;
		}
	}

	private void sumSquares() {
		number = digits.stream().map(n -> {
			return n * n;
		}).reduce((previous, sum) -> {
			return previous + sum;
		}).orElse(0);
	}

	private boolean currentStepIsRepeated() {
		return steps.stream().filter(step -> step.getResult() == number).count() >= 1;
	}
}