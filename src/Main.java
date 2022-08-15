import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(calc(input.next()));
    }

    public static String calc(String input){
        String result = null;
        ArabicCalc calculatorArabic = (ArabicCalc) Manager.calcDefaultArabic();
        RomanCalc calculatorRoman = (RomanCalc) Manager.calcDefaultRoman();

        if (calculatorRoman.dataCheck(input)) {
            result = calculatorRoman.calculate(input);
        }
        else if (calculatorArabic.dataCheck(input)){
            result =  calculatorArabic.calculate(input);

        }
        else {
            result = calculatorArabic.exeption();
        }

        return result;
    }
}
