package Validadores;

import java.util.Scanner;

public class validadores {
    public static int GetEntero(String numStr) {
        int numero = 0;
            try {
                numero = Integer.parseInt(numStr);
            } catch (NumberFormatException e) {

            }

        return numero;
    }
    public static boolean ValidarEntero(String numStr) {
        boolean bool = false;
        int numero = 0;
        try {
            numero = Integer.parseInt(numStr);
            bool = true;
        } catch (NumberFormatException e) {

        }

        return bool;
    }
}
