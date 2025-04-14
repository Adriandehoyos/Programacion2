package com.decroly;

import java.util.Date;

public class VideoJuego extends Articulo {

    private int genero;
    private Date fechaAlquiler;
    private boolean isAlquilada;

    public VideoJuego(String cod, String titulo, Date fechaRegistro, Date fechaBaja, int genero,
        Date fechaAlquiler, boolean isAlquilada) {
        super(cod, titulo, fechaRegistro, fechaBaja);
        this.genero = genero;
        this.fechaAlquiler = fechaAlquiler;
        this.isAlquilada = isAlquilada;
    }

    public int getGenero() {
        return genero;
    }


    public Date getFechaAlquiler() {
        return fechaAlquiler;
    }

    public boolean isAlquilada() {
        return isAlquilada;
    }

    public void setFechaAlquiler(Date fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public void setAlquilada(boolean isAlquilada) {
        this.isAlquilada = isAlquilada;
    }

    @Override
    public String toString() {
        return "VideoJuego [genero=" + genero + ", fechaAlquiler=" + fechaAlquiler + ", isAlquilada=" + isAlquilada
                + "]";
    }


    
    

    

}//
