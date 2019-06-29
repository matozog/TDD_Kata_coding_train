package calculator;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private Pattern exprBetweenBracket = Pattern.compile("\\[(.*?)\\]");
    private ArrayList<String> delimiters = new ArrayList<>();

    public int Add(String numbers) throws Exception {
        StringBuilder negativeNumbers = new StringBuilder();
        boolean negativeFlag = false;
        int result = 0;
        String delimiter = "";

        if (numbers.equals(""))
            return 0;

        if(numbers.length() > 2 && numbers.substring(0,2).equals("//")){
            delimiter = numbers.substring(2, numbers.indexOf("\n"));
            numbers = numbers.substring(3 + delimiter.length() ,numbers.length());

            if(delimiter.charAt(0) == '['){
                Matcher matcher = exprBetweenBracket.matcher(delimiter);
                while(matcher.find()) {
                    delimiters.add(matcher.group(1));
                }
            }

            for(String delimit: delimiters){
                numbers = numbers.replace(delimit, ",");
            }
            numbers = numbers.replace(delimiter, ",");
        }

        String delimiterRegex = "[ ,|\\n|" + delimiter + "]";
        String[] numbersArray = numbers.split(delimiterRegex);

        int actualNumber;
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
