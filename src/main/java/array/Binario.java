package array;

import java.util.Arrays;
import java.util.stream.Stream;

public class Binario {

    public <T> Object[] convertStreamToArray(Stream<T> stream)
    {
        return stream.toArray();
    }
    public boolean find(Integer[] array, int number) {
        return binarySearch(sort(array), number);
    }

    private boolean binarySearch(Object[] array, int number) {
        while (true) {
            int index = Math.round(array.length/2);
            if ((int)array[index] == number)
                return true;
            else if (index == 0)
                return false;
            array = reduceArray(array, number, index);
        }
    }

    private Object[] reduceArray(Object[] array, int number, int index) {
        Object [] aux;
        if ((int)array[index] < number) {
            aux = new Object[array.length - index - 1];
            System.out.println(aux.length);
            int auxIndex = 0;
            for (int i = index + 1; i < array.length; i++)
                aux[auxIndex++] = array[i];
            return aux;
        }
        aux = new Object[index];
        for (int i = 0; i < aux.length; i++)
            aux[i] = array[i];
        return aux;

    }

    private Object[] sort(Integer[] array) {
        Stream<Integer> stream = Arrays.stream(array).sorted();
        return convertStreamToArray(stream);
    }
}
