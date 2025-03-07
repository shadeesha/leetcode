package src.algorithms;

import java.util.Arrays;
import java.util.stream.Stream;

public class MergeSort {

    public static void main(String[] args) {
        int[] numList = {54,76,12,34,7,56,99,23,45,11};

        mergeSort(numList, 0, numList.length-1);
        Arrays.stream(numList)
                .forEach(num -> System.out.print(num+", "));
    }


    private static void mergeSort(int[] numList, int left, int right) {
        if (left < right) {
            int mid = (left + right)/2;

            mergeSort(numList, left, mid);
            mergeSort(numList, mid+1, right);

            merge(numList, left, mid, right);

        }
    }

    private static void merge(int[] numList, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        for(int i = 0; i < n1; i++) {
            arr1[i] = numList[left+i];
        }

        for(int i =0; i< n2; i++) {
            arr2[i] = numList[mid + 1+ i];
        }

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                numList[k] = arr1[i];
                i++;
            } else {
                numList[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            numList[k] = arr1[i];
            i++;
            k++;
        }
        while (j < n2) {
            numList[k] = arr2[j];
            j++;
            k++;
        }

//        Arrays.stream(arr1)
//                .forEach(num -> System.out.print(num+", "));
//
//        System.out.println("Next");
//        Arrays.stream(arr2)
//                .forEach(num -> System.out.print(num+", "));
    }
}
