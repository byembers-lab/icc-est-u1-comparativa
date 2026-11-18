public class Benchmark {

    public static Results medir(Runnable accion, String nombre, String sample){
        //System.out.println("Funcion: " + nombre);
        long inicioNano = System.nanoTime();
        accion.run();
        long finNano = System.nanoTime();

        Results results = new Results(nombre, finNano - inicioNano, sample);
        return results;
    }

}
