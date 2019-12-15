package com.xfc.structure.statck.demo;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorFromStackTest {

    @Test
    public void testCalculate() {
        CalculatorFromStack calculatorFromStack = new CalculatorFromStack();
        System.out.println(calculatorFromStack.calculate("2+2*3-2*1-1"));// 2 2 3 * + 2 1 * - 1 -
    }

}