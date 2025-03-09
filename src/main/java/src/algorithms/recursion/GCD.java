package src.algorithms.recursion;

public class GCD {

    public static int getGCD(int a, int b) {
        if(b == 0) {
            return a;
        } else {
            return getGCD(b, a%b);
        }
    }

    public static void main(String[] args) {
        int tot = getGCD(4,8);
        System.out.println(tot);
    }
}
