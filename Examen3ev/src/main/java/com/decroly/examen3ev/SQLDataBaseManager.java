package com.decroly.examen3ev;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDataBaseManager {

    private static String DRIVER;
    private static String URL;
    private static String SCHEMA;
    private static String USUARIO;
    private static String CLAVE;

    //He hecho la conexion a bases de datos con un usuario creado llamado developer
    public static Connection getConnection() {
        Connection connection = null;

        try (FileReader fichero = new FileReader("src/main/resources/application.dat");
             BufferedReader lector = new BufferedReader(fichero)) {

            String linea = lector.readLine();
            if (linea != null) {
                String[] credenciales = linea.split(",");
                if (credenciales.length >= 5) {
                    DRIVER = credenciales[0];
                    URL = credenciales[1];
                    SCHEMA = credenciales[2];
                    USUARIO = credenciales[3];
                    CLAVE = credenciales[4];
                }
            }

            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL + SCHEMA, USUARIO, CLAVE);

        } catch (FileNotFoundException e) {
            System.err.println("Error: Archivo no encontrado. Verifica la ruta: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error de lectura del archivo: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Error: Driver no encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error de conexión a la base de datos: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }

        return connection;
    }
}
