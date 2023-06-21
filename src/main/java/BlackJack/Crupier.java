package BlackJack;

import java.util.ArrayList;
import java.util.Collections;


public class Crupier {

	private JugadorBlackJack jugadorBlackJack;
	private ArrayList<JugadorBlackJack> jugadores = new ArrayList<JugadorBlackJack>();
	private ArrayList<Carta> mazo;

	private ArrayList<Carta> cartas = new ArrayList<Carta>();

	public Crupier(JugadorBlackJack jugadorBlackJack) {
		this.jugadorBlackJack = jugadorBlackJack;

		Mazo mazo1 = new Mazo();
		mazo =  mazo1.GetCartas();
	}

	public void AñadirBots(){
		JugadorBlackJack jugadorBlackJack1 = new JugadorBlackJack("bot1");
		jugadores.add(jugadorBlackJack1);

		JugadorBlackJack jugadorBlackJack2 = new JugadorBlackJack("bot2");
		jugadores.add(jugadorBlackJack2);

		JugadorBlackJack jugadorBlackJack3 = new JugadorBlackJack("bot3");
		jugadores.add(jugadorBlackJack3);
	}

	public void MezclarMazo() {
		Collections.shuffle(mazo);
	}

	public void DarCartasBots() {
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
	public void DarCartasJugador(){
		jugadorBlackJack.SetCarta(mazo.get(0));
		mazo.remove(0);

		jugadorBlackJack.SetCarta(mazo.get(0));
		mazo.remove(0);
	}
	public String CalcularGanador(){
		int puntaje = cartas.get(0).GetValor() + cartas.get(1).GetValor() + cartas.get(2).GetValor();
		String texto = "";
		if(puntaje > 21){
			texto = texto +  "El jugador: " + jugadorBlackJack.GetNombre() + " Gano  " + "\n";
		}else if (jugadorBlackJack.GetPuntaje() > 21){
			texto = texto + "El jugador: " + jugadorBlackJack.GetNombre() + " Perdio	" + "\n";
		}else if (jugadorBlackJack.GetPuntaje() > puntaje){
			texto = texto + "El jugador: " + jugadorBlackJack.GetNombre() + " Gano  " + "\n";
		} else if (jugadorBlackJack.GetPuntaje() < puntaje) {
			texto = texto + "El jugador: " + jugadorBlackJack.GetNombre() + " Perdio  " + "\n";
		}else{
			texto = texto + "El jugador: " + jugadorBlackJack.GetNombre() + " empato  " + "\n";
		}
		return texto;
	}
	public String CalcularBotsGanador() {
		int puntaje = cartas.get(0).GetValor() + cartas.get(1).GetValor() + cartas.get(2).GetValor();
		String texto = "";
		for (int i = 0; i <jugadores.size(); i++) {
			if(puntaje > 21){
				texto = texto +  "El jugador: " + jugadores.get(i).GetNombre() + " Gano  " + "\n";
			}else if (jugadores.get(i).GetPuntaje() > 21){
				texto = texto + "El jugador: " + jugadores.get(i).GetNombre() + "  Perdio	" + "\n";
			}else if (jugadores.get(i).GetPuntaje() > puntaje){
				texto = texto + "El jugador: " + jugadores.get(i).GetNombre() + " Gano  " + "\n";
			} else if (jugadores.get(i).GetPuntaje() < puntaje) {
				texto = texto + "El jugador: " + jugadores.get(i).GetNombre() + " Perdio  " + "\n";
			}else{
				texto = texto + "El jugador: " + jugadores.get(i).GetNombre() + " empato  " + "\n";
			}
		}
		return texto;
	}
	public void Jugar() {

		MezclarMazo();
		AñadirBots();

		DarCartasJugador();
		DarCartasBots();

		String a =CalcularGanador();
		a = a + CalcularBotsGanador();
		System.out.println(a);
	}

}