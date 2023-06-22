package Corredor;

import BlackJack.Crupier;
import BlackJack.JugadorBlackJack;
import BullsEye.JuegoBullsEye;
import BullsEye.JugadorBullsEye;

import java.util.ArrayList;
import java.util.Scanner;

public class Inicio {
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    public Inicio() {
    }

    public void Menu(){
        Scanner teclado = new Scanner(System.in);
        Bienvenida();

        String nombre = NombreJugador();
        System.out.println("Que desea jugar");
        System.out.println("[1]BlackJack");
        System.out.println("[2]BullsEye");
        int eleccion = teclado.nextInt();

        if (eleccion == 1){
            JugadorBlackJack jugadorBlackJack = new JugadorBlackJack(nombre);
            JugarBlackJack(jugadorBlackJack);
            usuarios.add(jugadorBlackJack);
        }else if(eleccion == 2){
            JugadorBullsEye jugadorBullsEye = new JugadorBullsEye(nombre);
            JugarBullsEye(jugadorBullsEye);
            usuarios.add(jugadorBullsEye);
        }
    }
    public void Bienvenida(){
        System.out.println("Bienvenido");
        System.out.println("Escriba su nombre");
    }
    public String NombreJugador(){
        Scanner teclado = new Scanner(System.in);
        String nombre = teclado.nextLine();
        return nombre;
    }
    public void JugarBlackJack(JugadorBlackJack jugadorBlackJack){
        Crupier crupier = new Crupier(jugadorBlackJack);
        crupier.Jugar();
    }
    public void JugarBullsEye(JugadorBullsEye jugadorBullsEye){
        JuegoBullsEye juegoBullsEye = new JuegoBullsEye(jugadorBullsEye);
        //juegoBullsEye.Jugar();
    }
}
