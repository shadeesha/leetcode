package src.algorithms.patterns;

public class PrefixSum {

    private static int prefix_sum(int[] numArray, int start, int end) {

        for(int i = 0; i < numArray.length; i++) {
            int prev = i==0 ? 0 : numArray[i-1];
            numArray[i] = numArray[i] + prev;
        }

        return numArray[end-1] - numArray[start-1];
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7};
        System.out.println("Total : " + prefix_sum(array,3,6));
    }
}
