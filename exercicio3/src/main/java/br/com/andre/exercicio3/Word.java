package br.com.andre.exercicio3;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public final class Word {
    private final List<Character> letters;
    private final String word;
    private final String wordWithNoAccents;

    public Word(String word) {
        checkParameter(word);
        this.word = word;
        this.wordWithNoAccents = removeAccents();
        this.letters = initializeLetters();
    }

    private void checkParameter(String word) {
        if (word.contains(" "))
            throw new IllegalArgumentException("More than one word provided");
    }

    private String removeAccents() {
        String normalized = Normalizer.normalize(word, Normalizer.Form.NFD);
        Pattern regex = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return regex.matcher(normalized).replaceAll("");
    }

    private List<Character> initializeLetters() {
        var letters = new ArrayList<Character>();
        for (char c : "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUV".toCharArray())
            letters.add(c);
        return letters;
    }

    public long value() {
        long value = 0l;
        for (char c : wordWithNoAccents.toCharArray())
            value += valueOfLetter(c);
        return value;
    }

    private int valueOfLetter(char c) {
        int index = letters.indexOf(c);
        return index >= 0 ? index + 1 : 0;
    }
}