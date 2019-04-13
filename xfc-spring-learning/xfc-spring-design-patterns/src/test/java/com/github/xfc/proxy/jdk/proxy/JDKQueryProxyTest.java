package com.github.xfc.proxy.jdk.proxy;

import com.github.xfc.proxy.jdk.model.User;
import com.github.xfc.proxy.jdk.service.IJDKQueryService;
import com.github.xfc.proxy.jdk.service.JDKQueryServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Proxy;

import static org.junit.Assert.*;

/**
 * @author : chenxingfei
 * @date: 2019-04-13  14:39
 * @description:
 */
public class JDKQueryProxyTest {

    @Test
    public void testProxy() {
        IJDKQueryService ijdkQueryService = new JDKQueryServiceImpl();
        JDKQueryProxy jdkQueryProxy = new JDKQueryProxy(ijdkQueryService);
        IJDKQueryService proxy = (IJDKQueryService) jdkQueryProxy.getProxy();

        User user = proxy.findUser(1L);
        System.out.println("hashcode"+user.hashCode());
        Assert.assertNotNull(user);
    }
}