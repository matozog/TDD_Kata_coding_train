package calculator;

public class StringCalculator {

    public int Add(String numbers) {
        if (numbers.equals(""))
            return 0;

        String delimiter = "";

        if(numbers.length() > 2 && numbers.substring(0,2).equals("//")){
            delimiter = numbers.substring(2, numbers.indexOf("\n"));
            numbers = numbers.substring(3 + delimiter.length() ,numbers.length());
        }

        String delimiterRegex = "[ , | \\n | " + delimiter + "]";
        String[] numbersArray = numbers.split(delimiterRegex);
        int result = 0;
        for (String number : numbersArray) {
            result += Integer.parseInt(number);
        }

        return result;
    }

}
