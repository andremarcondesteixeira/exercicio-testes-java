package br.com.andre.exercicio2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.spy;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HappyNumberVerifier_Tests {
	private HappyNumberVerifier verifier;

	@BeforeEach
	public void setUp() {
		verifier = spy(new HappyNumberVerifier(130));
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
		List<Step> steps = verifier.getSteps();
		Step previous = steps.get(0);
		assertEquals(1, steps.size());
		assertEquals(3, previous.getDigits().size());
		assertEquals(0, previous.getDigits().get(0));
		assertEquals(3, previous.getDigits().get(1));
		assertEquals(1, previous.getDigits().get(2));
		assertEquals(10, previous.getResult());
	}

	@Test
	public void Happy_Path() {
		var verifier = new HappyNumberVerifier(7);
		boolean isHappy = verifier.verify();
		assertTrue(isHappy);
	}

	@Test
	public void Watch_For_Repeated_Number() {
		var verifier = new HappyNumberVerifier(4);
		verifier.step();
		assertEquals(16, verifier.getNumber());

		for (var i = 0; i < 8; i++)
			verifier.step();

		assertEquals(16, verifier.getNumber()); // repeated number = not happy number
		assertTrue(verifier.currentStepIsRepeated());
	}

	@Test
	public void Sad_Path() {
		var verifier = new HappyNumberVerifier(4);
		boolean isHappy = verifier.verify();
		assertFalse(isHappy);
	}

	@Test
	public void Negative_Parameter_Throws_Exception() {
		Exception e = assertThrows(IllegalArgumentException.class, () -> {
			new HappyNumberVerifier(-7);
		});
		assertEquals("Happy numbers must be positive integers", e.getMessage());
	}

	@Test
	public void Zero_Is_Not_A_Happy_Number() {
		var verifier = new HappyNumberVerifier(0);
		boolean isHappy = verifier.verify();
		assertFalse(isHappy);
	}
}