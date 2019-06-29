package calculator;

public class StringCalculator {

    public int Add(String numbers) throws Exception {
        if (numbers.equals(""))
            return 0;

        String delimiter = "";

        if(numbers.length() > 2 && numbers.substring(0,2).equals("//")){
            delimiter = numbers.substring(2, numbers.indexOf("\n"));
            numbers = numbers.substring(3 + delimiter.length() ,numbers.length());
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
                negativeNumbers.append(" " + number);
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
