package br.com.andre.exercicio1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Exercicio1_Tests {
    @Test
    public void pergunta1() {
        int respostaPergunta1 = new Multiples().ofAny(new int[] { 3, 5 }).until(999).sum();
        assertEquals(233168, respostaPergunta1);
    }

    @Test
    public void pergunta2() {
        int respostaPergunta2 = new Multiples().ofAll(new int[] { 3, 5 }).until(999).sum();
        assertEquals(33165, respostaPergunta2);
    }

    @Test
    public void pergunta3() {
        int respostaPergunta3 = new Multiples().ofAny(new int[] { 3, 5 }).until(999).sum();
        respostaPergunta3 += new Multiples().of(7).until(999).sum();
        assertEquals(304239, respostaPergunta3);
    }
}