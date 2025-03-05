package src.demo;

import java.util.stream.IntStream;

public class FizzBuzz {

    static String s = "";
    public static String run(int N, int M) {
        s = "";
        IntStream.rangeClosed(N,M)
                .forEach(num -> {
                    if(num%15 == 0) {
                        s = s + ",FizzBuzz";
                    } else if(num%3 == 0) {
                        s = s + ",Fizz";
                    } else if(num%5 == 0) {
                        s = s + ",Buzz";
                    } else {
                        s = s + ","+num;
                    }
                });

        return s.substring(1);
    }

    public static void main(String[] args) {
        System.out.println(run(1,5));
    }
}
