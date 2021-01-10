package br.com.andre.exercicio2;

import br.com.andre.exercicio2.business.HappyNumberVerifier;
import br.com.andre.exercicio2.presentation.Controller;
import br.com.andre.exercicio2.presentation.Presentation;

public final class App {
    private Presentation presentation;

    public App(Presentation presentation) {
        this.presentation = presentation;
    }

    public void start() {
        var verifier = new HappyNumberVerifier();
        var controller = new Controller(verifier, presentation);
        controller.start();
    }
}