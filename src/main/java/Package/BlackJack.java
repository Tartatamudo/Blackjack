package Package;
import java.util.Scanner;
public class BlackJack {

	public BlackJack() {

	}

	public void Jugar() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Eliga nombre crupier");
		String nombre = teclado.nextLine();

		Crupier crupier = new Crupier(nombre);
		crupier.SetJugador();
		crupier.SetJugador();
		crupier.MezclarMazo();
		crupier.DarCartasJugador();
		crupier.CalcularGanador();
	}

}