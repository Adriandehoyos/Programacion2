package com.decroly;

public class GenerosP{

    private int cod;
    private String tipos;

    public GenerosP(int cod, String tipos) {
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
        StringBuilder sb = new StringBuilder();
        sb.append("GenerosP{");
        sb.append("cod=").append(cod);
        sb.append(", tipos=").append(tipos);
        sb.append('}');
        return sb.toString();
    }



    
}
