package tests;

import calculator.StringCalculator;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StringCalculatorTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    private StringCalculator stringCalculator = new StringCalculator();

    @Test
    public void AddEmptyStringTest() throws Exception {
        int additionResult = stringCalculator.Add("");
        Assert.assertEquals(0, additionResult );
    }

    @Test
    public void AddOneNumberTest() throws Exception {
        int additionResult = stringCalculator.Add("1");
        Assert.assertEquals(1, additionResult );
    }

    @Test
    public void AddTwoNumbersTest() throws Exception {
        int additionResult = stringCalculator.Add("1,2");
        Assert.assertEquals(3, additionResult );
    }

    @Test
    public void AddManyNumbersTest() throws Exception {
        int additionResult = stringCalculator.Add("1,2,3,4,5,6");
        Assert.assertEquals(21, additionResult);
    }

    @Test
    public void AddNewLinesDelimiterTest() throws Exception {
        int additionResult = stringCalculator.Add("1,2\n3,4,5\n6");
        Assert.assertEquals(21, additionResult);
    }

    @Test
    public void AddWithDifferentDelimitersTest() throws Exception {
        int additionResult = stringCalculator.Add("//;\n1;2;3;4;5;6");
        Assert.assertEquals(21, additionResult);

        additionResult = stringCalculator.Add("//?\n1?2?3?4?5,6");
        Assert.assertEquals(21, additionResult);
    }

    @Test(expected = Exception.class)
    public void AddWithExceptionOneNegativeNumberTest() throws Exception {
        int additionResult = stringCalculator.Add("//;\n1;2;3;4;-5;6");
    }

}