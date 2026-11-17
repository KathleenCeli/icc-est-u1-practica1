import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Estudiante> estudiantes = new ArrayList<>(List.of(
        new Estudiante("E014", "Ana",    20, 8.5, "Computacion"),
        new Estudiante("E003", "Luis",   19, 7.8, "Electronica"),
        new Estudiante("E018", "Maria",  21, 9.2, "Computacion"),
        new Estudiante("E007", "Pedro",  20, 8.5, "Mecatronica"),
        new Estudiante("E001", "Sofia",  18, 9.5, "Computacion"),
        new Estudiante("E012", "Diego",  22, 6.8, "Electronica"),
        new Estudiante("E005", "Ana",    19, 8.5, "Computacion"),
        new Estudiante("E020", "Carlos", 21, 7.8, "Mecatronica"),
        new Estudiante("E009", "Lucia",  20, 9.2, "Electronica"),
        new Estudiante("E016", "Mateo",  18, 7.0, "Computacion"),
        new Estudiante("E002", "Elena",  22, 8.0, "Mecatronica"),
        new Estudiante("E011", "Pablo",  21, 9.5, "Electronica"),
        new Estudiante("E006", "Sara",   19, 6.8, "Computacion"),
        new Estudiante("E019", "Juan",   20, 8.0, "Mecatronica"),
        new Estudiante("E004", "Diana",  18, 9.2, "Electronica"),
        new Estudiante("E015", "Bruno",  22, 7.0, "Computacion"),
        new Estudiante("E008", "Carla",  21, 8.5, "Mecatronica"),
        new Estudiante("E017", "Andres", 19, 9.5, "Electronica"),
        new Estudiante("E010", "Ana",    20, 8.5, "Computacion"),
        new Estudiante("E013", "Luis",   19, 7.8, "Electronica")));

        // C1: Código ascendente (Comparable y ordenamiento natural) ---
        List<Estudiante> c1 = new ArrayList<>(estudiantes);
        c1.sort(null);
        imprimirConsulta("C1", "Código ascendente (Orden natural)", c1);

        //C2: Nombre ascendente; código ascendente (Comparator con lambda de dos parámetros) ---
        List<Estudiante> c2 = new ArrayList<>(estudiantes);
        c2.sort((a, b) -> {int cmpNombre = a.getNombre().compareTo(b.getNombre());
            return (cmpNombre != 0) ? cmpNombre : a.getCodigo().compareTo(b.getCodigo());
        });
        imprimirConsulta("C2", "Nombre ascendente; código ascendente (Lambda 2 parámetros)", c2);

        //Punto 3: C2 con comparing(), thenComparing() y referencias a métodos
        List<Estudiante> c2Ref = new ArrayList<>(estudiantes);
        c2Ref.sort(Comparator.comparing(Estudiante::getNombre).thenComparing(Estudiante::getCodigo));
        imprimirConsulta("C2-Ref", "Nombre ascendente; código ascendente (Referencias a métodos)", c2Ref);

        //C3: Nota ascendente, sin desempate (comparingDouble y referencia a método)
        List<Estudiante> c3 = new ArrayList<>(estudiantes);
        c3.sort(Comparator.comparingDouble(Estudiante::getNota));
        imprimirConsulta("C3", "Nota ascendente, sin desempate (Estable)", c3);

        //C4: Nota descendente; nombre ascendente (reversed y thenComparing)
        List<Estudiante> c4 = new ArrayList<>(estudiantes);
        c4.sort(Comparator.comparingDouble(Estudiante::getNota).reversed().thenComparing(Estudiante::getNombre));
        imprimirConsulta("C4", "Nota descendente; nombre ascendente", c4);

        //C5: Edad ascendente; nombre descendente (comparingInt y sentido independiente)
        List<Estudiante> c5 = new ArrayList<>(estudiantes);
        c5.sort(Comparator.comparingInt(Estudiante::getEdad).thenComparing(Estudiante::getNombre, Comparator.reverseOrder()));
        imprimirConsulta("C5", "Edad ascendente; nombre descendente", c5);

        //C6: Carrera asc; nota desc; nombre asc; código asc (Composición de 4 criterios)
        List<Estudiante> c6 = new ArrayList<>(estudiantes);
        c6.sort(Comparator.comparing(Estudiante::getCarrera)
                .thenComparing(Comparator.comparingDouble(Estudiante::getNota).reversed())
                .thenComparing(Estudiante::getNombre).thenComparing(Estudiante::getCodigo));
        imprimirConsulta("C6", "Carrera asc; nota desc; nombre asc; código asc", c6);

        //C7: Nota ajustada descendente; nombre ascendente; código ascendente
        List<Estudiante> c7 = new ArrayList<>(estudiantes);
        java.util.function.ToDoubleFunction<Estudiante> notaAjustada = e ->e.getCarrera()
                        .equals("Computacion") ? Math.min(10.0, e.getNota() + 0.5) : e.getNota();

        c7.sort(Comparator.comparingDouble(notaAjustada).reversed().thenComparing(Estudiante::getNombre)
                            .thenComparing(Estudiante::getCodigo));
        System.out.println("\n[C7] Criterio: Nota ajustada descendente; nombre ascendente; código ascendente");
        for (Estudiante e : c7) {
            System.out.printf("%s | Nota ajustada: %.1f%n", e, notaAjustada.applyAsDouble(e));
        }
    }

    public static void imprimirConsulta(String id, String criterio, List<Estudiante> lista) {
        System.out.println("\n[" + id + "] Criterio: " + criterio);
        for (Estudiante e : lista) {
            System.out.println(e);
        }
    }

    

}