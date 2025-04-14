package com.decroly;

public class GenerosV {

    private int cod;
    private String tipos;

    public GenerosV(int cod, String tipos) {
        this.cod = cod;
        this.tipos = tipos;
    }

    public int getCod() {
        return cod;
    }

    public String getTipos() {
        return tipos;
    }

    @Override
    public String toString() {
        return "GenerosV [cod=" + cod + ", tipos=" + tipos + "]";
    }




}
