package main.java.myPaquete;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Juego jumanji = new Juego("entrada.in");
		jumanji.mostrarJuego();
		jumanji.resolver();
	}

}
