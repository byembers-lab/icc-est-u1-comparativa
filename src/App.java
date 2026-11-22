import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        /*long nanoTime = System.nanoTime();
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("nanoTime: " + nanoTime);
        System.out.println("CurrentMillis: " + currentTimeMillis);

        Runnable x = () -> {
            System.out.println("Ejecutando tarea 1");
            System.out.println("Ejecutando tarea 2");
        };

        List<Integer> list = new ArrayList<>();
        MetodosOrd mO = new MetodosOrd();
        mO.burbuja(list);
        Runnable burbujaOrden = ()-> mO.burbuja(list);

        //Calleable<T> x

        System.out.println("Ejcucion de la funcion Runnable");
        x.run();
        */

        /* 
        Generador g = new Generador();
        Benchmark b = new Benchmark();

        List<Integer> lista = g.generate(100000);
        System.out.println(lista);

        Results benGenResults = b.medir(()-> g.generate(100), "Generacion listado", "100000");
        System.err.println(benGenResults);
        */

        List<Results> resultados = new ArrayList<>();
        int[] tamanios = { 10000, 50000, 100000 };
        Comparator<Integer> comparador = (a, b) -> a - b;

        for (int i = 0; i < tamanios.length; i++) {
            int n = tamanios[i];
            System.out.println("Ejecutando pruebas para n = " + n + "...");

            int[] original = Generador.generate(n);

            int[] copia1 = new int[n];
            int[] copia2 = new int[n];
            int[] copia3 = new int[n];
            Integer[] copia4 = new Integer[n];
  
            for (int j = 0; j < n; j++) {
                copia1[j] = original[j];
                copia2[j] = original[j];
                copia3[j] = original[j];
                copia4[j] = original[j];
            }

            resultados.add(Benchmark.medir(() -> Ordenamientos.bubbleSort(copia1), "V1 - Bubble Sort", "" + n));
            resultados.add(Benchmark.medir(() -> Ordenamientos.mergeSort(copia2), "V2 - Merge Sort", "" + n));
            resultados
                    .add(Benchmark.medir(() -> Ordenamientos.sortPrimitivo(copia3), "V3 - Arrays.sort(int[])", "" + n));
            resultados.add(Benchmark.medir(() -> Ordenamientos.sortComparator(copia4, comparador),
                    "V4 - Arrays.sort(Integer[])", "" + n));
        }
        
        //imprimir
        System.out.println("\n=== RESULTADOS FINALES (12 MEDICIONES) ===");
        for (int i = 0; i < resultados.size(); i++) {
            System.out.println(resultados.get(i));
        }
    }
}
