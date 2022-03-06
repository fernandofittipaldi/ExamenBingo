package bingo;

import java.util.ArrayList;

public class Bingo {
	private static final int PARTICIPANTES_MINIMO = 5;
	private static final int PARTICIPANTES_MAXIMO = 100;
	private Bolillero bolillero;
	private ArrayList<Participante> participantes;
	private ArrayList<Participante> ganadores;

	public Bingo() {
		ganadores = new ArrayList<>();
	}

	public void simularRonda(int cantParticipantes) {

		if (cantParticipantes >= PARTICIPANTES_MINIMO && cantParticipantes <= PARTICIPANTES_MAXIMO) {
			this.participantes = new ArrayList<>();
			this.bolillero = new Bolillero();
			for (int i = 0; i < cantParticipantes; i++) {
				Bolillero copia = new Bolillero();
				ArrayList<Integer> numeros = copia.getNumeros();
				Participante participante = new Participante(i + 1, numeros);
				this.participantes.add(participante);
			}
			System.out.println("*************************************************");
			System.out.println("*** Arranca la ronda con " + cantParticipantes + " participantes!! ***");
			boolean bingo = false;
			while (bolillero.tieneNumeros() && !bingo) {
				int numero = bolillero.sacarNumero();
				bingo = verificarBingoParticipantes(numero);
			}
			if (bingo) {
				mostrarGanadores();
			}

		}

	}

	private boolean verificarBingoParticipantes(int numero) {
		boolean bingo = false;
		boolean tieneBingo = false;

		for (Participante participante : participantes) {
			bingo = participante.verificarNumero(numero);
			if (bingo) {
				System.out.println("El participante " + participante.getId() + " canto BINGO con el numero " + numero);
				tieneBingo = true;
				this.ganadores.add(participante);
			}
		}
		return tieneBingo;
	}

	private void mostrarGanadores() {
		System.out.println(
				"Se tiraron " + bolillero.getNumerosEmitidos() + " numeros antes de conocer a el o los ganadores!!");
		for (Participante participante : ganadores) {
			System.out.println("Participante " + participante.getId() + " numeros de carton: ");
			participante.dameNumerosCarton();

		}
	}
}
