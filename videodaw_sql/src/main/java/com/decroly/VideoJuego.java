package com.decroly;

import java.time.LocalDate;

public class VideoJuego extends Articulo {

    private int genero;
    private LocalDate fechaAlquiler;
    private boolean isAlquilada;

    public VideoJuego(String cod, String titulo, LocalDate fechaRegistro, LocalDate fechaBaja, int genero,
        LocalDate fechaAlquiler, boolean isAlquilada) {
        super(cod, titulo, fechaRegistro, fechaBaja);
        this.genero = genero;
        this.fechaAlquiler = fechaAlquiler;
        this.isAlquilada = isAlquilada;
    }

    public int getGenero() {
        return genero;
    }


    public LocalDate getFechaAlquiler() {
        return fechaAlquiler;
    }

    public boolean isAlquilada() {
        return isAlquilada;
    }

    public void setFechaAlquiler(LocalDate fechaAlquiler) {
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
