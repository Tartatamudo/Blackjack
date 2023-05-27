package Package;

import java.util.ArrayList;

public class Jugador {

	private String nombre;
	private int puntaje;
	private ArrayList<Carta> cartas = new ArrayList<Carta>();

	/**
	 *
	 * @param nombre
	 */
	public Jugador(String nombre) {
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