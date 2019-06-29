package tests;

import calculator.StringCalculator;
import org.junit.Assert;
import org.junit.Test;

public class StringCalculatorTest {

    private StringCalculator stringCalculator = new StringCalculator();

    @Test
    public void AddEmptyStringTest(){
        int additionResult = stringCalculator.Add("");
        Assert.assertEquals(0, additionResult );
    }

    @Test
    public void AddOneNumberTest(){
        int additionResult = stringCalculator.Add("1");
        Assert.assertEquals(1, additionResult );
    }

    @Test
    public void AddTwoNumbersTest(){
        int additionResult = stringCalculator.Add("1,2");
        Assert.assertEquals(3, additionResult );
    }

    @Test
    public void AddManyNumbers(){
        int additionResult = stringCalculator.Add("1,2,3,4,5,6");
        Assert.assertEquals(21, additionResult);
    }

}