package Week9.searching;

import java.util.Arrays;

public class BinarySearching {
    public static void main(String[] args){
        int[] nums = {18,42,5,21,24,5,20,48,11,13,117};

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        //int index = binarySearch(nums, 20);
        int index = binarySearchRecur(nums, 5);
        System.out.println("Index found: " + index);
    }

    public static int binarySearch(int[] array, int search){
        int low = 0;
        int high = array.length - 1;

        while(low <= high){
            int mid = (high + low) / 2;

            if(array[mid] == search){
                return mid;
            } else if (array[mid] > search){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static int binarySearchRecur(int[] array, int search){
        int low = 0;
        int high = array.length - 1;

        int mid = (high + low) / 2;

        if(search == array[mid]){
            return array[mid];
        } else if(search != array[mid]) {
            int[] newArray = new int[(array.length - 1) / 2];

            if (search < array[mid]){
                high = mid - 1;

                for(int i = 0; i < high; i++){
                    newArray[i] = array[i];
                }

                return binarySearchRecur(newArray, search);
            } else if (search > array[mid]) {
                low = mid + 1;

                for(int i = 0; i < mid; i++){
                    newArray[i] = array[low + i];
                }

                return binarySearchRecur(newArray, search);
            }
        }

        return -1;
    }
}
