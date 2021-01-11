package br.com.andre.exercicio3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class Word_Tests {
	@Test
	void Value_Of_Word() {
		assertEquals(1176, new Word("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUV").value());
		assertEquals(68, new Word("André").value());
	}

	@Test
	void Using_Space_Throws_Exception() {
		Exception e = assertThrows(IllegalArgumentException.class, () -> {
			new Word("André Marcondes Teixeira");
		});

		assertEquals("More than one word provided", e.getMessage());;
	}

	@Test
	void Special_Characters_Have_No_Value() {
		assertEquals(27, new Word("A__-@#!@$").value());
	}
}