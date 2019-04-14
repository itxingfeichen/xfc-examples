package com.github.xfc.factory.simple;

import com.github.xfc.factory.common.*;

/**
 * @author : chenxingfei
 * @date: 2019-04-14  13:12
 * @description: 简单工厂模式
 * </p>
 * 简单工厂模式说明
 *  1：耦合多较高，下次新增算法如增加一个平方计算，还需要修改简单共产类
 *  2：违背开-闭原则
 *  开闭原则定义：开闭原则，对于扩展是开放的，对于修改是关闭
 */
public class SimpleFactory {

    public static Operate getOperate(OperateEnum operateType) {
        if (operateType == null) {
            throw new IllegalArgumentException("参数非法");
        }
        switch (operateType) {
            case ADD:
                return new AddOperate();
            case DIVIDE:
                return new DivideOperate();
            case MUTIPLY:
                return new MulOperate();
            case SUBTRUT:
                return new SubOperate();
            default:
                throw new IllegalArgumentException("参数非法");
        }

    }

}
