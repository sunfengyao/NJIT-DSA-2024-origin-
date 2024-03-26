package oy.tol.tra;

public class Algorithms {
    public static <T extends Comparable<T>> void sort(T [] array) {
        boolean swapped = true;  
        for (int i = 1, len = list.length; i < len && swapped; ++i) {  
            swapped = false;  
            for (int j = 0; j < len - i; ++j) {  
                if (array[j].compareTo(array[j + 1]) > 0) {  
                    T temp = array[j];  
                    array[j] = array[j + 1];  
                    array[j + 1] = temp;  
                    swapped = true;  
                }  
            }  
        }  
    }
    public static String reverse3(String s) { 

         char[] array = s.toCharArray(); 

        String reverse = "";  //新建空字符串

        for (int i = array.length - 1; i >= 0; i--) 

            reverse += array[i]; 

            return reverse; 
  } 
}
