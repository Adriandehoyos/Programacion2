package com.decroly;

import java.time.LocalDate;

public class VideoDaw {
    private String cif;
    private String direccion;
    private LocalDate fechaAlta;

    
    public VideoDaw(String cif, String direccion) {
        this.cif = cif;
        this.direccion = direccion;
    }


    public VideoDaw(String cif, String direccion, LocalDate fechaAlta) {
        this.cif = cif;
        this.direccion = direccion;
        this.fechaAlta = fechaAlta;
    }


    public String getCif() {
        return cif;
    }


    public String getDireccion() {
        return direccion;
    }


    public LocalDate getFechaAlta() {
        return fechaAlta;
    }


    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    @Override
    public String toString() {
        return "VideoDaw [cif=" + cif + ", direccion=" + direccion + ", fechaAlta=" + fechaAlta + "]";
    }


    



}


