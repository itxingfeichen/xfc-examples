package com.xfc.structure.statck.demo;


import org.junit.Test;

public class ReversePolishCalculatorFromStackTest {

    @Test
    public void calculate() {

        ReversePolishCalculatorFromStack calculatorFromStack = new ReversePolishCalculatorFromStack();
//        int calculate = calculatorFromStack.calculate("2 2 3 * + 2 1 * - 1 -");
        int calculate = calculatorFromStack.calculate("20 + 2 * 3 - 2 * 1 - 1");
        System.out.println("calculate = " + calculate);

    }
}