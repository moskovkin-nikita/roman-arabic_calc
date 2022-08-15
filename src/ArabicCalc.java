class ArabicCalc implements Operations {
    Double first = 0.0;
    Double second = 0.0;
    String operation;
    String [] operations = new String [] {"+", "-", "*", "/"};

    void getData (String input){
        for (String oper : operations){
            if (input.contains(oper)){
                operation = oper;

                char[] dst2 =  new char [input.indexOf(oper)+1];
                input.getChars(0, input.indexOf(oper), dst2, 0);
                first = Double.parseDouble(new String (dst2));

                char[] dst =  new char [input.length() - (input.indexOf(oper)+1)];
                input.getChars((input.indexOf(oper)+1), input.length(), dst, 0);
                second = Double.parseDouble(new String (dst));
                }
            }
    }

    boolean dataCheck(String input){
        boolean result;
        getData(input);
        if (first < 1 || first > 10 || second < 1 || second > 10){
            result = false;
        }
        else {
            result = true;
        }
        return result;
    }

    String calculate(String input) {
        String result;
        if (dataCheck(input)) {
            getData(input);
            switch (operation) {
                case ("+"):
                    result = sum();
                    break;
                case ("-"):
                    result = diff();
                    break;
                case ("*"):
                    result = multiply();
                    break;
                case ("/"):
                    result = divide();
                    break;
                default:
                    result = exeption();
                    break;
            }
        }
        else {
            result = exeption();
        }
        return result;
    }

    @Override
    public String sum() {
        return String.valueOf(first + second);
    }

    @Override
    public String diff() {
        return String.valueOf(first - second);
    }

    @Override
    public String multiply() {
        return String.valueOf(first * second);
    }

    @Override
    public String divide() {
        String result = null;
        if (second != 0){
            result = String.valueOf(first / second);
        }
        return result;
    }

    @Override
    public String exeption(){
        return "exeption";
    }
}
