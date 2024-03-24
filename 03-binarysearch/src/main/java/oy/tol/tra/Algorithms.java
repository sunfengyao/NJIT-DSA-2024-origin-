package oy.tol.tra;

import java.util.Arrays;

public class Algorithms {
    public static <T extends Comparable<T>> void sort(T[] array) {
        Arrays.sort(array);
    }

    public static <T extends Comparable<T>> int binarySearch(T item, T[] array, int fromIndex, int toIndex) {
        while (fromIndex <= toIndex) {
            int mid = fromIndex + (toIndex - fromIndex) / 2;
            int cmp = item.compareTo(array[mid]);
            if (cmp > 0){
                fromIndex = mid + 1;
            }else if (cmp == 0){
                return mid;
            }else {
                toIndex = mid - 1;
            }
        }
        return -1;
    }
}
