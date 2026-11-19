import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ControladorExperimentos {


    public static int[] copiarArreglo(int[] original) {
        int[] copia = new int[original.length];
        for (int i = 0; i < original.length; i++) {
            copia[i] = original[i];
        }
        return copia;
    }


    public static boolean estaOrdenado(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }


    public static boolean estaOrdenadoInteger(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }


    public static List<Results> ejecutarExperimentos() {
        List<Results> listaResultados = new ArrayList<>();
        int[] tamanios = {10000, 50000, 100000};

        for (int i = 0; i < tamanios.length; i++) {
            int n = tamanios[i];
            System.out.println("Ejecutando pruebas para n = " + n + "...");

            int[] original = Generador.generateArray(n);

            int[] copia1 = copiarArreglo(original);
            int[] copia2 = copiarArreglo(original);
            int[] copia3 = copiarArreglo(original);
            Integer[] copia4 = Generador.toIntegerArray(original);
            Comparator<Integer> comparador = (a, b) -> a - b;

            // V1: Bubble Sort
            Results r1 = Benchmark.medir(() -> Ordenamientos.bubbleSort(copia1), "V1 - Bubble Sort", "" + n);
            if (estaOrdenado(copia1)) {
                listaResultados.add(r1);
            }

            // V2: Merge Sort
            Results r2 = Benchmark.medir(() -> Ordenamientos.mergeSort(copia2), "V2 - Merge Sort", "" + n);
            if (estaOrdenado(copia2)) {
                listaResultados.add(r2);
            }

            // V3: Arrays.sort(int[])
            Results r3 = Benchmark.medir(() -> Arrays.sort(copia3), "V3 - Arrays.sort(int[])", "" + n);
            if (estaOrdenado(copia3)) {
                listaResultados.add(r3);
            }

            // V4: Arrays.sort(Integer[], Comparator)
            Results r4 = Benchmark.medir(() -> Arrays.sort(copia4, comparador), "V4 - Arrays.sort(Integer[])", "" + n);
            if (estaOrdenadoInteger(copia4)) {
                listaResultados.add(r4);
            }
        }

        return listaResultados;
    }
}