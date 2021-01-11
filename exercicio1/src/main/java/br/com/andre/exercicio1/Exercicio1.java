package br.com.andre.exercicio1;

public final class Exercicio1 {
	public static void main(String[] args) {
		long soma1 = new Multiples().ofAny(new long[] { 3, 5 }).until(999).sum();
		System.out.println("A soma de todos os múltiplos de 3 ou 5 abaixo de 1000 é " + soma1);

		long soma2 = new Multiples().ofAll(new long[] { 3, 5 }).until(999).sum();
		System.out.println("A soma de todos os múltiplos de 3 e 5 abaixo de 1000 é " + soma2);

		long soma3 = soma1 + new Multiples().of(7).until(999).sum();
		System.out.println("A soma de todos os múltiplos de (3 ou 5) e 7 abaixo de 1000 é " + soma3);
	}
}