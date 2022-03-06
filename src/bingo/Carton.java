package bingo;

import java.util.ArrayList;

public class Carton {
	private static final int CANTIDAD_NUMEROS = 15;
	private ArrayList<Integer> numeros;
	private int restantes;

	public Carton(ArrayList<Integer> numerosCarton) {
		this.numeros = new ArrayList<>();
		asignarNumeros(numerosCarton);
		this.restantes = CANTIDAD_NUMEROS;
	}

	public boolean buscarNumero(int numeroBolillero) {
		boolean bingo = false;
		boolean tieneNumero = false;
		int i = 0;

		while (i < this.numeros.size() && !tieneNumero) {
			if (this.numeros.get(i) == numeroBolillero) {
				restantes--;
			}
			i++;
		}
		if (restantes == 0) {
			bingo = true;
		}

		return bingo;

	}

	private void asignarNumeros(ArrayList<Integer> numerosBolillero) {
		for (int i = 0; i < CANTIDAD_NUMEROS; i++) {
			int random = (int) Math.floor(Math.random() * numerosBolillero.size());
			numeros.add(numerosBolillero.remove(random));
		}
	}

	@Override
	public String toString() {
		return "Carton [numeros=" + numeros + ", restantes=" + restantes + "]";
	}

	public void recorrerNumeros() {
		for (Integer numero : numeros) {
			System.out.print(numero + " - ");
		}
		System.out.println("**********");
	}
}
