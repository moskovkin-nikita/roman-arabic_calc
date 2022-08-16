import java.util.HashMap;

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
    public void getData (String input){
        for (String oper : operations){
            if (input.contains(oper)){
                operation = oper;

                char[] dst2 =  new char [input.indexOf(oper)];
                input.getChars(0, input.indexOf(oper), dst2, 0);
                if (isParsable(convertRomanToArabic(new String (dst2)))){
                    first = Integer.parseInt(convertRomanToArabic(new String (dst2)));
                }
                char[] dst =  new char [input.length() - (input.indexOf(oper)+1)];
                input.getChars((input.indexOf(oper)+1), input.length(), dst, 0);
                if (isParsable(convertRomanToArabic(new String (dst)))){
                    second = Integer.parseInt(convertRomanToArabic(new String (dst)));
                }
            }
        }
    }

    @Override
    public String calculate(String input) {
        String result;
        if (Integer.parseInt(super.calculate(input)) <= 0){
            throw new IllegalArgumentException("Результат вычисления в римских числах должен быть больше нуля.");
        }
        else {
            result = convertArabicToRoman(Integer.parseInt(super.calculate(input)));
        }
        return result;
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

    String convertArabicToRoman(int input){
        String output = null;
        setRomanNumbers();
        if (input > 0 && input <= 10){
            for (Integer number : romanNumbers.keySet()){
                if (input == number){
                    output = romanNumbers.get(number);
                }
            }
        }
        else if (input > 10 && input < 40){
            int decimals = input / 10;
            int remains = input % 10;
            for (int i=0; i < 1; i++){
                output = "X";
            }
            for (int i=1; i < decimals; i++){
                output += "X";
            }
            for (Integer number : romanNumbers.keySet()){
                if (remains == number){
                    output += romanNumbers.get(number);
                }
            }
        }
        else if (input >= 40 && input < 50){
            int remainFortys = input % 40;
            output = "XL";
            for (Integer number : romanNumbers.keySet()){
                if (remainFortys == number){
                    output += romanNumbers.get(number);
                }
            }
        }
        else if (input >= 50 && input < 90){
            int fiftys = input / 50;
            int remainFiftys = input % 50;
            int decimals = remainFiftys / 10;
            int remainDecimals = remainFiftys % 10;
            for (int i = 0; i < 1; i++){
                output = "L";
            }
            for (int i=1; i < fiftys; i++){
                output += "L";
            }
            if (decimals > 0){
                for (int i=0; i < decimals; i++){
                    output += "X";
                }
            }
            for (Integer number : romanNumbers.keySet()){
                if (remainDecimals == number){
                    output += romanNumbers.get(number);
                }
            }
        }
        else if (input >= 90 && input < 100){
            int remainNinetys = input % 90;
            output = "XC";
            for (Integer number : romanNumbers.keySet()){
                if (remainNinetys == number){
                    output += romanNumbers.get(number);
                }
            }
        }
        else if (input == 100){
            output = "C";
        }
        return output;
    }
}

