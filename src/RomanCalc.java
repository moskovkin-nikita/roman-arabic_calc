import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class RomanCalc extends ArabicCalc{
    HashMap<Integer, String> romanNumbers = new HashMap<>();

    void setRomanNumbers() {
        romanNumbers.put(1, "I");
        romanNumbers.put(2, "II");
        romanNumbers.put(3, "III");
        romanNumbers.put(4, "IV");
        romanNumbers.put(5, "V");
        romanNumbers.put(6,"VI");
        romanNumbers.put(7,"VII");
        romanNumbers.put(8,"VIII");
        romanNumbers.put(9, "IX");
        romanNumbers.put(10, "X");
    }

    @Override
    void getData (String input){
        for (String oper : operations){
            if (input.contains(oper)){
                operation = oper;

                char[] dst2 =  new char [input.indexOf(oper)];
                input.getChars(0, input.indexOf(oper), dst2, 0);
                String one = convertRomanToArabic(new String (dst2));
                if (one != null) {
                    first = Double.parseDouble(one);
                }

                char[] dst =  new char [input.length() - (input.indexOf(oper)+1)];
                input.getChars((input.indexOf(oper)+1), input.length(), dst, 0);
                String two = convertRomanToArabic(new String (dst));
                if (two != null) {
                    second = Double.parseDouble(two);
                }
            }
        }
    }

    String convertRomanToArabic(String input){
        String result = null;
        setRomanNumbers();
        if (romanNumbers.containsValue(input.toString())){
            for (Integer key : romanNumbers.keySet()){
                if (romanNumbers.get(key).equals(input.toString())){
                    result = String.valueOf(key);
                }
            }
        }
        return result;
    }

    void convertArabicToRoman(){


    }
}

