package Package;

public class Carta {

	private String simbolo;
	private int valor;
	private String pinta;

	/**
	 *
	 * @param simbolo
	 * @param valor
	 * @param pinta
	 */
	public Carta(String simbolo, int valor, String pinta) {
		this.simbolo = simbolo;
		this.valor = valor;
		this.pinta = pinta;
	}

	public String GetSimbolo() {
		return simbolo;
	}

	public int GetValor() {
		return valor;
	}

}