package br.com.andre.exercicio2.presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import br.com.andre.exercicio2.business.Result;
import br.com.andre.exercicio2.business.Step;

public class ConsolePresentation implements Presentation {
    private String input = "";
    private BufferedReader reader;

    public ConsolePresentation() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Bem vindo ao verificador de números felizes!!! :D");
    }

    @Override
    public long getInput() throws IOException, NumberFormatException {
        System.out.println("\nDigite um número:");
        input = reader.readLine();
        return Long.parseLong(input);
    }

    @Override
    public void output(Result result) {
        showBriefing(result);
        result.getSteps().forEach(step -> {
            String calculation = getCalculation(step);
            System.out.println(calculation);
        });
    }

    private void showBriefing(Result result) {
        var isHappy = result.isHappy() ? " é" : " não é";
        var briefing = result.getNumber() + isHappy + " um número feliz";
        System.out.println(briefing);
    }

    private String getCalculation(Step step) {
        List<String> powers = getPowers(step);
        String equation = String.join(" + ", powers);
        String calculation = equation + " = " + step.getResult();
        return calculation;
    }

    private List<String> getPowers(Step step) {
        return step.getDigits().stream().map(digit -> {
            return digit + "²";
        }).collect(Collectors.toList());
    }

    @Override
    public void output(String string) {
        System.out.println(string);
    }

    @Override
    public void output(Exception e) {
        e.printStackTrace();
    }
}