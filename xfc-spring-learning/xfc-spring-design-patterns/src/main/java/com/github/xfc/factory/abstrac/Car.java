package com.github.xfc.factory.abstrac;

import com.github.xfc.factory.common.CarEngine;
import com.github.xfc.factory.common.Tire;
import lombok.Data;

/**
 * @author : chenxingfei
 * @date: 2019-04-14  15:06
 * @description: 车实现类
 */
@Data
public class Car {

    private Tire tire;

    private CarEngine carEngine;

}
