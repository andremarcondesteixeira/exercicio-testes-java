package br.com.andre.exercicio1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Exercicio1_Tests {
    @Test
    void pergunta1() {
        long respostaPergunta1 = new Multiples().ofAny(new long[] { 3, 5 }).until(999).sum();
        assertEquals(233168, respostaPergunta1);
    }

    @Test
    void pergunta2() {
        long respostaPergunta2 = new Multiples().ofAll(new long[] { 3, 5 }).until(999).sum();
        assertEquals(33165, respostaPergunta2);
    }

    @Test
    void pergunta3() {
        long respostaPergunta3 = new Multiples().ofAny(new long[] { 3, 5 }).until(999).sum();
        respostaPergunta3 += new Multiples().of(7).until(999).sum();
        assertEquals(304239, respostaPergunta3);
    }
}