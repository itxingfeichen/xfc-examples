package com.xfc.utils;

import com.xfc.basealgorithm.base.ListNode;

/**
 * 算法相关工具类
 *
 * @author xf.chen
 * @date 2021/8/31 06:52
 * @since 1.0.0
 */
public final class AlgorithmUtils {

    /**
     * 打印链表
     */
    public static void printLinkList(ListNode listNode) {
        if (listNode == null) {
            return;
        }
        System.out.print(listNode.val + " ");
        printLinkList(listNode.next);
    }


}
