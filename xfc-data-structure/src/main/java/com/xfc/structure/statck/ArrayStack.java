package com.xfc.structure.statck;

/**
 * 数据模拟栈
 *
 * @author jannik
 * @version v1.0.0
 * @date 2019-12-14 09:11
 */
public class ArrayStack implements Stack {

    /**
     * 存储数据的容器
     */
    private int[] stack;

    /**
     * 栈顶元素指针，如果为-1代表栈为空
     */
    private int top = -1;

    /**
     * 栈深度
     */
    private int maxSize;

    public ArrayStack(int maxSize) {
        // 初始化栈大小
        this.stack = new int[maxSize];
        this.maxSize = maxSize;
    }

    /**
     * 是否栈满
     *
     * @return
     */
    public boolean isFull() {
        return stack.length - 1 == maxSize;
    }

    /**
     * 是否栈空
     *
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 压栈
     *
     * @param value
     */
    public void push(int value) {
        if (isFull()) {
            throw new RuntimeException("栈已满");
        }
        top++;
        this.stack[top] = value;
    }

    /**
     * 出栈
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        int value = this.stack[top];
        this.stack[top] = 0;
        top--;
        return value;
    }

    /**
     * 遍历
     */
    public void list() {
        if(isEmpty()){
            throw new RuntimeException("栈为空");
        }
        for (int i = top; i != -1; i--) {
            System.out.println(this.stack[i]);
        }
    }

    /**
     * 查看栈顶元素
     *
     * @return
     */
    @Override
    public int peek() {
        return this.stack[top];
    }
}
