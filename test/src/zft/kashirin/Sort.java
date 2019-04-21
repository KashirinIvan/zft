package zft.kashirin;

import java.util.Comparator;

public class Sort<T> {
    private Comparator<T> comparator;

    public Sort(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public Sort() {
    }

    private int compare(T first, T second, String mode) {
        if (comparator != null) {
            if (mode.equals("a")) {
                return comparator.compare(first, second);
            } else if (mode.equals("d")) {
                return comparator.compare(second, first);
            }
        }
        if (mode.equals("a")) {
            return ((Comparable<T>) first).compareTo(second);
        } else if (mode.equals("d")) {
            return ((Comparable<T>) second).compareTo(first);
        }
        return 0;
    }

    public void insertSort(T[] array, String mode) {
        for (int i = 1; i < array.length; i++) {
            T temp = array[i];
            for (int j = i - 1; ; j--) {
                if (j < 0 || compare(temp, array[j], mode) > 0) {
                    array[j + 1] = temp;
                    break;
                } else {
                    array[j + 1] = array[j];
                }
            }
        }
    }
}
