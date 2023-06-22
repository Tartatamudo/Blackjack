package BullsEye;

import java.util.Random;

public class Caballo {
    private String nombre;
    private String color;
    private int id;

    private int tiempo;

    public Caballo(String nombre, String color, int id) {
        this.nombre = nombre;
        this.color = color;
        this.id = id;
    }

    public void setTiempo(){
        this.tiempo = (int)(Math.random()*100+1);
    }
    public int GetTiempo(){
        return tiempo;
    }
    public int GetId(){
        return id;
    }
    public String GetDatos(){
        String texto = "";
        texto = texto + "Nombre: " + nombre + " ";
        texto = texto + "Color: " + color + " ";
        texto = texto + "Id: " + id + " ";
    return texto;
    }
}
