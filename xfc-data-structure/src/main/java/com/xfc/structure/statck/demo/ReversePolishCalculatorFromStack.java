package com.xfc.structure.statck.demo;

import com.xfc.structure.statck.ArrayStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 通过逆波兰表达式完成计算过程
 *
 * @author jannik
 * @date 2019-12-14
 */
public class ReversePolishCalculatorFromStack {


    /**
     * 逆波兰表达式
     *
     * @param expression 中缀表达式 2+2*3-2*1-1 => 2 2 3 * + 2 1 * - 1 -
     * @return 结果
     */
    public int calculate(String expression) {
        List<String> expressions = new ExpressionConverter().converter(expression);
        // 将后缀表达式转换为列表
        ArrayStack stack = new ArrayStack(expressions.size());
        // 遍历表达式列表
        for (String str : expressions) {
            if (isCalculateSymbol(str)) {
                doProcess(str, stack);
            } else {
                stack.push(Integer.valueOf(str));
            }
        }

        return stack.pop();
    }

    /**
     * 校验是否为一个计算表达式
     *
     * @param symbol
     * @return
     */
    private boolean isCalculateSymbol(String symbol) {

        return Objects.equals("+", symbol) ||
                Objects.equals("-", symbol) ||
                Objects.equals("*", symbol) ||
                Objects.equals("/", symbol);
    }

    /**
     * 根据表达式弹出两个顶元素进行计算
     *
     * @param symbol
     */
    private void doProcess(String symbol, ArrayStack stack) {
        // 弹出需要计算的元素
        int res1 = stack.pop();
        int res2 = stack.pop();
        switch (symbol) {
            case "+":
                stack.push(res2 + res1);
                break;
            case "-":
                stack.push(res2 - res1);
                break;
            case "*":
                stack.push(res2 * res1);
                break;
            case "/":
                stack.push(res2 / res1);
                break;
            default:
                throw new RuntimeException("计算符号异常");

        }
    }

    /**
     * 内部转换器（需要将中缀表达式转换为后缀表达式）
     */
    private static class ExpressionConverter {

        /**
         * 转换操作
         *
         * @param expression 中缀表达式
         * @return 后缀表达式
         */
        private List<String> converter(String expression) {
            List<String> middleExpress = Arrays.asList(expression.split(" "));
            List<String> numberStack = new ArrayList<>(middleExpress.size());

            ArrayStack symbolStack = new ArrayStack(middleExpress.size());
            for (String express : middleExpress) {
                // 如果是数字，直接压入操作数栈
                if (express.matches("\\d+")) {
                    numberStack.add(express);
                } else if (Objects.equals("(", express)) {
                    symbolStack.push(express.charAt(0));
                } else if (Objects.equals(")", express)) {
                    while (symbolStack.peek() != (int) '(') {
                        numberStack.add(symbolStack.pop() + "");
                    }
                    symbolStack.pop();
                } else {
                    // 如果是操作符号
                    while (!symbolStack.isEmpty() && isPriorityOperateSymbol(express.charAt(0)) <= isPriorityOperateSymbol((char) symbolStack.peek())) {
                        numberStack.add((char) symbolStack.pop() + "");
                    }
                    symbolStack.push(express.charAt(0));

                }

            }
            // 添加剩余yuansu
            if (!symbolStack.isEmpty()) {
                numberStack.add((char) symbolStack.pop() + "");
            }

            return numberStack;
        }

        private int isPriorityOperateSymbol(char ch) {
            switch (ch) {
                case '*':
                case '/':
                    return 1;
                case '+':
                case '-':
                    return 0;
                default:
                    return -1;

            }
        }

    }


}
