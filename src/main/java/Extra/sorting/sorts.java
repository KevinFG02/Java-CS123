package Extra.sorting;

import java.util.ArrayList;

public class sorts {
    public static void main(String[] args){

    }

    public static void insertionSort(int[] array){
        for(int i = 0; i < array.length; i++){
            for(int j = i; j > 0; j--){
                if(array[j] < array[j - 1]){
                    //swap(array, j, j - 1);
                }
            }
        }
    }

    public static void sorting(int[] array){
        ArrayList<Integer> sortedArray = new ArrayList<>(array.length);

        for(int i = 0; i < array.length; i++){
            for(int j = i; j < array.length; j++){
                if(array[i] < array[j + 1]){
                    
                }
            }
        }
    }

    /*
    private static void swap{
        //int temp = array[];
    }*/
}