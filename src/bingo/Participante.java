package bingo;

import java.util.ArrayList;

public class Participante {
	private int id; 
	private Carton carton;
	
	
	public Participante(int id, ArrayList<Integer> numerosCarton) {
		this.id = id;
		this.carton = new Carton(numerosCarton);
	} 
	
	public int getId() {
		return id; 
	}
	
	public boolean verificarNumero(int numero) {
		return carton.buscarNumero(numero); 
	}

	@Override
	public String toString() {
		return "Participante [id=" + id + ", carton=" + carton + "]";
	}

	public void dameNumerosCarton() {
		carton.recorrerNumeros();
	}
	
	
	
}
