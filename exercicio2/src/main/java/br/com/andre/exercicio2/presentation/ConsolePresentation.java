package br.com.andre.exercicio2.presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import br.com.andre.exercicio2.business.HappyNumberVerifier;
import br.com.andre.exercicio2.business.Result;
import br.com.andre.exercicio2.business.Step;

public class ConsolePresentation implements Presentation {
    private String input = "";
    private HappyNumberVerifier verifier;
    private BufferedReader reader;

    @Override
    public void start(HappyNumberVerifier v) {
        verifier = v;
        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Bem vindo ao verificador de números felizes!!! :D");
        loop();
    }

    private void loop() {
        while (true)
            handleExceptions();
    }

    private void handleExceptions() {
        try {
            verifyNumber();
        } catch (NumberFormatException e) {
            System.out.println(input + " é muito grande ou não é um número.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void verifyNumber() throws IOException, NumberFormatException {
        System.out.println("Digite um número:");
        input = reader.readLine();
        long number = Long.parseLong(input);
        Result result = verifier.verify(number);
        showResult(result);
    }

    private void showResult(Result result) {
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
            return digit + " * " + digit;
        }).collect(Collectors.toList());
    }
}