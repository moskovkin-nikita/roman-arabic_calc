class ArabicCalc implements Operations {
    Integer first = 0;
    Integer second = 0;
    String operation;
    String [] operations = new String [] {"+", "-", "*", "/"};

    @Override
    public boolean checkIn (String input){
        boolean result;
        getData(input);
        result = (first >= 1 && first <= 10) && (second >= 1 && second <= 10);
        return result;
    }

    @Override
    public void getData (String input){
        for (String oper : operations){
            if (input.contains(oper)){
                operation = oper;

                char[] dst2 =  new char [input.indexOf(oper)];
                input.getChars(0, input.indexOf(oper), dst2, 0);
                if (isParsable(new String (dst2))){
                    first = Integer.parseInt(new String (dst2));
                    }
                char[] dst =  new char [input.length() - (input.indexOf(oper)+1)];
                input.getChars((input.indexOf(oper)+1), input.length(), dst, 0);
                if (isParsable(new String (dst))){
                    second = Integer.parseInt(new String (dst));
                    }
                }
            }
    }

    @Override
    public String calculate(String input) {
        Integer current;
        String result = null;
        if (checkIn(input)) {
            getData(input);
            switch (operation) {
                case ("+"):
                    current = sum();
                    result = String.valueOf(current);
                    break;
                case ("-"):
                    current = diff();
                    result = String.valueOf(current);
                    break;
                case ("*"):
                    current = multiply();
                    result = String.valueOf(current);
                    break;
                case ("/"):
                    current = divide();
                    result = String.valueOf(current);
                    break;
                default:
                    break;
            }
        }
        return result;
    }

    @Override
    public Integer sum() {
        return first + second;
    }

    @Override
    public Integer diff() {
        return first - second;
    }

    @Override
    public Integer multiply() {
        return first * second;
    }

    @Override
    public Integer divide() {
        Integer result = null;
        if (second != 0){
            result = first / second;
        }
        return result;
    }


    @Override
    public boolean isParsable(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (final NumberFormatException e) {
            return false;
        }
    }
}
