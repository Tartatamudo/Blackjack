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
    public void GetDatos(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Color: " + color);
        System.out.println("Id: " + id);
    }
}
