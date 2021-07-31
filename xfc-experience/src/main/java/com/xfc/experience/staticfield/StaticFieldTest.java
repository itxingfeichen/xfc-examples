package com.xfc.experience.staticfield;

import com.alibaba.fastjson.JSON;
import com.xfc.experience.model.User;

/**
 * 静态字段序列化测试
 *
 * @author xf.chen
 * @date 2021/7/31 7:47 上午
 * @since 1.0.0
 */
public class StaticFieldTest {

    public static void main(String[] args) {
        final User user = new User(1, "xingfei.chen");

        // 序列化
        final String json = JSON.toJSONString(user);
        System.out.println(json);

        // 反序列化
        System.out.println(JSON.parseObject(json, User.class));
    }
}
