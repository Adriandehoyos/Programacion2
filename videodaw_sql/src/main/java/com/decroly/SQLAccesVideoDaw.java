package com.decroly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class SQLAccesVideoDaw {

    //crear y registrar video club

    public int crearVideoClub(VideoDaw nuevoV){

        int response = -1;

            String sqlStatement = "INSERT INTO videodaw ( cif, direccion)" + "VALUES (?, ?)";
    
            try (Connection connection = SQLAccesManager.getConnection(); PreparedStatement statement = connection.prepareStatement(sqlStatement);) {
    
                statement.setNString(1, nuevoV.getCif());
                statement.setNString(2, nuevoV.getDireccion());
                
                response = statement.executeUpdate();
    
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    
            return response;
        }


        //crear y registrar nueva Pelicula o videojuego
        //Primero vamos a crear un articulo

        public int insertarArticulo(Articulo nuevoA){

            int response = -1;
    
                String sqlStatement = "INSERT INTO Articulo (cod, titulo)" + "VALUES (?, ?)";
        
                try (Connection connection = SQLAccesManager.getConnection(); PreparedStatement statement = connection.prepareStatement(sqlStatement);) {
        
                    statement.setNString(1, nuevoA.getCod());
                    statement.setNString(2, nuevoA.getTitulo());
                    
                    
                    response = statement.executeUpdate();
        
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
        
                return response;
            }

        //Ahora metodo para mostrar los articulos
        public List<Articulo> getInfoArticulos(){
        List<Articulo> infoArticulos = new LinkedList<>();

        String getAll = "SELECT * FROM articulo";

        try (Connection connection = SQLAccesManager.getConnection(); Statement statement = connection.createStatement();
        ResultSet dataSet = statement.executeQuery(getAll);) {
            while(dataSet.next()){
                String cod = dataSet.getNString(1);
                String titulo = dataSet.getNString(2);
                Date fechaRegistro = dataSet.getDate(3);
                Date fechaBaja = dataSet.getDate(4);


                Articulo a1 =  new Articulo(cod, titulo, fechaRegistro, fechaBaja);
                infoArticulos.add(a1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return infoArticulos;
    }






















    }//

