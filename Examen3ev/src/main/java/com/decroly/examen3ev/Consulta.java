package com.decroly.examen3ev;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Consulta {
    private LocalDateTime fecha;
    private String duracion;
    private String observacion;
    private String mascota;
    private String propietario;

    public Consulta(LocalDateTime fecha, String duracion, String observacion, String mascota, String propietario) {
        this.fecha = fecha;
        this.duracion = duracion;
        this.observacion = observacion;
        this.mascota = mascota;
        this.propietario = propietario;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getMascota() {
        return mascota;
    }

    public void setMascota(String mascota) {
        this.mascota = mascota;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "fecha=" + fecha +
                ", duracion='" + duracion + '\'' +
                ", observacion='" + observacion + '\'' +
                ", mascota='" + mascota + '\'' +
                ", propietario='" + propietario + '\'' +
                '}';
    }
}
