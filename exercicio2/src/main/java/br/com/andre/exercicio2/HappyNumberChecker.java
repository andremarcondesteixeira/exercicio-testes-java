package br.com.andre.exercicio2;

import java.util.ArrayList;
import java.util.List;

public class HappyNumberChecker {
	public int getSquare(int n) {
        return n * n;
	}

	public List<Integer> digitsOf(int n) {
        var digits = new ArrayList<Integer>();
        while(n >= 1) {
            digits.add(n % 10);
            n /= 10;
        };
        return digits;
    }

	public int sum(ArrayList<Integer> list) {
		return list.stream().reduce((previous, sum) -> previous + sum).orElse(0);
	}
}