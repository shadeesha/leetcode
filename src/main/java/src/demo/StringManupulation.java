package src.demo;

import java.util.HashMap;
import java.util.Map;

public class StringManupulation {

    public static String run(boolean morseToEnglish, String textToTranslate) {
        /*
         * Write your code below; return type and arguments should be according to the problem's requirements
         */

        StringBuilder translatedText = new StringBuilder();

        Map<Character, String> morseCodeMap = new HashMap<>();
        morseCodeMap.put('A', ".-");
        morseCodeMap.put('B', "-...");
        morseCodeMap.put('C', "-.-.");
        morseCodeMap.put('D', "-..");
        morseCodeMap.put('E', ".");
        morseCodeMap.put('F', "..-.");
        morseCodeMap.put('G', "--.");
        morseCodeMap.put('H', "....");
        morseCodeMap.put('I', "..");
        morseCodeMap.put('J', ".---");
        morseCodeMap.put('K', "-.-");
        morseCodeMap.put('L', ".-..");
        morseCodeMap.put('M', "--");
        morseCodeMap.put('N', "-.");
        morseCodeMap.put('O', "---");
        morseCodeMap.put('P', ".--.");
        morseCodeMap.put('Q', "--.-");
        morseCodeMap.put('R', ".-.");
        morseCodeMap.put('S', "...");
        morseCodeMap.put('T',"-");
        morseCodeMap.put('U', "..-");
        morseCodeMap.put('V', "...-");
        morseCodeMap.put('W', ".--");
        morseCodeMap.put('X', "-..-");
        morseCodeMap.put('Y', "-.--");
        morseCodeMap.put('Z', "--..");
        morseCodeMap.put(' ', "   ");
        morseCodeMap.put('.', ".-.-.-");

        textToTranslate = textToTranslate.toString().toUpperCase();

        if(textToTranslate.length() == 0) {
            return "Invalid Morse Code Or Spacing";
        }

        if(!morseToEnglish) {
            for (int i = 0; i < textToTranslate.length(); i++) {
                char character = textToTranslate.charAt(i);
                if (morseCodeMap.get(character) != null) {
                    if(textToTranslate.charAt(i) == ' ') {
                        translatedText.append(" ");
                    } else {
                        translatedText.append(morseCodeMap.get(character));
                    }
                }
                translatedText.append(" ");
            }
        } else {
            String[] errorsplitters = textToTranslate.split(" {4}");
            if(errorsplitters.length > 1) {
                translatedText = new StringBuilder("Invalid Morse Code Or Spacing");
            } else {
                String[] splitters = textToTranslate.split(" {3}");
                for(int i=0; i<splitters.length; i++) {
                    String[] characters = splitters[i].split(" ");
                    for(int j=0; j<characters.length;j++) {
                        for (Character c : morseCodeMap.keySet()) {
                            if (morseCodeMap.get(c).equals(characters[j])) {
                                translatedText.append(c.toString().toLowerCase());
                            }
                        }
                    }
                    translatedText.append(" ");
                }
            }

        }

        return translatedText.toString();
    }

    public static void main(String[] args) {
//        String output = run(false, "The wizard quickly jinxed the gnomes before they vaporized.");
//        System.out.println(output);

        String output2 = run(true, "- .... .   .-- .. --.. .- .-. -..   --.- ..- .. -.-. -.- .-.. -.--   .--- .. -. -..- . -..   - .... .   --. -. --- -- . ...   -... . ..-. --- .-. .   - .... . -.--   ...- .- .--. --- .-. .. --.. . -.. .-.-.-");
        System.out.println(output2);
    }
}
