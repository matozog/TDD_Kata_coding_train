package calculator;

import java.util.ArrayList;
import java.util.Arrays;

public class StringCalculator {

    private static ArrayList<String> operators = new ArrayList<String>(Arrays.asList("+", "*","^", "?"));

    public int Add(String numbers) throws Exception {
        if (numbers.equals(""))
            return 0;

        String delimiter = "";

        if(numbers.length() > 2 && numbers.substring(0,2).equals("//")){
            delimiter = numbers.substring(2, numbers.indexOf("\n"));
            numbers = numbers.substring(3 + delimiter.length() ,numbers.length());
            if(delimiter.charAt(0) == '['){
                delimiter = delimiter.substring(1, delimiter.indexOf(']'));
            }
            numbers = numbers.replace(delimiter, ",");
        }

        String delimiterRegex = "[ , | \\n | " + delimiter + "]";
        String[] numbersArray = numbers.split(delimiterRegex);
        StringBuilder negativeNumbers = new StringBuilder();
        boolean negativeFlag = false;
        int result = 0, actualNumber;
        for (String number : numbersArray) {
            actualNumber = Integer.parseInt(number);
            if(actualNumber < 0) {
                negativeFlag = true;
                negativeNumbers.append(" ").append(number);
            }
            if(actualNumber <= 1000)
                result += actualNumber;
        }

        if(negativeFlag){
            throw new Exception("Negative number not allowed" + negativeNumbers.toString());
        }

        return result;
    }

}
