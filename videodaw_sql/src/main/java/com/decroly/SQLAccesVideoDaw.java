package com.decroly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
            //generamos el cod del articulo automaticamente
            public String generarcod(){
                String nuevoNumero = "";
                String sqlStatement = "SELECT cod FROM Articulo ORDER BY cod DESC LIMIT 1";
            
                try (Connection connection = SQLAccesManager.getConnection(); Statement statement = connection.createStatement();
                ResultSet dataSet = statement.executeQuery(sqlStatement);) {
                    if (dataSet.next()){
                    String ultimoNumero = dataSet.getString("cod");
                    int numero = Integer.parseInt(ultimoNumero.substring(1));//le quitamos la A del principio aqui
                    numero++;
        
                    nuevoNumero = String.format("A%04d", numero); //Le damos el formato de nuevo
        
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
        
                return nuevoNumero;
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
    public String generarNumSocio(){
        String nuevoNumero = "";
        String sqlStatement = "SELECT numSocio FROM cliente ORDER BY numSocio DESC LIMIT 1";
    
        try (Connection connection = SQLAccesManager.getConnection(); Statement statement = connection.createStatement();
        ResultSet dataSet = statement.executeQuery(sqlStatement);) {
            if (dataSet.next()){
            String ultimoNumero = dataSet.getString("numSocio");
            int numero = Integer.parseInt(ultimoNumero.substring(1));//le quitamos la s del principio aqui
            numero++;

            nuevoNumero = String.format("S%04d", numero); //Le damos el formato de nuevo

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return nuevoNumero;
    }

    //Primero el metodo de crear Persona
    public int insertarPersona(Persona nuevaP){

        int response = -1;

            String sqlStatement = "INSERT INTO Persona (dni, nombre, direccion, fecha_nacimiento)" + "VALUES (?, ?, ?, ?)";
    
            try (Connection connection = SQLAccesManager.getConnection(); PreparedStatement statement = connection.prepareStatement(sqlStatement);) {
    
                statement.setNString(1, nuevaP.getDni());
                statement.setNString(2, nuevaP.getNombre());
                statement.setNString(3, nuevaP.getDireccion());
                statement.setDate(4, java.sql.Date.valueOf(nuevaP.getFechaNacimiento()));
                
                response = statement.executeUpdate();
    
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    
            return response;
        }

    //Metodo para crear cliente
    public int insertarCliente(Cliente nuevoC){

        int response = -1;

            String sqlStatement = "INSERT INTO Cliente (numSocio, dni)" + "VALUES (?, ?)";
    
            try (Connection connection = SQLAccesManager.getConnection(); PreparedStatement statement = connection.prepareStatement(sqlStatement);) {
    
                statement.setNString(1, nuevoC.getNumSocio());
                statement.setNString(2, nuevoC.getDni());

                
                response = statement.executeUpdate();
    
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    
            return response;
        }

        //Metodos para alquilar pelicula y videojuego

        public int alquilarPelicula(String alqP){
            int response = -1;
            String sqlStatement = "UPDATE Pelicula set isAlquilada = true , fechaAlquiler = CURRENT_DATE() WHERE cod = ?";
    
            try (Connection connection = SQLAccesManager.getConnection(); PreparedStatement statement = connection.prepareStatement(sqlStatement);) {

                statement.setNString(1, alqP);
                statement.executeUpdate();
                
            } catch (Exception e) {
                System.out.println("No se pudo actualizar el Producto: "+e.getMessage());        }
            return response;
        }

        //El de Videojuego
        public int alquilarVideojuego(String alqV){
            int response = -1;
            String sqlStatement = "UPDATE Videojuego set isAlquilada = true , fechaAlquiler = CURRENT_DATE() WHERE cod = ?";
    
            try (Connection connection = SQLAccesManager.getConnection(); PreparedStatement statement = connection.prepareStatement(sqlStatement);) {

                statement.setNString(1, alqV);
                statement.executeUpdate();
                
            } catch (Exception e) {
                System.out.println("No se pudo actualizar el Producto: "+e.getMessage());        }
            return response;
        }


        //Metodos para devolver pelicula y videojuego

        public int devolverPelicula(String dvlP){
            int response = -1;
            String sqlStatement = "UPDATE Pelicula set isAlquilada = false , fechaAlquiler = null WHERE cod = ?";
    
            try (Connection connection = SQLAccesManager.getConnection(); PreparedStatement statement = connection.prepareStatement(sqlStatement);) {

                statement.setNString(1, dvlP);
                statement.executeUpdate();
                
            } catch (Exception e) {
                System.out.println("No se pudo actualizar el Producto: "+e.getMessage());        }
            return response;
        }

        //El de Videojuego
        public int devolverVideojuego(String dvlV){
            int response = -1;
            String sqlStatement = "UPDATE Videojuego set isAlquilada = false , fechaAlquiler = null WHERE cod = ?";
    
            try (Connection connection = SQLAccesManager.getConnection(); PreparedStatement statement = connection.prepareStatement(sqlStatement);) {

                statement.setNString(1, dvlV);
                statement.executeUpdate();
                
            } catch (Exception e) {
                System.out.println("No se pudo actualizar el Producto: "+e.getMessage());        }
            return response;
        }

        //Sumar o restar articulos alquilados
        //Sumamos uno a los articulos alquilados y actualizamos el campo
        public void sumarYActualizarAlquilado(String actAlq) {

            String sqlSelect = "SELECT articulosAlquilados FROM cliente WHERE numSocio = ?";
            String sqlUpdate = "UPDATE cliente SET articulosAlquilados = ? WHERE numSocio = ?";
        
            try (Connection connection = SQLAccesManager.getConnection();
                PreparedStatement selectStatement = connection.prepareStatement(sqlSelect);
                PreparedStatement updateStatement = connection.prepareStatement(sqlUpdate)) {
        
                selectStatement.setNString(1, actAlq);
                ResultSet dataSet = selectStatement.executeQuery();
        
                if (dataSet.next()) {
                    int articulosAlq = dataSet.getInt("articulosAlquilados");
                    articulosAlq++; // sumamos uno
        
                    // Ahora hacemos el update con el nuevo valor
                    updateStatement.setInt(1, articulosAlq);
                    updateStatement.setNString(2, actAlq);
                    updateStatement.executeUpdate();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        //restamos uno a los articulos alquilados y actualizamos el campo
        public void restarYActualizarAlquilado(String actAlq) {

            String sqlSelect = "SELECT articulosAlquilados FROM cliente WHERE numSocio = ?";
            String sqlUpdate = "UPDATE cliente SET articulosAlquilados = ? WHERE numSocio = ?";
        
            try (Connection connection = SQLAccesManager.getConnection();
                PreparedStatement selectStatement = connection.prepareStatement(sqlSelect);
                PreparedStatement updateStatement = connection.prepareStatement(sqlUpdate)) {
        
                selectStatement.setNString(1, actAlq);
                ResultSet dataSet = selectStatement.executeQuery();
        
                if (dataSet.next()) {
                    int articulosAlq = dataSet.getInt("articulosAlquilados");
                    articulosAlq--; // restamos uno
        
                    // Ahora hacemos el update con el nuevo valor
                    updateStatement.setInt(1, articulosAlq);
                    updateStatement.setNString(2, actAlq);
                    updateStatement.executeUpdate();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


        //Dar de baja lo hago con un update para que el fecha baja sea funcional, a diferencia de con un delete que lo borraria de la base de datos y 
        //entonces no serviria de nada el fecha baja
        //Metodo dar de baja cliente
        public int bajaCliente(String bajaC){
            int response = -1;
            String sqlStatement = "UPDATE Cliente set fechabaja = CURRENT_DATE() WHERE numSocio = ?";
    
            try (Connection connection = SQLAccesManager.getConnection(); PreparedStatement statement = connection.prepareStatement(sqlStatement);) {

                statement.setNString(1, bajaC);
                statement.executeUpdate();
                
            } catch (Exception e) {
                System.out.println("No se pudo dar de baja al cliente: "+e.getMessage());        }
            return response;
        }

        //Metodo dar baja Articulo
        public int bajaArticulo(String bajaA){
            int response = -1;
            String sqlStatement = "UPDATE Articulo set fechabaja = CURRENT_DATE() WHERE cod = ?";
    
            try (Connection connection = SQLAccesManager.getConnection(); PreparedStatement statement = connection.prepareStatement(sqlStatement);) {

                statement.setNString(1, bajaA);
                statement.executeUpdate();
                
            } catch (Exception e) {
                System.out.println("No se pudo dar de baja al cliente: "+e.getMessage());        }
            return response;
        }

        //Metodo para mostrar los articulos sin dar de baja
        public List<Articulo> getInfoArticulos(){
            List<Articulo> infoArticulos = new LinkedList<>();
    
            String getAll = "SELECT cod, titulo FROM articulo WHERE fechabaja is null";
    
            try (Connection connection = SQLAccesManager.getConnection(); Statement statement = connection.createStatement();
            ResultSet dataSet = statement.executeQuery(getAll);) {
                while(dataSet.next()){
                    String cod = dataSet.getNString(1);
                    String titulo = dataSet.getNString(2);
    
    
                    Articulo a1 =  new Articulo(cod, titulo);
                    infoArticulos.add(a1);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return infoArticulos;
        }













    }//

