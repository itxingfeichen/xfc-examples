package com.xfc.structure.statck.demo;

import com.xfc.structure.statck.ArrayStack;

/**
 * 通过栈实现表达式计算器
 * 实现步骤：
 * 1：新建两个栈，一个为操作符号栈，一个为操作数栈
 * 2：压栈规则：
 * ->遍历当前输入的表达式，如果为数字，则压入操作数栈
 * ->如果为操作符号
 * ->需要与当前栈顶的操作符号进行比较优先级，如果当前操作符号优先级高于栈顶优先级。则正常压栈。
 * ->如果低于栈顶操作符号优先级，则需要弹出栈顶操作符号，再弹出操作数栈两个元素进行计算，后将计算结果压入操作数栈，然后将当前低优先级的操作符号压入
 * ->操纵符号栈
 *
 * @author jannik
 * @date 2019-12-14 15:01
 */
public class CalculatorFromStack {

    /**
     * 操作数栈
     */
    private ArrayStack operationNumber = new ArrayStack(15);

    /**
     * 操作符号栈
     */
    private ArrayStack operationSymbol = new ArrayStack(15);

    /**
     * 计算逻辑
     *
     * @param expression
     * @return
     */
    public Integer calculate(String expression) {
        parseExpression(expression);
        // 解析表达式完成，开始进行计算
        while (!operationSymbol.isEmpty()) {
            char symbol = (char) operationSymbol.pop();
            int result = operationNumber.pop();
            int result2 = operationNumber.pop();
            operationNumber.push(getResultBySymbol(result, result2, symbol));
        }
        return operationNumber.pop();
    }

    /**
     * 解析表达式
     *
     * @param expression
     */
    private void parseExpression(String expression) {
        // 处理空格问题
        char[] chars = expression.replaceAll(" ", "").toCharArray();

        for (char ch : chars) {
            if (isOperationSymbol(ch)) {
                if (!operationSymbol.isEmpty()) {
                    if (isPriorityOperateSymbol((char) operationSymbol.peek()) >= isPriorityOperateSymbol(ch)) {
                        int result1 = operationNumber.pop();
                        int result2 = operationNumber.pop();
                        char symbol = (char) operationSymbol.pop();
                        int result = getResultBySymbol(result1, result2, symbol);
                        operationNumber.push(result);
                        operationSymbol.push(ch);
                    } else {
                        operationSymbol.push(ch);
                    }
                } else {
                    operationSymbol.push(ch);
                }
            } else {
                // 数字
                operationNumber.push(ch - 48);

            }
        }

    }

    /**
     * 校验是否为操作符号
     *
     * @param ch
     * @return
     */
    private boolean isOperationSymbol(char ch) {
        switch (ch) {
            case '*':
            case '/':
            case '+':
            case '-':
                return true;
            default:
                return false;
        }
    }

    /**
     * 是否为高优先级操作符号
     *
     * @param ch
     * @return
     */
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


    /**
     * 计算
     *
     * @param result2 栈倒数第二个元素
     * @param result1 栈顶元素
     * @param symbol  操作符号
     * @return result
     */
    private int getResultBySymbol(int result1, int result2, char symbol) {
        switch (symbol) {
            case '*':
                return result2 * result1;
            case '/':
                return result2 / result1;
            case '+':
                return result2 + result1;
            case '-':
                return result2 - result1;
            default:
                return 0;
        }
    }

}
