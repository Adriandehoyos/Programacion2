package com.decroly;

import java.time.LocalDate;

public class Cliente extends Persona{

    private String numSocio;
    private LocalDate fechaBaja;
    private int articulosAlquilados;

    
    public Cliente(String dni, String nombre, String direccion, LocalDate fechaNacimiento, String numSocio,
            LocalDate fechaBaja, int articulosAlquilados) {
        super(dni, nombre, direccion, fechaNacimiento);
        this.numSocio = numSocio;
        this.fechaBaja = fechaBaja;
        this.articulosAlquilados = articulosAlquilados;
    }

    

    public Cliente(String dni, String nombre, String direccion, LocalDate fechaNacimiento, String numSocio,
            int articulosAlquilados) {
        super(dni, nombre, direccion, fechaNacimiento);
        this.numSocio = numSocio;
        this.articulosAlquilados = articulosAlquilados;
    }



    public String getNumSocio() {
        return numSocio;
    }


    public LocalDate getFechaBaja() {
        return fechaBaja;
    }


    public int getArticulosAlquilados() {
        return articulosAlquilados;
    }


    public void setArticulosAlquilados(int articulosAlquilados) {
        this.articulosAlquilados = articulosAlquilados;
    }


    @Override
    public String toString() {
        return "Cliente [numSocio=" + numSocio + ", fechaBaja=" + fechaBaja + ", articulosAlquilados="
                + articulosAlquilados + "]";
    }

    
    


}
