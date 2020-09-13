package com.xfc.hutool;

import cn.hutool.core.util.IdcardUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xf.chen
 * @date 2020/8/17 18:25
 * @since 1.2.0
 */
public class IdCardUtilTest {

    public static void main(String[] args) {
        String cardNum = "522125199210291932";
        System.out.println("getBirth = " + IdcardUtil.getBirth(cardNum));
        System.out.println("getAgeByIdCard = " + IdcardUtil.getAgeByIdCard(cardNum));
    }
}
