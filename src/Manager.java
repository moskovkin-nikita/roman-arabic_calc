public class Manager {
    static Operations calcDefaultArabic (){
        return new ArabicCalc();
    }
    static Operations calcDefaultRoman (){
        return  new RomanCalc();
    }

}
