package com.decroly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


public class SQLaccesMercaDaw {

    //toda la info
    public List<String> getallInfo(){
        List<String> allInfo = new LinkedList<>();

        String getAll = "SELECT * FROM producto";

                try (Connection connection = SQLDataBaseManager.getConnection(); Statement statement = connection.createStatement();
        ResultSet dataSet = statement.executeQuery(getAll);) {
            while(dataSet.next()){
                allInfo.add(dataSet.getNString("nombre"));
                
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return allInfo;
    }


    //Buscar producto por referencia
    
    public List<Producto> getProductoPorReferencia(String referencia){
        List<Producto> buscarRefe = new LinkedList<>();

        String sqlStatement = "SELECT * FROM producto WHERE referencia = ?";

        try (Connection connection = SQLDataBaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement(sqlStatement);) {

            statement.setString(1, referencia);
            ResultSet dataSet = statement.executeQuery();

            while(dataSet.next()){
                int id = dataSet.getInt(1);
                String Referencia = dataSet.getNString(2);
                String nombre = dataSet.getNString(3);
                String descripcion = dataSet.getNString(4);
                int Tipo = dataSet.getInt(5);
                int cantidad = dataSet.getInt(6);
                double precio = dataSet.getDouble(7);
                int descuento = dataSet.getInt(8);
                int iva = dataSet.getInt(9);
                boolean aplicarDto = dataSet.getBoolean(10);

                Producto p1 =  new Producto(id, Referencia, nombre, descripcion, Tipo, cantidad, precio, descuento, iva, aplicarDto);
                buscarRefe.add(p1);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return buscarRefe;
    }

}
