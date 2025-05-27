package Utils;

import com.decroly.simulacroexamen.Medicos;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FileUtils {

    public static void writeFile(String fileName, List<Medicos> medico) {
        //Escritura del objeto
        try (FileOutputStream file = new FileOutputStream("src\\main\\resources\\"+fileName, false);
             ObjectOutputStream buffer = new ObjectOutputStream(file)){
            //buffer.writeObject(personas);
            for (Medicos medicos : medico) {
                buffer.writeObject(medico);
            }

        } catch (IOException e) {
            System.out.println("Se ha producido un error: "+e.getMessage());
        }
    }

    public static List<Medicos> readFile(String fileName) {
        List<Medicos> medico = new LinkedList<>();
        //Lectura del objeto
        boolean eof = false;
        try (FileInputStream file = new FileInputStream("src\\main\\resources\\"+fileName);
             ObjectInputStream reader = new ObjectInputStream(file)) {
            while (!eof) {
                Medicos p = (Medicos) reader.readObject();
                medico.add(p);
            }
        } catch (EOFException e) {
            eof = true;
            System.out.println("Se ha leido el fichero completo");
        } catch (IOException e) {
            System.out.println("Se ha producido un error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Se ha producido un error: " + e.getMessage());
        }

        return medico;
    }


}
