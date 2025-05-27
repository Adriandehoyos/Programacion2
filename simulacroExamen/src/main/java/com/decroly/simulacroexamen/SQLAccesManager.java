package com.decroly.simulacroexamen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class SQLAccesManager {


    public List<Medicos> getMedicos() {
        List<Medicos> lMedicos = new LinkedList<>();

        String getAll = "SELECT * FROM medicos";

        try (Connection connection = SQLDataBaseManager.getConnection(); Statement statement = connection.createStatement();
             ResultSet dataSet = statement.executeQuery(getAll);) {
            while(dataSet.next()){
                String dni = dataSet.getNString(1);
                String nombre = dataSet.getNString(2);
                String direccion = dataSet.getNString(3);
                LocalDate fechaNacimiento = LocalDate.parse(dataSet.getString(4));
                Especialidad especialidad = Especialidad.valueOf(dataSet.getNString(5));

                Medicos mInfo = new Medicos(dni, nombre, direccion, fechaNacimiento, especialidad);
                lMedicos.add(mInfo);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lMedicos;
    }

    public int insertarMedico(Medicos nuevoM){

        int response = -1;

        String sqlStatement = "INSERT INTO Medicos (dni, nombre, direccion, fecha_nacimiento, especialidad)" + "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = SQLDataBaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement(sqlStatement);) {

            statement.setNString(1, nuevoM.getDni());
            statement.setNString(2, nuevoM.getNombre());
            statement.setNString(3, nuevoM.getDireccion());
            statement.setNString(4, nuevoM.getFechaNacimiento().toString());
            statement.setNString(5, nuevoM.getEspecialidad().toString());

            response = statement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return response;
    }


    public int eliminarMedico(Medicos deleteMe){
        int elements = -1;

        String sqlStatement = "DELETE FROM medicos where dni = ?";

        try (Connection connection = SQLDataBaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement(sqlStatement);){

            statement.setNString(1, deleteMe.getDni());

            elements = statement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return elements;
    }

    public int updateMedico(Medicos meUpdate){
        int response = -1;
        String sqlStatement = "UPDATE medicos SET nombre = ? , direccion = ? , fecha_nacimiento = ? , especialidad = ? where dni = ?";

        try (Connection connection = SQLDataBaseManager.getConnection(); PreparedStatement statement = connection.prepareStatement(sqlStatement);) {
            statement.setNString(1, meUpdate.getNombre());
            statement.setNString(2, meUpdate.getDireccion());
            statement.setNString(3, meUpdate.getFechaNacimiento().toString());
            statement.setNString(4, meUpdate.getEspecialidad().toString());
            statement.setNString(5, meUpdate.getDni());

            statement.executeUpdate();

        } catch (Exception e) {
            System.out.println("No se pudo actualizar el Producto: "+e.getMessage());        }
        return response;
    }



}//
