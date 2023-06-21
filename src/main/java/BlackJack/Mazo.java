package BlackJack;

import java.util.ArrayList;

public class Mazo {

	private ArrayList<Carta> mazo = new ArrayList<Carta>();

	public Mazo() {
		String simbolo = "";
		int valor = 0;
		for (int i = 1; i <= 13; i++) {

			if (i == 1){
				simbolo = "As";
				valor = 11;
			} else if (i == 11) {
				simbolo = "J";
				valor = 10;
			}else if ( i == 12){
				simbolo = "Q";
				valor = 10;
			}else if (i == 13){
				simbolo = "K";
				valor = 10;
			}else {
				simbolo = Integer.toString(i);
				valor = i;
			}
			Carta carTreb = new Carta(simbolo, valor, "trebol");
			Carta carDiam = new Carta(simbolo, valor, "daimante");
			Carta carPic = new Carta(simbolo, valor, "pica");
			Carta carCor = new Carta(simbolo, valor, "corazon");

			mazo.add(carTreb);
			mazo.add(carDiam);
			mazo.add(carPic);
			mazo.add(carCor);
		}
	}

	public ArrayList GetCartas() {
		return mazo;
	}

}