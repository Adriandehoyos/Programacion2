package Utils;

import com.decroly.examen3ev.Mascota;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FileUtils {

    public static void writeFile(String fileName, List<Mascota> mascotas) {
        //Escritura del objeto
        try (FileOutputStream file = new FileOutputStream("src\\main\\resources\\"+fileName, false);
             ObjectOutputStream buffer = new ObjectOutputStream(file)){
            //buffer.writeObject(personas);
            for (Mascota mascota : mascotas) {
                buffer.writeObject(mascotas);
            }

        } catch (IOException e) {
            System.out.println("Se ha producido un error: "+e.getMessage());
        }
    }

    public static List<Mascota> readFile(String fileName) {
        List<Mascota> mascotas = new LinkedList<>();
        //Lectura del objeto
        boolean eof = false;
        try (FileInputStream file = new FileInputStream("src\\main\\resources\\"+fileName);
             ObjectInputStream reader = new ObjectInputStream(file)) {
            while (!eof) {
                Mascota p = (Mascota) reader.readObject();
                mascotas.add(p);
            }
        } catch (EOFException e) {
            eof = true;
            System.out.println("Se ha leido el fichero completo");
        } catch (IOException e) {
            System.out.println("Se ha producido un error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Se ha producido un error: " + e.getMessage());
        }

        return mascotas;
    }


}
