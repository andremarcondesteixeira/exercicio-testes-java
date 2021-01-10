package br.com.andre.exercicio2.presentation;

import java.io.IOException;

import br.com.andre.exercicio2.business.HappyNumberVerifier;
import br.com.andre.exercicio2.business.Result;

public class Controller {
    private HappyNumberVerifier verifier;
    private Presentation presentation;

    public Controller(HappyNumberVerifier verifier, Presentation presentation) {
        this.verifier = verifier;
        this.presentation = presentation;
    }

    public void start() {
        while (true)
            handleExceptions();
    }

    private void handleExceptions() {
        try {
            verifyNumber();
        } catch (NumberFormatException e) {
            presentation.output("O valor digitado é muito grande ou não é um número.");
        } catch (Exception e) {
            presentation.output(e);
        }
    }

    private void verifyNumber() throws IOException, NumberFormatException {
        long number = presentation.getInput();
        Result result = verifier.verify(number);
        presentation.output(result);
    }
}