package com.decroly;

import java.time.LocalDate;

public class Persona {

    protected String dni;
    protected String nombre;
    protected String direccion;
    protected LocalDate fechaNacimiento;


    public Persona(String dni, String nombre, String direccion, LocalDate fechaNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
    }


    public String getDni() {
        return dni;
    }


    public String getNombre() {
        return nombre;
    }


    public String getDireccion() {
        return direccion;
    }


    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }


    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    @Override
    public String toString() {
        return "Persona [dni=" + dni + ", nombre=" + nombre + ", direccion=" + direccion + ", fechaNacimiento="
                + fechaNacimiento + "]";
    }


    
    
}
