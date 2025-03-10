package src.algorithms;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] numList = {54,76,12,34,7,56,99,23,45,11};

        quickSort(numList, 0, numList.length-1);
        Arrays.stream(numList)
                .forEach(num -> System.out.print(num+", "));
    }

    private static void quickSort(int[] numList, int start, int end) {
        if(start >= end) return;
        int pivot = partition(numList, start, end);
        quickSort(numList, start, pivot - 1);
        quickSort(numList, pivot + 1, end);
    }

    private static int partition(int[] numList, int start, int end) {
        int pivot = numList[end];
        int i = start - 1;
        for(int j =start; j<=end-1; j++) {
            if(pivot > numList[j]) {
                i++;
                int temp = numList[i];
                numList[i] = numList[j];
                numList[j] = temp;
            }
        }
        i++;
        int temp = numList[i];
        numList[i] = numList[end];
        numList[end] = temp;

        return i;
    }
}
