package com.decroly;

import java.sql.Connection;
import java.sql.PreparedStatement;
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


        //crear y registrar nueva Pelicula

        public int insertarPelicula(Pelicula nuevaP){

            int response = -1;
    
                String sqlStatement = "INSERT INTO Pelicula (cod, genero, fechaAlquiler, isAlquilada)" + "VALUES (?, ?, ?, ?)";
        
                try (Connection connection = SQLAccesManager.getConnection(); PreparedStatement statement = connection.prepareStatement(sqlStatement);) {
        
                    statement.setNString(1, nuevaP.getCod());
                    
                    
                    response = statement.executeUpdate();
        
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
        
                return response;
            }
    }

