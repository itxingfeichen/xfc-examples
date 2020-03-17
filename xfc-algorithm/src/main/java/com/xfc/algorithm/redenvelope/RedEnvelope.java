package com.xfc.algorithm.redenvelope;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author：jannik
 * @email: jannik@gmail.com
 * @date: 2020/3/16  9:42
 * @description: 红包算法
 **/
public class RedEnvelope {


    /**
     * 红包拆分
     * @param totalAmount 红包总金额
     * @param totalNumber 红包总数量
     * @return
     */
    public List<Integer> divideRedEnvelope(Integer totalAmount, Integer totalNumber) {

        List<Integer> dividedAmount = new ArrayList<>(totalNumber);

        int restAmount = totalAmount;
        int restNumber = totalNumber;
        Random random = new Random();
        for (int i = 0; i < totalNumber - 1; i++) {
            int currentAmount = random.nextInt((restAmount / restNumber * 2 - 1) + 1);
            restAmount -= currentAmount;
            restNumber -= 1;
            dividedAmount.add(currentAmount);
        }

        return dividedAmount;

    }

}
