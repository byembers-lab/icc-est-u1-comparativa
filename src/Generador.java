
public class Generador {

    //genera un listado de tamanio size
    //con nnumeros aleatorio 0 - size
    public static int[] generate(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * size);
        }
        return arr;
    }
}
