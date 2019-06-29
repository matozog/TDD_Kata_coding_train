package calculator;

public class StringCalculator {

    public int Add(String numbers) {
        if (numbers.equals(""))
            return 0;

        String[] numbersArray = numbers.split("[, | \\n]");
        int result = 0;
        for (String number : numbersArray) {
            result += Integer.parseInt(number);
        }

        return result;
    }

}
