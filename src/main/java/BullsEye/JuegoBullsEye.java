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
        AñadirBots();
        AñadirCaballos();
    }

    public void AñadirCaballos() {
        Caballo caballo = new Caballo("Caballo1", "Negro", 1);
        Caballo caballo1 = new Caballo("Caballo2", "blanco", 2);
        Caballo caballo2 = new Caballo("Caballo3", "cafe", 3);
        Caballo caballo3 = new Caballo("Caballo4", "gris", 4);
        Caballo caballo4 = new Caballo("Caballo5", "Castaño", 5);
        Caballo caballo5 = new Caballo("Caballo6", "Pinto", 6);

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

    }
    public void DarNumRAndomCaballos() {
        for (int i = 0; i < caballos.size(); i++) {
            caballos.get(i).setTiempo();
        }
    }

    public String ElegirMontoApuesta(){
        String texto = "";
        texto = texto + ("[1]500;");
        texto = texto + ("[2]1000;");
        texto = texto + "[3]5000;";
        texto = texto + "[4]10000;";
        texto = texto + "[5]25000;";
        texto = texto + "[6]50000;";

        return texto;
    }
    public String Jugar(int caballoApuesta, int apuesta){
        String texto = "";

        DarNumRAndomCaballos();

        jugadorBullsEye.SetNumero(caballoApuesta);

        ElegirCaballoGanador();

        texto = texto + ResultadoJugador(apuesta) + " ";

        texto = texto + ResultadoBots();

        return texto;
    }
    public String ImprimirDatosCaballoganador(){
        return "El caballo ganador fue: " + caballoGanador.GetDatos();
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

    public String ResultadoJugador(int apuesta){
        String texto = "";
        int montoGanado;
        if (jugadorBullsEye.GetNumero() == caballoGanador.GetId()){
            montoGanado = MontoGanado(apuesta);
            jugadorBullsEye.setMonto(montoGanado);
            texto = texto + "jugador: " + jugadorBullsEye.GetNombre() + " gano: " + Integer.toString(montoGanado) + "Le quedan: " + jugadorBullsEye.GetMonto() + ";";
        }else{
            montoGanado = (-apuesta);
            jugadorBullsEye.setMonto(montoGanado);
            texto = texto + "jugador: " + jugadorBullsEye.GetNombre() + " perdio: " + Integer.toString(-(montoGanado))  + ", Le quedan: " + jugadorBullsEye.GetMonto() + ";";
        }

        return texto;
    }
    public String ResultadoBots(){
        String texto  = "";
        for (int i = 0; i < jugadoresBullsEye.size(); i++) {
            if (jugadoresBullsEye.get(i).GetNumero() == caballoGanador.GetId()){
                texto = texto + "jugador " + jugadoresBullsEye.get(i).GetNombre() + " gano ;";
            }else{
                texto = texto + "jugador " + jugadoresBullsEye.get(i).GetNombre() + " perdio ;";
            }
        }
        return texto;
    }

    public JugadorBullsEye Getjugador(){
        return jugadorBullsEye;
    }
}
