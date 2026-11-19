import java.util.ArrayList;
import java.util.List;

public class Generador {

    //genera un listado de tamanio size
    //con nnumeros aleatorio 0 - size
    public  static List<Integer> generate(int size){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add((int) (Math.random() * size));
        }
        return list;
    }

    public static int[] generateArray(int size) {
        if (size <= 0) {
            return new int[0];
        }
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * (size + 1));
        }
        return arr;
    }

    // Convierte int[] a Integer[] para usar en V4
    public static Integer[] toIntegerArray(int[] arr) {
        Integer[] nuevo = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nuevo[i] = arr[i];
        }
        return nuevo;
    }
}
