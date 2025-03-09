package src.algorithms.recursion;

public class SumOfNumbers {
    public static void main(String[] args) {
        int number = -5623;
        int tot = getSum(number);
        System.out.println(tot);
    }

    public static int getSum(int num) {
        if(num<=0) {
            return 0;
        } else {
            return num%10 + getSum(num/10);
        }
    }
}
