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

    private int additionResult;

    @Test
    public void AddEmptyStringTest() throws Exception {
        additionResult = stringCalculator.Add("");
        Assert.assertEquals(0, additionResult );
    }

    @Test
    public void AddOneNumberTest() throws Exception {
        additionResult = stringCalculator.Add("1");
        Assert.assertEquals(1, additionResult );
    }

    @Test
    public void AddTwoNumbersTest() throws Exception {
        additionResult = stringCalculator.Add("1,2");
        Assert.assertEquals(3, additionResult );
    }

    @Test
    public void AddManyNumbersTest() throws Exception {
        additionResult = stringCalculator.Add("1,2,3,4,5,6");
        Assert.assertEquals(21, additionResult);
    }

    @Test
    public void AddNewLinesDelimiterTest() throws Exception {
        additionResult = stringCalculator.Add("1,2\n3,4,5\n6");
        Assert.assertEquals(21, additionResult);
    }

    @Test
    public void AddWithDifferentDelimitersTest() throws Exception {
        additionResult = stringCalculator.Add("//;\n1;2;3;4;5;6");
        Assert.assertEquals(21, additionResult);

        additionResult = stringCalculator.Add("//?\n1?2?3?4?5,6");
        Assert.assertEquals(21, additionResult);
    }

    @Test(expected = Exception.class)
    public void AddWithExceptionOneNegativeNumberTest() throws Exception {
        additionResult = stringCalculator.Add("//;\n1;2;3;4;-5;6");
    }

    @Test
    public void AddWithExceptionManyNegativeNumbersTest() throws Exception {
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("Negative number not allowed -3 -5");
        additionResult = stringCalculator.Add("//;\n1;2;-3;4;-5;6");
    }

    @Test
    public void AddWithNumbersBiggerThan1000Test() throws Exception {
        additionResult = stringCalculator.Add("//;\n1;2;1000;1001;1500;5000");
        Assert.assertEquals(1003, additionResult);
    }

    @Test
    public void AddWithDifferentDelimiterLengthTest() throws Exception{
        additionResult = stringCalculator.Add("//[***]\n1***2***3");
        Assert.assertEquals(6, additionResult);
    }

    @Test
    public void AddWithMultipleDelimitersTest() throws Exception{
        additionResult = stringCalculator.Add("//[*][%]\n1*2%3");
        Assert.assertEquals(6, additionResult);
    }

    @Test
    public void AddWithMultipleDelimitersAndManyCharsTest() throws Exception{
        additionResult = stringCalculator.Add("//[***][%%%]\n1***2%%%3");
        Assert.assertEquals(6, additionResult);
    }

}