package br.com.andre.exercicio2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Exercicio2Tests {
	private HappyNumberVerifier verifier;

	@BeforeEach
	public void setUp() {
		verifier = new HappyNumberVerifier(130);
	}

	@Test
	public void Constructor_Sets_Number() {
		assertEquals(130, verifier.getNumber());
	}

	@Test
	public void Get_Digits_Of_Number() {
		List<Integer> digits = verifier.digits(175);
		assertEquals(3, digits.size());
		assertTrue(digits.contains(1));
		assertTrue(digits.contains(7));
		assertTrue(digits.contains(5));
	}

	@Test
	public void Sum_Squares_Of_A_List() {
		int sum = verifier.sumOfSquares(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5)));
		assertEquals(55, sum);
	}

	@Test
	public void Watch_For_Repeated_Number() {
		
	}
}