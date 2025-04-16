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

    //Metodo para crear Pelicula
    public int insertarPelicula(Pelicula nuevoP){

        int response = -1;

            String sqlStatement = "INSERT INTO Pelicula (cod, genero)" + "VALUES (?, ?)";
    
            try (Connection connection = SQLAccesManager.getConnection(); PreparedStatement statement = connection.prepareStatement(sqlStatement);) {
    
                statement.setNString(1, nuevoP.getCod());
                statement.setInt(2, nuevoP.getGenero());
                
                
                response = statement.executeUpdate();
    
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    
            return response;
        }

    //Metodo para crear videojuego
    public int insertarVideojuego(VideoJuego nuevoV){

        int response = -1;

            String sqlStatement = "INSERT INTO Videojuego (cod, genero)" + "VALUES (?, ?)";
    
            try (Connection connection = SQLAccesManager.getConnection(); PreparedStatement statement = connection.prepareStatement(sqlStatement);) {
    
                statement.setNString(1, nuevoV.getCod());
                statement.setInt(2, nuevoV.getGenero());
                
                
                response = statement.executeUpdate();
    
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    
            return response;
        }

    //Metodos para mostrar los generos de pelicula y videojuego (2 metodos diferentes)
    public List<GenerosP> getGenerosPeli(){
        List<GenerosP> tiposPeli = new LinkedList<>();

        String getAll = "SELECT * FROM generosP";

        try (Connection connection = SQLAccesManager.getConnection(); Statement statement = connection.createStatement();
        ResultSet dataSet = statement.executeQuery(getAll);) {
            while(dataSet.next()){
                int cod = dataSet.getInt(1);
                String tipos = dataSet.getNString(2);

                GenerosP pinfo =  new GenerosP(cod, tipos);
                tiposPeli.add(pinfo);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tiposPeli;
    }


    public List<GenerosV> getGenerosVideojuego(){
        List<GenerosV> tiposVideojuego = new LinkedList<>();

        String getAll = "SELECT * FROM generosV";

        try (Connection connection = SQLAccesManager.getConnection(); Statement statement = connection.createStatement();
        ResultSet dataSet = statement.executeQuery(getAll);) {
            while(dataSet.next()){
                int cod = dataSet.getInt(1);
                String tipos = dataSet.getNString(2);

                GenerosV vinfo =  new GenerosV(cod, tipos);
                tiposVideojuego.add(vinfo);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tiposVideojuego;
    }


    //Metodo insertar persona
    //Generar automaticamente nuevo numSocio
    public String generarNuevoNumSocio(){
        String nuevoNumero = "";
        String sqlStatement = "SELECT cod FROM Articulo ORDER BY cod DESC LIMIT 1";
    
        try (Connection connection = SQLAccesManager.getConnection(); Statement statement = connection.createStatement();
        ResultSet dataSet = statement.executeQuery(sqlStatement);) {
            if (dataSet.next()){
            String ultimoNumero = dataSet.getString("cod");
            int numero = Integer.parseInt(ultimoNumero.substring(1));//le quitamos la s del principio aqui
            numero++;

            nuevoNumero = String.format("A%04d", numero); //Le damos el formato de nuevo

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return nuevoNumero;
    }





















    }//

