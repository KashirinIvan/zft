package zft.kashirin;

import java.util.Comparator;

public class Sort<T> {
    private Comparator<T> comparator;

    public Sort(Comparator<T> comparator){
        this.comparator=comparator;
    }
    public Sort(){}

    private int compare(T first, T second){
        if (comparator != null)
        {
            return comparator.compare(first,second);
        }
        return ((Comparable<T>)first).compareTo(second);
    }

    public void insertSort(T[] array) {
        for (int i = 1; i < array.length; i++) {
            T temp = array[i];
            for (int j = i - 1; ; j--) {
                if (j < 0 || compare(temp, array[j])>0) {
                    array[j + 1] = temp;
                    break;
                } else {
                    array[j + 1] = array[j];
                }
            }
        }
    }
}
