package BlackJack;

import Corredor.Usuario;

import java.util.ArrayList;

public class JugadorBlackJack extends Usuario {
	private int puntaje;
	private ArrayList<Carta> cartas = new ArrayList<Carta>();

	/**
	 *
	 * @param nombre
	 */
	public JugadorBlackJack(String nombre) {
		this.nombre = nombre;
	}

	public void SetCarta(Carta carta) {
		cartas.add(carta);
	}

	public void SetPuntaje() {
		for (int i = 0; i < cartas.size(); i++) {
			puntaje = puntaje + cartas.get(i).GetValor();
		}
	}
	public String GetNombre(){
		return nombre;
	}
	public int GetPuntaje(){
		return puntaje;
	}

}