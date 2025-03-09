package src.algorithms.recursion;

public class PowerUsingRecursion {

    public static int power(int a, int b) {
        if(b==0){
            return 1;
        } else {
            return a * power(a, b-1);
        }
    }

    public static void main(String[] args) {
        int tot = power(20,7);
        System.out.println(tot);
    }
}
