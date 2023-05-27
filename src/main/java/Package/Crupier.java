package Package;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Crupier {

	private String nombre;
	private ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
	private ArrayList<Carta> mazo;

	private ArrayList<Carta> cartas = new ArrayList<Carta>();

	/**
	 *
	 * @param nombre
	 */
	public Crupier(String nombre) {
		this.nombre = nombre;

		Mazo mazo1 = new Mazo();
		mazo =  mazo1.GetCartas();
	}

	public void SetJugador(){
		Scanner teclado = new Scanner(System.in);
		System.out.println("Eliga nombre jugador");

		nombre = teclado.nextLine();
		Jugador jugador = new Jugador(nombre);

		jugadores.add(jugador);
	}

	public void MezclarMazo() {
		Collections.shuffle(mazo);
	}

	public void DarCartasJugador() {
		for (int i = 0; i < jugadores.size(); i++) {
			jugadores.get(i).SetCarta(mazo.get(0));
			mazo.remove(0);
			jugadores.get(i).SetCarta(mazo.get(0));
			mazo.remove(0);
			jugadores.get(i).SetCarta(mazo.get(0));
			mazo.remove(0);

			jugadores.get(i).SetPuntaje();
		}

		cartas.add(mazo.get(0));
		mazo.remove(0);
		cartas.add(mazo.get(0));
		mazo.remove(0);
		cartas.add(mazo.get(0));
		mazo.remove(0);
	}

	public void CalcularGanador() {
		int puntaje = cartas.get(0).GetValor() + cartas.get(1).GetValor() + cartas.get(2).GetValor();

		for (int i = 0; i <jugadores.size(); i++) {
			if(jugadores.get(i).GetPuntaje() > 21){
				System.out.println("El jugador: " + jugadores.get(i).GetNombre() + " perdio");
			}else if ((puntaje > 21) && (jugadores.get(i).GetPuntaje() <= 21)){
				System.out.println("El jugador: " + jugadores.get(i).GetNombre() + " gano");
			}else if (puntaje < 21 && jugadores.get(i).GetPuntaje() < 21 && puntaje > jugadores.get(i).GetPuntaje()){
				System.out.println("El jugador: " + jugadores.get(i).GetNombre() + " Perdio");
			} else if (puntaje < 21 && jugadores.get(i).GetPuntaje() < 21 && puntaje < jugadores.get(i).GetPuntaje()) {
				System.out.println("El jugador: " + jugadores.get(i).GetNombre() + " gano");
			}
		}

	}

}