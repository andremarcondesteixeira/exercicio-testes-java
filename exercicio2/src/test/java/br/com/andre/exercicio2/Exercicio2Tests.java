package br.com.andre.exercicio2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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
		verifier.extractDigits();
		List<Integer> digits = verifier.getDigits();
		assertEquals(3, digits.size());
		assertTrue(digits.contains(1));
		assertTrue(digits.contains(3));
		assertTrue(digits.contains(0));
	}

	@Test
	public void Sum_Squares_Of_Digits() {
		verifier.extractDigits();
		verifier.sumSquares();
		assertEquals(10, verifier.getNumber());
	}

	@Test
	public void Calculation_Step() {
		verifier.step();
		assertEquals(10, verifier.getNumber());
		verifier.step();
		assertEquals(1, verifier.getNumber());
	}

	@Test
	public void Calculation_Step_Saves_Results() {
		verifier.step();
		assertEquals(1, verifier.getPreviousResults().size());
		assertTrue(verifier.getPreviousResults().contains(10));
	}

	@Test
	public void Happy_Path() {
		var verifier = new HappyNumberVerifier(7);
		boolean isHappy = verifier.verify();
		assertTrue(isHappy);
	}

	@Test
	@Disabled
	public void Watch_For_Repeated_Number() {
		var verifier = new HappyNumberVerifier(4);
		for (var i = 0; i < 8; i ++)
			verifier.step();
		
	}
}