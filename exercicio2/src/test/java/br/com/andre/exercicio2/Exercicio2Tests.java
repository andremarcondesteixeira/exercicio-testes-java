package br.com.andre.exercicio2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Exercicio2Tests {
	private HappyNumberVerifier happyNumber;

	@BeforeEach
	public void setUp() {
		happyNumber = new HappyNumberVerifier(130);
	}

	@Test
	public void Constructor_Sets_Number_To_Check() {
		assertEquals(130, happyNumber.getNumberToBeVerified());
	}

	@Test
	public void Get_Square_Of_Number() {
		int square = happyNumber.getSquare(2);
		assertEquals(4, square);
	}

	@Test
	public void Get_Digits_Of_Number() {
		List<Integer> digits = happyNumber.digitsOf(175);
		assertEquals(3, digits.size());
		assertTrue(digits.contains(1));
		assertTrue(digits.contains(7));
		assertTrue(digits.contains(5));
	}

	@Test
	public void Sum_Numbers_Of_A_List() {
		int sum = happyNumber.sum(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5)));
		assertEquals(15, sum);
	}

	@Test
	public void Watch_For_Repeated_Number() {
		
	}
}