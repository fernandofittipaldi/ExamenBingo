package bingo;

import java.util.ArrayList;

public class Bolillero {
	private static final int CANTIDAD_NUMEROS = 90;
	private ArrayList<Integer> numeros;
	private int cantNumerosSacados;

	public Bolillero() {
		this.numeros = new ArrayList<>();
		for (int i = 0; i < CANTIDAD_NUMEROS; i++) {
			this.numeros.add(i + 1);
		}
		this.cantNumerosSacados = 0;
	}

	public int sacarNumero() {
		int numeroSacado = 0;

		if (tieneNumeros()) {
			numeroSacado = (int) Math.floor(Math.random() * numeros.size());
			this.numeros.remove(numeroSacado);
			cantNumerosSacados++;
		}
		return numeroSacado;
	}

	public boolean tieneNumeros() {
		return this.numeros.size() > 0;
	}

	public int getNumerosEmitidos() {
		return cantNumerosSacados;
	}

	public ArrayList<Integer> getNumeros() {
		return this.numeros;
	}

}
