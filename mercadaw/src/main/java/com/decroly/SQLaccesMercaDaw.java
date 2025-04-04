package com.decroly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


public class SQLaccesMercaDaw {

    //toda la info
    public List<Producto> getallInfo(){
        List<Producto> allInfo = new LinkedList<>();

        String getAll = "SELECT * FROM producto";

                try (Connection connection = SQLDataBaseManager.getConnection(); Statement statement = connection.createStatement();
        ResultSet dataSet = statement.executeQuery(getAll);) {
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
                allInfo.add(p1);
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


    //buscar por tipo

    //Primero enseño los tipos que hay con el Id de los tipos
    public List<Tipos> getTipos(){
        List<Tipos> enseñarTipos = new LinkedList<>();

        String enTipos = "SELECT * FROM tipos";

        try (Connection connection = SQLDataBaseManager.getConnection(); Statement statement = connection.createStatement();
        ResultSet dataSet = statement.executeQuery(enTipos);) {
            while(dataSet.next()){
                int id = dataSet.getInt(1);
                String nombre = dataSet.getNString(2);
                
                Tipos t1 = new Tipos(id, nombre);
                enseñarTipos.add(t1);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return enseñarTipos;

            }

        //Ahora el metodo de buscar
        public List<Producto> getProductoPorTipo(int tipo){
            List<Producto> buscarTipo = new LinkedList<>();
    
            String sqlStatement = "SELECT * FROM producto WHERE tipo = ?";
    
            try (Connection connection = SQLDataBaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement(sqlStatement);) {
    
                statement.setInt(1, tipo);
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
    
                    Producto p2 =  new Producto(id, Referencia, nombre, descripcion, Tipo, cantidad, precio, descuento, iva, aplicarDto);
                    buscarTipo.add(p2);
                }
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return buscarTipo;
        }


        //Buscar por cantidad
        public List<Producto> getProductoPorCantidad(int cant){
            List<Producto> buscarCantidad = new LinkedList<>();
    
            String sqlStatement = "SELECT * FROM producto WHERE cantidad = ?";
    
            try (Connection connection = SQLDataBaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement(sqlStatement);) {
    
                statement.setInt(1, cant);
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
    
                    Producto p2 =  new Producto(id, Referencia, nombre, descripcion, Tipo, cantidad, precio, descuento, iva, aplicarDto);
                    buscarCantidad.add(p2);
                }
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return buscarCantidad;
        }


        //insertar nuevo Producto
        public int insertarProducto(Producto nuevoP){
            int response = -1;
            String sqlStatement = "INSERT INTO Producto ( referencia, nombre, descripcion, tipo, cantidad, precio, descuento, iva, aplicarDto)" + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
            try (Connection connection = SQLDataBaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement(sqlStatement);) {
    
                statement.setNString(1, nuevoP.getReferencia());
                statement.setNString(2, nuevoP.getNombre());
                statement.setNString(3, nuevoP.getDescripcion());
                statement.setInt(4, nuevoP.getTipo());
                statement.setInt(5, nuevoP.getCantidad());
                statement.setDouble(6, nuevoP.getPrecio());
                statement.setInt(7, nuevoP.getDescuento());
                statement.setInt(8, nuevoP.getIva());
                statement.setBoolean(9, nuevoP.isAplicarDto());
                
                response = statement.executeUpdate();
    
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    
            return response;
        }


        //eliminar producto por referencia
        //Pirmero un metodo para enseñar la referencia y el nombre de todos los productos
        public List<Producto> getInfoEliminar(){
            List<Producto> refYnombre = new LinkedList<>();
    
            String getAll = "SELECT referencia, nombre FROM producto";
    
                    try (Connection connection = SQLDataBaseManager.getConnection(); Statement statement = connection.createStatement();
            ResultSet dataSet = statement.executeQuery(getAll);) {
                while(dataSet.next()){

                    String Referencia = dataSet.getNString(1);
                    String nombre = dataSet.getNString(2);

                    Producto pRYF = new Producto(nombre, Referencia);
                    refYnombre.add(pRYF);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return refYnombre;
        }
        //Metodo para eliminar
        public int eliminarPorReferencia(String referencia){
            int elements = -1;
    
            String sqlStatement = "DELETE FROM producto where referencia = ?";
    
            try (Connection connection = SQLDataBaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement(sqlStatement);){
    
                statement.setNString(1, referencia);
                
                elements = statement.executeUpdate();
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return elements;
        }

        //Actualizar producto (descripción, cantidad, precio, descuento, AplicarDto)
        public int updateProductobyRef(Producto pro){
            int response = -1;
            String sqlStatement = "UPDATE producto set descripcion = ? , cantidad = ? , precio = ? , aplicarDto = ? where referencia = ?";
    
            try (Connection connection = SQLDataBaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement(sqlStatement);) {
                statement.setNString(1, pro.getDescripcion());
                statement.setInt(2, pro.getCantidad());
                statement.setDouble(3, pro.getPrecio());
                statement.setBoolean(4, pro.isAplicarDto());
                statement.setNString(5, pro.getReferencia());
    
                statement.executeUpdate();
                
            } catch (Exception e) {
                System.out.println("No se pudo actualizar el Producto: "+e.getMessage());        }
            return response;
        }

        //añadir nuevo tipo 
        public int insertarTipo(Tipos nTipo){
            int responseT = -1;
            String sqlStatement = "INSERT INTO tipos ( nombre )" + "VALUES (?)";
    
            try (Connection connection = SQLDataBaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement(sqlStatement);) {
    
                statement.setNString(1, nTipo.getNombre());
                responseT = statement.executeUpdate();
    
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    
            return responseT;
        }
}//
