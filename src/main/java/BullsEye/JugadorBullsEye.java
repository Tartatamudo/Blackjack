package BullsEye;

import Corredor.Usuario;

public class JugadorBullsEye extends Usuario {
    int monto;
    int numero;

    public JugadorBullsEye(String nombre) {
        this.nombre = nombre;
        monto = 50000;
    }

    public void setMonto(int dinero){
        monto = monto + dinero;
    }
    public void SetNumero(int num){
        this.numero = num;
    }

    public int GetNumero(){
        return numero;
    }
    public String GetNombre(){
        return nombre;
    }
    public int GetMonto(){
        return monto;
    }
}
