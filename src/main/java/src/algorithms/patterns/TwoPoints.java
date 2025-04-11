package src.algorithms.patterns;

public class TwoPoints {

    private static boolean checkPalingdrom(String word) {
        int startPoint = 0;
        int endPoint = word.length()-1;
        boolean isPalingdrom = true;
        L1 : for(startPoint = 0; startPoint < endPoint; startPoint++) {
//            System.out.println(word.charAt(startPoint) + " : " + word.charAt(endPoint));
            if(word.charAt(startPoint) != word.charAt(endPoint)) return false;
            endPoint--;
        }
        return isPalingdrom;
    }


    public static void main(String[] args) {
        String st = "abcdchba";

        boolean isPalingdrome = checkPalingdrom(st);
        System.out.println("Is Plaingdrom : " + isPalingdrome);
    }
}
