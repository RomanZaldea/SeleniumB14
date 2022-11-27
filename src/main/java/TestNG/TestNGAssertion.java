package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertion {
    public int multiplication(int num1, int num2){
        return num1*num2;
    }
    @Test
    public void validateMultiplication(){
        int actualResult=multiplication(3,4);
        int expectedResult=12;
        Assert.assertEquals(actualResult, expectedResult);
    }
}
