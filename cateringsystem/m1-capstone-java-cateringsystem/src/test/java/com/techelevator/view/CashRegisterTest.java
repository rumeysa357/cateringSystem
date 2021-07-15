package com.techelevator.view;

import org.junit.*;

import static org.junit.Assert.*;

public class CashRegisterTest {

    private CashRegister cashs;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before Class...");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After Class...");
    }

    @Before
    public void setUp() {
        cashs = new CashRegister();
        System.out.println("Before...");
    }




    @Test
    public void withdrawMoney() {
        Assert.assertEquals(500,cashs.withdrawMoney(500));
    }

    @Test
    public void log() {
    }

    @Test
    public void getChangeBills() {
    }

    @Test
    public void stringBalance() {
    }
}