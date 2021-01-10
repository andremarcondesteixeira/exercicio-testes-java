package br.com.andre.exercicio2.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HappyNumberVerifier_Tests {
	private HappyNumberVerifier verifier;
	private final int aHappyNumber = 7;

	@BeforeEach
	public void setUp() {
		verifier = new HappyNumberVerifier();
	}

	@Test
	public void Happy_Path() {
		var expectedResults = new int[] { 49, 97, 130, 10, 1 };
		var expectedDigits = new int[][] { //
				new int[] { 7 }, //
				new int[] { 4, 9 }, //
				new int[] { 9, 7 }, //
				new int[] { 1, 3, 0 }, //
				new int[] { 1, 0 }, //
				new int[] { 1 } //
		};

		Result result = verifier.verify(aHappyNumber);

		assertEquals(aHappyNumber, result.getNumber());
		assertTrue(result.isHappy());
		assertEquals(5, result.getSteps().size());
		assertResultSteps(result, expectedResults, expectedDigits);
	}

	public void assertResultSteps(Result result, int[] expectedResults, int[][] expectedDigits) {
		List<Step> steps = result.getSteps();
		Step step;
		for (var i = 0; i < expectedResults.length; i++) {
			step = steps.get(i);
			assertEquals(expectedResults[i], step.getResult());
			for (var j = 0; j < expectedDigits[i].length; j++)
				assertEquals(expectedDigits[i][j], step.getDigits().get(j));
		}
	}

	@Test
	public void Sad_Path() {
		var expectedResults = new int[] { 16, 37, 58, 89, 145, 42, 20, 4 };
		var expectedDigits = new int[][] { //
				new int[] { 4 }, //
				new int[] { 1, 6 }, //
				new int[] { 3, 7 }, //
				new int[] { 5, 8 }, //
				new int[] { 8, 9 }, //
				new int[] { 1, 4, 5 }, //
				new int[] { 4, 2 }, //
				new int[] { 2, 0}, //
				new int[] { 4 } //
		};

		Result result = verifier.verify(4);

		assertEquals(4, result.getNumber());
		assertFalse(result.isHappy());
		assertResultSteps(result, expectedResults, expectedDigits);
	}

	@Test
	public void Zero_Is_Not_A_Happy_Number() {
		Result result = verifier.verify(0);
		assertFalse(result.isHappy());
	}

	@Test
	public void One_Is_A_Happy_Number() {
		Result result = verifier.verify(1);
		assertTrue(result.isHappy());
	}

	@Test
	public void Negative_Parameter_Throws_Exception() {
		Exception e = assertThrows(IllegalArgumentException.class, () -> {
			verifier.verify(-7);
		});
		assertEquals("Happy numbers must be positive integers", e.getMessage());
	}
}