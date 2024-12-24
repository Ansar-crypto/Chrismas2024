package com.actitimeautomation.TestClasses;

import org.testng.annotations.*;

public class TestAnnotations {
    {
        System.out.println("This is non static block");
    }
    public TestAnnotations()
    {
        System.out.println("This is constructor of TestNGAnnotation");
    }
    @BeforeClass
            public void beforeClass()
    {
        System.out.println("This is before class");
    }
    @AfterClass
    public void afterClass()
    {
        System.out.println("This is After class");
    }
    @BeforeMethod
    public void beforeMethod()
    {
        System.out.println("This is before method");
    }
    @AfterMethod
    public void afterMethod()
    {
        System.out.println("This is after method");
    }
    @Test
    public void test1()
    {
        System.out.println("This is test 1");
    }
    @Test
    public void test2()
    {
        System.out.println("This is test 2");
    }
    @Test
    public void test3()
    {
        System.out.println("This is test 3");
    }
}
