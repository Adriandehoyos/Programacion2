package com.decroly.simulacroexamen;

import java.io.Serializable;
import java.time.LocalDate;

public class Medicos implements Serializable {
    private static final long serialVersionUID = -2655304421874196052L;

    private String dni;
    private String nombre;
    private String direccion;
    private LocalDate fechaNacimiento;
    private Especialidad especialidad;



    public Medicos(String dni, String nombre, String direccion, LocalDate fechaNacimiento, Especialidad especialidad) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.especialidad = especialidad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Medicos {" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", especialidad=" + especialidad +
                ", fecha Nacimiento=" + fechaNacimiento +
                '}';
    }
}
