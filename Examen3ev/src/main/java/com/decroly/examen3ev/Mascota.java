package com.decroly.examen3ev;

import java.io.Serializable;
import java.time.LocalDate;

public class Mascota implements Serializable {

    private static final long serialVersionUID = 5022862804767854790L;

    private String pasaporte;
    private String nombre;
    private LocalDate fechaNacimiento;
    private String peso;
    private int tipo;
    private String propietario;

    public Mascota(String pasaporte, String nombre,String peso, LocalDate fechaNacimiento , String propietario, int tipo) {
        this.pasaporte = pasaporte;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.peso = peso;
        this.tipo = tipo;
        this.propietario = propietario;
    }

    public Mascota(String nombre,String peso, LocalDate fechaNacimiento , String propietario, int tipo) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.peso = peso;
        this.tipo = tipo;
        this.propietario = propietario;
    }

    public String getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(String pasaporte) {
        this.pasaporte = pasaporte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "pasaporte='" + pasaporte + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", peso=" + peso +
                ", tipo='" + tipo + '\'' +
                ", propietario=" + propietario +
                '}';
    }
}
