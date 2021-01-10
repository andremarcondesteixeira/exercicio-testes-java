package br.com.andre.exercicio2.presentation;

import java.io.IOException;

import br.com.andre.exercicio2.business.Result;

public interface Presentation {
	public long getInput() throws IOException, NumberFormatException;

	public void output(String string);

	public void output(Exception e);

	public void output(Result result);
}