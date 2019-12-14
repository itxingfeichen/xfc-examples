package com.xfc.structure.statck;

/**
 * 栈接口
 *
 * @author jannik
 * @date 2019-12-14 13:32
 */
public interface Stack {

    /**
     * 是否栈满
     *
     * @return
     */
    boolean isFull();
    /**
     * 是否栈空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 压栈
     *
     * @param value
     */
    void push(int value);

    /**
     * 出栈
     */
    int pop();

    /**
     * 遍历
     */
    void list();

    /**
     * 获取元素个数
     * @return
     */
    default int size(){
        return 0;
    }


}
