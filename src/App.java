import java.util.ArrayList;
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

        Generador g = new Generador();
        Benchmark b = new Benchmark();

        List<Integer> lista = g.generate(100000);
        System.out.println(lista);

        Results benGenResults = b.medir(()-> g.generate(100), "Generacion listado", "100000");
        System.err.println(benGenResults);
    }
}
