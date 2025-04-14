package com.decroly;

import java.util.Date;

public class Articulo {

    protected String cod;
    protected String titulo;
    protected Date fechaRegistro;
    protected Date fechaBaja;

    
    public Articulo(String cod, String titulo, Date fechaRegistro, Date fechaBaja) {
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


    public Date getFechaRegistro() {
        return fechaRegistro;
    }


    public Date getFechaBaja() {
        return fechaBaja;
    }


    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }


    @Override
    public String toString() {
        return "Articulo [cod=" + cod + ", titulo=" + titulo + ", fechaRegistro=" + fechaRegistro + ", fechaBaja="
                + fechaBaja + "]";
    }


    




}//
