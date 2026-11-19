import java.util.Arrays;
import java.util.Comparator;

public class Ordenamientos {

    // V1: Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int aux = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = aux;
                }
            }
        }
    }

    // V2: Merge Sort
    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int mitad = arr.length / 2;
        int[] izq = new int[mitad];
        int[] der = new int[arr.length - mitad];

        for (int i = 0; i < mitad; i++) {
            izq[i] = arr[i];
        }
        for (int i = mitad; i < arr.length; i++) {
            der[i - mitad] = arr[i];
        }

        mergeSort(izq);
        mergeSort(der);
        merge(arr, izq, der);
    }

    private static void merge(int[] arr, int[] izq, int[] der) {
        int i = 0, j = 0, k = 0;
        while (i < izq.length && j < der.length) {
            if (izq[i] <= der[j]) {
                arr[k++] = izq[i++];
            } else {
                arr[k++] = der[j++];
            }
        }
        while (i < izq.length) {
            arr[k++] = izq[i++];
        }
        while (j < der.length) {
            arr[k++] = der[j++];
        }
    }


    public static void sortPrimitivo(int[] arr) {
        Arrays.sort(arr);
    }

    public static void sortComparator(Integer[] arr, Comparator<Integer> comp) {
        Arrays.sort(arr, comp);
    }
}
