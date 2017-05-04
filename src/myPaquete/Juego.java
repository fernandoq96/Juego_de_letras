package myPaquete;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Juego {
	private char[][] tablero;
	private String[] cadenas;
	private List cad;

	public Juego(String path) throws FileNotFoundException {
		int dimTab, cantCadenas;
		Scanner sc = new Scanner(new File(path));
		dimTab = sc.nextInt();
		cantCadenas = sc.nextInt();
		cad = new LinkedList<String>();
		this.cadenas = new String[cantCadenas];
		this.tablero = new char[dimTab][dimTab];

		sc.nextLine();
		for (int i = 0; i < dimTab; i++) {
			tablero[i] = sc.nextLine().toCharArray();
		}
		for (int i = 0; i < cantCadenas; i++) {
			cadenas[i] = sc.nextLine();
		}
		sc.close();

	}

	public void mostrarJuego() {
		StringBuilder cadenita = new StringBuilder();
		for (int i = 0; i < this.tablero.length; i++) {
			System.out.println(this.tablero[i]);
		}
		System.out.println();
		
		for (int i = 0; i < cadenas.length; i++) {
			System.out.println(this.cadenas[i]);
		}
	}

	public String compararCad(int i, int j, int posCad) {
		int posX = i, posY = j;

		if (j + this.cadenas[posCad].length() <= this.tablero[i].length) {
			while (j < this.cadenas[posCad].length() && this.cadenas[posCad].charAt(j) == this.tablero[i][j]) 
				j++;
			
			if (j == this.cadenas[posCad].length())
				return (posCad + " E");
			j = posY;
		}

		if ((j + 1) - this.cadenas[posCad].length() >= 0) {
			while (j > 0 && this.cadenas[posCad].charAt(this.cadenas[posCad].length() - j) == this.tablero[i][j]) 
				j--;
			
			if (j == 0)
				return (posCad + " O");
			j = posY;
		}

		if (i + this.cadenas[posCad].length() <= this.tablero.length) {
			while(i < this.cadenas[posCad].length() && this.cadenas[posCad].charAt(i) == this.tablero[i][j])
				i++;
			
			if(i == this.cadenas[posCad].length())
				return(posCad + " S");
			i = posX;
		}
		
		if ((i + 1) - this.cadenas[posCad].length() >= 0) {
			while (i > 0 && this.cadenas[posCad].charAt(this.cadenas[posCad].length() - i) == this.tablero[i][j]) 
				i--;
			
			if (i == 0)
				return (posCad + " N");
		}

		return null;
	}

	public void resolver()
	{
		StringBuilder cad = new StringBuilder();
		String aux;
		int k;
		for (int i = 0; i < this.tablero.length; i++) {
			for (int j = 0; j < this.tablero[0].length; j++) {
				k=0;
				while(k < this.cadenas.length)
				{
					if((aux =this.compararCad(i, j, k)) != null)
					{
						cad.append(aux);
					}
					k++;
				}
			}
		}
		System.out.println(this.cad);
		
	}
	public char[][] getTablero() {
		return tablero;
	}

	public void setTablero(char[][] tablero) {
		this.tablero = tablero;
	}

	public String[] getCadenas() {
		return cadenas;
	}

	public void setCadenas(String[] cadenas) {
		this.cadenas = cadenas;
	}

}
