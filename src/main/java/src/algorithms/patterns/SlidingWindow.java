package src.algorithms.patterns;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SlidingWindow {

    private static int[] checkSum(int[] numArray) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(numArray[0]);
        queue.add(numArray[1]);
        queue.add(numArray[2]);
        int[] retVal = new int[3];
        int tot = 0;

        for(int j : queue) {
            tot = tot + j;
        }

        for(int i=3; i<numArray.length; i++) {
            int temp = tot;
            tot = tot + numArray[i] - queue.element();
            queue.add(numArray[i]);
            queue.remove();
            if(temp < tot) {
                retVal = queue.stream().mapToInt(Integer::intValue).toArray();
            }
        }

        return retVal;
    }

    public static void main(String[] args) {
        int[] numArray = new int[]{1,2,3,4,5,6,7,8};

        int[] returnVal = checkSum(numArray);
        for(int i : returnVal) {
            System.out.println(i);
        }
    }
}
