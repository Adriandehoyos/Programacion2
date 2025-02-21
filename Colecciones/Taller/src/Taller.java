import java.util.HashMap;
import java.util.Map;

public class Taller {

    private String matricula;
    Map<String, Coche > coches = new HashMap<String, Coche>();

    public String meterCoche(String matricula, String color, String marca) {
        if (!coches.containsKey(matricula)) {
            Coche coche = new Coche(color, marca);
            coches.put(matricula, coche);
            return "Coche añadido correctamente";
        } else {
            return "Ya existe un coche con esa matricula";
        }
    }

    public String borrarCoche(String matricula) {
        if (coches.containsKey(matricula)) {
            coches.remove(matricula);
            return "Coche eliminado correctamente";
        } else {
            return "No existe un coche con esa matricula";
        }
    } 

    public void visualizaMatriculas() {
        System.out.println(coches.keySet());
    }

    public void visualizaCoches() {
        for (Coche coche : coches.values()) {
            System.out.println(coche);
        }
    }

    public void visualizaTaller() {
        for (var entry : coches.entrySet()) {
            System.out.println("Matrícula: " + entry.getKey() + ", " + entry.getValue());
        }
    }
}//
