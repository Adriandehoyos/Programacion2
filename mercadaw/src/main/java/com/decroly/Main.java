package com.decroly;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        SQLaccesMercaDaw miMDdata = new SQLaccesMercaDaw();

        List<String> nombres = miMDdata.getallInfo();

        for (String pro : nombres){
            System.out.println(pro);
        }
    }
}