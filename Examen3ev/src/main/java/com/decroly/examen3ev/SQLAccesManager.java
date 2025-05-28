package com.decroly.examen3ev;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class SQLAccesManager {


    public int insertarPropietario(Propietario nuevop){

        int response = -1;

        String sqlStatement = "INSERT INTO Propietario (dni, nombre, apellido, telefono, direcion, email)" + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = SQLDataBaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement(sqlStatement);) {

            statement.setNString(1, nuevop.getDni());
            statement.setNString(2, nuevop.getNombre());
            statement.setNString(3, nuevop.getApellidos());
            statement.setNString(4, nuevop.getTelefono());
            statement.setNString(5, nuevop.getDireccion());
            statement.setNString(6, nuevop.getEmail());

            response = statement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return response;
    }

    public List<Propietario> getProp() {
        List<Propietario> lProp = new LinkedList<>();

        String getAll = "SELECT nombre, dni FROM Propietario";

        try (Connection connection = SQLDataBaseManager.getConnection(); Statement statement = connection.createStatement();
             ResultSet dataSet = statement.executeQuery(getAll);) {
            while(dataSet.next()){
                String nombre = dataSet.getNString(1);
                String dni = dataSet.getNString(2);

                Propietario pInfo = new Propietario(nombre, dni);
                lProp.add(pInfo);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lProp;
    }

    public List<Tipo> getTipos() {
        List<Tipo> tipos = new LinkedList<>();

        String getAll = "SELECT * FROM tipo";

        try (Connection connection = SQLDataBaseManager.getConnection(); Statement statement = connection.createStatement();
             ResultSet dataSet = statement.executeQuery(getAll);) {
            while(dataSet.next()){
                int idTipo = dataSet.getInt(1);
                String tipo = dataSet.getNString(2);

                Tipo pTipo = new Tipo(idTipo, tipo);
                tipos.add(pTipo);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return tipos;
    }

    public int insertarMascota(Mascota nuevoM){

        int response = -1;

        String sqlStatement = "INSERT INTO mascota (Pasaporte, nombre, peso, fechaNacimiento, Tipo_idTipo, Propietario_dni)" + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = SQLDataBaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement(sqlStatement);) {

            statement.setNString(1, nuevoM.getPasaporte());
            statement.setNString(2, nuevoM.getNombre());
            statement.setNString(3, nuevoM.getPeso());
            statement.setNString(4, nuevoM.getFechaNacimiento().toString());
            statement.setInt(5, nuevoM.getTipo());
            statement.setNString(6, nuevoM.getPropietario());

            response = statement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return response;
    }

    public List<Mascota> getMascota() {
        List<Mascota> mascotas = new LinkedList<>();

        String getAll = "SELECT * FROM mascota";

        try (Connection connection = SQLDataBaseManager.getConnection(); Statement statement = connection.createStatement();
             ResultSet dataSet = statement.executeQuery(getAll);) {
            while(dataSet.next()){
                String pasaporte = dataSet.getString(1);
                String nombre = dataSet.getString(2);
                String peso = dataSet.getString(3);
                LocalDate fechaNacimiento = (dataSet.getDate(4)).toLocalDate();
                String Propietario = dataSet.getString(5);
                int tipo = dataSet.getInt(6);

                Mascota sMa = new Mascota(pasaporte, nombre, peso, fechaNacimiento, Propietario, tipo);
                mascotas.add(sMa);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return mascotas;
    }

    public int insertarConsulta(Consulta nuevaC){

        int response = -1;

        String sqlStatement = "INSERT INTO Consulta (Fecha, Duracion, Observaciones, Mascota_Pasaporte, Mascota_Propietario_dni)" + "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = SQLDataBaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement(sqlStatement);) {

            statement.setNString(1, nuevaC.getFecha().toString());
            statement.setNString(2, nuevaC.getDuracion());
            statement.setNString(3, nuevaC.getObservacion());
            statement.setNString(4, nuevaC.getMascota());
            statement.setNString(5, nuevaC.getPropietario());

            response = statement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return response;
    }

    public List<Mascota> getMascotaPasaporte(String pasaporte) {
        List<Mascota> mascotas = new LinkedList<>();

        String getAll = "SELECT * FROM mascota WHERE Pasaporte = ?";

        try (Connection connection = SQLDataBaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement(getAll);) {
            statement.setNString(1, pasaporte);
             ResultSet dataSet = statement.executeQuery();
            while(dataSet.next()){
                String pasaporte1 = dataSet.getString(1);
                String nombre = dataSet.getString(2);
                String peso = dataSet.getString(3);
                LocalDate fechaNacimiento = (dataSet.getDate(4)).toLocalDate();
                String Propietario = dataSet.getString(5);
                int tipo = dataSet.getInt(6);

                Mascota sMa = new Mascota(pasaporte1, nombre, peso, fechaNacimiento, Propietario, tipo);
                mascotas.add(sMa);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return mascotas;
    }

}//
