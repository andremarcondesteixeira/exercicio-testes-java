package br.com.andre.exercicio2.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.spy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HappyNumberVerifier_Tests {
	private HappyNumberVerifier verifier;
	private final int aHappyNumber = 7;

	@BeforeEach
	public void setUp() {
		verifier = spy(new HappyNumberVerifier());
	}

	@Test
	public void Happy_Path() {
		boolean isHappy = verifier.verify(aHappyNumber);
		assertTrue(isHappy);
	}

	@Test
	public void Sad_Path() {
		boolean isHappy = verifier.verify(4);
		assertFalse(isHappy);
	}

	@Test
	public void Negative_Parameter_Throws_Exception() {
		Exception e = assertThrows(IllegalArgumentException.class, () -> {
			verifier.verify(-7);
		});
		assertEquals("Happy numbers must be positive integers", e.getMessage());
	}

	@Test
	public void Zero_Is_Not_A_Happy_Number() {
		boolean isHappy = verifier.verify(0);
		assertFalse(isHappy);
	}
}