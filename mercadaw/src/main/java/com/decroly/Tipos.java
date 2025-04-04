package com.decroly;

public class Tipos{

    private int id;
    private String nombre;


    public Tipos(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Tipos(String nombre) {
        this.nombre = nombre;
    }


    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    @Override
    public String toString() {
        return " [id=" + id + ", nombre=" + nombre + "]";
    }

    

}
