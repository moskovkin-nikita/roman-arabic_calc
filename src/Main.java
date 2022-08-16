import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(calc(input.next()));
    }

    public static String calc(String input){
        String result;
        ArabicCalc calculatorArabic = (ArabicCalc) Manager.calcDefaultArabic();
        RomanCalc calculatorRoman = (RomanCalc) Manager.calcDefaultRoman();

        if (calculatorRoman.checkIn(input)) {
            result = calculatorRoman.calculate(input);
        }
        else if (calculatorArabic.checkIn(input)){
            result =  calculatorArabic.calculate(input);
        }
        else {
           throw new IllegalArgumentException();
        }

        return result;
    }
}
