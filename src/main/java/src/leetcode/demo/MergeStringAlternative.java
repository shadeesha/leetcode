package src.leetcode.demo;

import java.util.stream.Stream;

public class MergeStringAlternative {

    String output2 = "";
    int i = 0;

    public String mergeAlternately(String word1, String word2) {

        String tail = "";
        if(word1.length() > word2.length()) {
            tail = word1.substring(word2.length());
            word1 = word1.substring(0, word2.length());
        } else {
            tail = word2.substring(word1.length());
            word2 = word2.substring(0, word1.length());
        }
        String output = "";
        for(int i=0; i < word1.length(); i++) {
            output = output + String.valueOf(word1.charAt(i)) + String.valueOf(word2.charAt(i));
        }

        return output + tail;
    }

    public String mergeAlternatelyTest(String word1, String word2) {
        i = 0;
        output2 = "";
        Stream.of(word1)
                .forEach(s -> {
                    output2 = output2 + word1.charAt(i) + word2.charAt(i);
                    i++;
                });

        return output2;
    }

    public static void main(String[] args) {
        MergeStringAlternative test = new MergeStringAlternative();
        System.out.println(test.mergeAlternatelyTest("abc", "pqrs"));
    }
}
