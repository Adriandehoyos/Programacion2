package com.decroly;

import java.time.LocalDate;

public class Articulo {

    protected String cod;
    protected String titulo;
    protected LocalDate fechaRegistro;
    protected LocalDate fechaBaja;

    
    public Articulo(String cod, String titulo, LocalDate fechaRegistro, LocalDate fechaBaja) {
        this.cod = cod;
        this.titulo = titulo;
        this.fechaRegistro = fechaRegistro;
        this.fechaBaja = fechaBaja;
    }


    public String getCod() {
        return cod;
    }


    public String getTitulo() {
        return titulo;
    }


    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }


    public LocalDate getFechaBaja() {
        return fechaBaja;
    }


    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }


    @Override
    public String toString() {
        return "Articulo [cod=" + cod + ", titulo=" + titulo + ", fechaRegistro=" + fechaRegistro + ", fechaBaja="
                + fechaBaja + "]";
    }


    




}//
