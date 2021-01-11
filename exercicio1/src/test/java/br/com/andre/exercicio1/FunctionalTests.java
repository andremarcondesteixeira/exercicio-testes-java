package br.com.andre.exercicio1;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FunctionalTests {
	@Test
	void of_Positive_Number_Positive_Limit() {
		int[] multiplesOfSevenUntilSeventy = new Multiples().of(7).until(70).get();
		int[] expectedForSeven = { 7, 14, 21, 28, 35, 42, 49, 56, 63, 70 };
		assertArrayEquals(expectedForSeven, multiplesOfSevenUntilSeventy);
	}

	@Test
	void of_Positive_Number_Negative_Limit() {
		int[] multiplesOfSevenUntilSeventy = new Multiples().of(7).until(-70).get();
		int[] expectedForSeven = { -7, -14, -21, -28, -35, -42, -49, -56, -63, -70 };
		assertArrayEquals(expectedForSeven, multiplesOfSevenUntilSeventy);
	}

	@Test
	void of_Negative_Number_Positive_Limit() {
		int[] multiplesOfSevenUntilSeventy = new Multiples().of(-7).until(70).get();
		int[] expectedForSeven = { 7, 14, 21, 28, 35, 42, 49, 56, 63, 70 };
		assertArrayEquals(expectedForSeven, multiplesOfSevenUntilSeventy);
	}

	@Test
	void of_Negative_Number_Negative_Limit() {
		int[] multiplesOfSevenUntilSeventy = new Multiples().of(-7).until(-70).get();
		int[] expectedForSeven = { -7, -14, -21, -28, -35, -42, -49, -56, -63, -70 };
		assertArrayEquals(expectedForSeven, multiplesOfSevenUntilSeventy);
	}

	@Test
	void of_Positive_Number_Positive_Limit_Sum() {
		int sum = new Multiples().of(5).until(25).sum();
		assertEquals(75, sum);
	}

	@Test
	void of_Positive_Number_Negative_Limit_Sum() {
		int sum = new Multiples().of(5).until(-25).sum();
		assertEquals(-75, sum);
	}

	@Test
	void of_Negative_Number_Positive_Limit_Sum() {
		int sum = new Multiples().of(-5).until(25).sum();
		assertEquals(75, sum);
	}

	@Test
	void of_Negative_Number_Negative_Limit_Sum() {
		int sum = new Multiples().of(5).until(-25).sum();
		assertEquals(-75, sum);
	}

	@Test
	void ofAll_Positive_Numbers_Positive_Limit() {
		int[] multiplesOfSevenUntilSeventy = new Multiples().ofAll(new int[] { 3, 5 }).until(30).get();
		int[] expectedForSeven = { 15, 30 };
		assertArrayEquals(expectedForSeven, multiplesOfSevenUntilSeventy);
	}

	@Test
	void ofAll_Positive_Numbers_Negative_Limit() {
		int[] multiplesOfSevenUntilSeventy = new Multiples().ofAll(new int[] { 3, 5 }).until(-30).get();
		int[] expectedForSeven = { -15, -30 };
		assertArrayEquals(expectedForSeven, multiplesOfSevenUntilSeventy);
	}

	@Test
	void ofAll_Negative_Numbers_Positive_Limit() {
		int[] multiplesOfSevenUntilSeventy = new Multiples().ofAll(new int[] { -3, -5 }).until(30).get();
		int[] expectedForSeven = { 15, 30 };
		assertArrayEquals(expectedForSeven, multiplesOfSevenUntilSeventy);
	}

	@Test
	void ofAll_Negative_Numbers_Negative_Limit() {
		int[] multiplesOfSevenUntilSeventy = new Multiples().ofAll(new int[] { -3, 5 }).until(-30).get();
		int[] expectedForSeven = { -15, -30 };
		assertArrayEquals(expectedForSeven, multiplesOfSevenUntilSeventy);
	}

	@Test
	void ofAll_Positive_Numbers_Positive_Limit_Sum() {
		int sum = new Multiples().ofAll(new int[] { 2, 3 }).until(20).sum();
		assertEquals(36, sum);
	}

	@Test
	void ofAll_Positive_Numbers_Negative_Limit_Sum() {
		int sum = new Multiples().ofAll(new int[] { 2, 3 }).until(-20).sum();
		assertEquals(-36, sum);
	}

	@Test
	void ofAll_Negative_Numbers_Positive_Limit_Sum() {
		int sum = new Multiples().ofAll(new int[] { -2, -3 }).until(20).sum();
		assertEquals(36, sum);
	}

	@Test
	void ofAll_Negative_Numbers_Negative_Limit_Sum() {
		int sum = new Multiples().ofAll(new int[] { -2, -3 }).until(-20).sum();
		assertEquals(-36, sum);
	}

	@Test
	void ofAny_Positive_Numbers_Positive_Limit() {
		int[] multiplesOfSevenUntilSeventy = new Multiples().ofAny(new int[] { 3, 5 }).until(30).get();
		int[] expectedForSeven = { 3, 5, 6, 9, 10, 12, 15, 18, 20, 21, 24, 25, 27, 30 };
		assertArrayEquals(expectedForSeven, multiplesOfSevenUntilSeventy);
	}

	@Test
	void ofAny_Positive_Numbers_Negative_Limit() {
		int[] multiplesOfSevenUntilSeventy = new Multiples().ofAny(new int[] { 3, 5 }).until(-30).get();
		int[] expectedForSeven = { -3, -5, -6, -9, -10, -12, -15, -18, -20, -21, -24, -25, -27, -30 };
		assertArrayEquals(expectedForSeven, multiplesOfSevenUntilSeventy);
	}

	@Test
	void ofAny_Negative_Numbers_Positive_Limit() {
		int[] multiplesOfSevenUntilSeventy = new Multiples().ofAny(new int[] { -3, -5 }).until(30).get();
		int[] expectedForSeven = { 3, 5, 6, 9, 10, 12, 15, 18, 20, 21, 24, 25, 27, 30 };
		assertArrayEquals(expectedForSeven, multiplesOfSevenUntilSeventy);
	}

	@Test
	void ofAny_Negative_Numbers_Negative_Limit() {
		int[] multiplesOfSevenUntilSeventy = new Multiples().ofAny(new int[] { -3, 5 }).until(-30).get();
		int[] expectedForSeven = { -3, -5, -6, -9, -10, -12, -15, -18, -20, -21, -24, -25, -27, -30 };
		assertArrayEquals(expectedForSeven, multiplesOfSevenUntilSeventy);
	}

	@Test
	void ofAny_Positive_Numbers_Positive_Limit_Sum() {
		int sum = new Multiples().ofAny(new int[] { 2, 3 }).until(20).sum();
		assertEquals(137, sum);
	}

	@Test
	void ofAny_Positive_Numbers_Negative_Limit_Sum() {
		int sum = new Multiples().ofAny(new int[] { 2, 3 }).until(-20).sum();
		assertEquals(-137, sum);
	}

	@Test
	void ofAny_Negative_Numbers_Positive_Limit_Sum() {
		int sum = new Multiples().ofAny(new int[] { -2, -3 }).until(20).sum();
		assertEquals(137, sum);
	}

	@Test
	void ofAny_Negative_Numbers_Negative_Limit_Sum() {
		int sum = new Multiples().ofAny(new int[] { -2, -3 }).until(-20).sum();
		assertEquals(-137, sum);
	}
}