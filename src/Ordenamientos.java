public class Ordenamientos {

    //V1 Bubble sort
    public static void bubbleSort(int[] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length - 1 - i; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    int aux = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux;
                }
            }
        }
    }

    //V2 merge sort INVESTIGADO
    public static void mergeSort(int[] arr) {
        int n = arr.length;

        if (n < 2) {
            return;
        }
        int mitad = n / 2;
        int[] izquierda = new int[mitad];
        int[] derecha = new int[n - mitad];

        for (int i = 0; i < mitad; i++) {
            izquierda[i] = arr[i];
        }
        for (int i = mitad; i < n; i++) {
            derecha[i - mitad] = arr[i];
        }
        mergeSort(izquierda);
        mergeSort(derecha);
        mezclar(arr, izquierda, derecha);
    }

    public static void mezclar(int[] arr, int[] izquierda, int[] derecha) {
        int i = 0; 
        int j = 0; 
        int k = 0; 

        while (i < izquierda.length && j < derecha.length) {
            if (izquierda[i] <= derecha[j]) {
                arr[k] = izquierda[i];
                i++;
            } else {
                arr[k] = derecha[j];
                j++;
            }
            k++;
        }
        while (i < izquierda.length) {
            arr[k] = izquierda[i];
            i++;
            k++;
        }
        while (j < derecha.length) {
            arr[k] = derecha[j];
            j++;
            k++;
        }
    }
    
}
