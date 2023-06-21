package BullsEye;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class JuegoBullsEye {
    private JugadorBullsEye jugadorBullsEye;
    private ArrayList<Caballo> caballos = new ArrayList<Caballo>();
    private ArrayList<JugadorBullsEye> jugadoresBullsEye = new ArrayList<>();
    private Caballo caballoGanador;

    public JuegoBullsEye(JugadorBullsEye jugadorBullsEye) {
        this.jugadorBullsEye = jugadorBullsEye;
    }

    public void AñadirCaballos() {
        Caballo caballo = new Caballo("Caballo1", "Negro", 0);
        Caballo caballo1 = new Caballo("Caballo2", "blanco", 1);
        Caballo caballo2 = new Caballo("Caballo3", "cafe", 2);
        Caballo caballo3 = new Caballo("Caballo4", "gris", 3);
        Caballo caballo4 = new Caballo("Caballo5", "Castaño", 4);
        Caballo caballo5 = new Caballo("Caballo6", "Pinto", 5);

        this.caballos.add(caballo);
        this.caballos.add(caballo1);
        this.caballos.add(caballo2);
        this.caballos.add(caballo3);
        this.caballos.add(caballo4);
        this.caballos.add(caballo5);

    }

    public void AñadirBots(){
        Random random = new Random();
        JugadorBullsEye jugadorBullsEye1 = new JugadorBullsEye("bot1");
        jugadorBullsEye1.SetNumero((int)(Math.random()*5));
        jugadoresBullsEye.add(jugadorBullsEye1);

        JugadorBullsEye jugadorBullsEye2 = new JugadorBullsEye("bot2");
        jugadorBullsEye2.SetNumero((int)(Math.random()*5));
        jugadoresBullsEye.add(jugadorBullsEye2);

        JugadorBullsEye jugadorBullsEye3 = new JugadorBullsEye("bot3");
        jugadorBullsEye3.SetNumero((int)(Math.random()*5));
        jugadoresBullsEye.add(jugadorBullsEye3);

        JugadorBullsEye jugadorBullsEye4 = new JugadorBullsEye("bot4");
        jugadorBullsEye4.SetNumero((int)(Math.random()*5));
        jugadoresBullsEye.add(jugadorBullsEye4);

        JugadorBullsEye jugadorBullsEye5 = new JugadorBullsEye("bot5");
        jugadorBullsEye5.SetNumero((int)(Math.random()*5));
        jugadoresBullsEye.add(jugadorBullsEye5);

        System.out.println((int)(Math.random()*5));
    }
    public void DarNumRAndomCaballos() {
        for (int i = 0; i < caballos.size(); i++) {
            caballos.get(i).setTiempo();
        }
    }

    public void DarNumJugador(){
        Scanner teclado = new Scanner(System.in);

        System.out.println("Eliga el numero del caballo por el que va a apostar del 0 al 5");
        int num = teclado.nextInt();

        jugadorBullsEye.SetNumero(num);
    }

    public int ElegirMontoApuesta(){
        int monto = 0;
        Scanner teclado = new Scanner(System.in);
        System.out.println("ELiga monto que va a apostar");
        System.out.println("[1]500");
        System.out.println("[2]1000");
        System.out.println("[3]5000");
        System.out.println("[4]10000");
        System.out.println("[5]25000");
        System.out.println("[6]50000");
        int eleccion = teclado.nextInt();
        switch (eleccion){
            case 1:
                monto = 500;
                break;
            case 2:
                monto = 1000;
                break;
            case 3:
                monto = 5000;
                break;
            case 4:
                monto = 10000;
                break;
            case 5:
                monto = 25000;
                break;
            case 6:
                monto = 50000;
        }
        return monto;
    }
    public void Jugar(){
        AñadirCaballos();
        DarNumRAndomCaballos();
        DarNumJugador();
        int apuesta = ElegirMontoApuesta();

        ElegirCaballoGanador();
        ImprimirDatosCaballoganador();
        System.out.println();
        ResultadoJugador(apuesta);

        AñadirBots();
        ResultadoBots();
    }
    public void ImprimirDatosCaballoganador(){
        System.out.println("El caballo ganador fue: ");
        caballoGanador.GetDatos();
    }
    public void ElegirCaballoGanador(){
        caballoGanador = caballos.get(0);

        for (int i = 0; i <caballos.size() ; i++) {
            if (caballos.get(i).GetTiempo() > caballoGanador.GetTiempo()){
                caballoGanador = caballos.get(i);
            }
        }
    }

    public int MontoGanado(int monto){
        if (monto == 500){
            return monto*2;
        } else if (monto == 1000) {
            return monto*3;
        } else if (monto == 5000) {
            return monto*4;
        } else if (monto == 10000) {
            return monto*5;
        } else if (monto == 25000) {
            return monto*7;
        }else{
            return monto*10;
        }
    }

    public void ResultadoJugador(int apuesta){
        int montoGanado;
        if (jugadorBullsEye.GetNumero() == caballoGanador.GetId()){
            montoGanado = MontoGanado(apuesta);
            System.out.println("jugador " + jugadorBullsEye.GetNombre() + " gano: " + montoGanado);
        }else{
            montoGanado = (-apuesta);
            System.out.println("jugador " + jugadorBullsEye.GetNombre() + " perdio: " + montoGanado);
        }
        jugadorBullsEye.setMonto(montoGanado);

        System.out.println("Usted tiene: " + jugadorBullsEye.GetMonto() + " pesos");
    }
    public void ResultadoBots(){
        for (int i = 0; i < jugadoresBullsEye.size(); i++) {
            if (jugadoresBullsEye.get(i).GetNumero() == caballoGanador.GetId()){
                System.out.println("jugador " + jugadoresBullsEye.get(i).GetNombre() + " gano");
            }else{
                System.out.println("jugador " + jugadoresBullsEye.get(i).GetNombre() + " perdio");
            }
        }
    }
}
