package TestNG;

import org.testng.annotations.Test;

public class TestNGIntro {
    @Test(priority = 3,invocationCount = 5)//Kind of main method
    public void test1(){
        System.out.println("This is test 1");
    }
    @Test
    public void test2(){
        System.out.println("This is test2");
    }
    @Test
    public void test3(){
        System.out.println("this is test3");
    }
}
