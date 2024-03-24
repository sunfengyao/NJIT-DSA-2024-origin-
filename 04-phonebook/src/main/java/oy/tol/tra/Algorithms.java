package oy.tol.tra;

import java.util.Comparator;

public class Algorithms {

    public static <T> void sortWithComparator(T[] array, Comparator<T> comparator) {
        if (array == null || array.length <= 1) {
            return;
        }
        qSByComparator(array, 0, array.length - 1, comparator);
    }

    private static <T> void qSByComparator(T[] array, int low, int high, Comparator<T> comparator) {
        if (low < high) {
            int pivotIndex = partitionWithComparator(array, low, high, comparator);
            qSByComparator(array, low, pivotIndex - 1, comparator);
            qSByComparator(array, pivotIndex + 1, high, comparator);
        }
    }

    private static <T> int partitionWithComparator(T[] array, int low, int high, Comparator<T> comparator) {
        T pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (comparator.compare(array[j], pivot) < 0) {
                i++;
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        T temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    public static <T extends Comparable<T>> void fastSort(T[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        quickSort(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void quickSort(T[] array, int left, int right) {
        if (left < right) {
            int index = partition(array, left, right);
            quickSort(array, left, index - 1);
            quickSort(array, index + 1, right);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] array, int left, int right) {
        T pivot = array[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, right);
        return i + 1;
    }

    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static <T> int partitionByRule(T[] array, int length, Rule<T> rule) {
        for (int i = 0; i < length; i++) {
            if (rule.check(array[i])) {
                return i;
            }
        }
        return length;
    }

    public interface Rule<T> {
        boolean check(T element);
    }
}
