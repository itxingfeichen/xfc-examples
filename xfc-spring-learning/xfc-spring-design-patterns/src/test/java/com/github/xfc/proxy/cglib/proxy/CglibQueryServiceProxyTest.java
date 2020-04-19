package com.github.xfc.proxy.cglib.proxy;

import com.github.xfc.proxy.cglib.service.CglibQueryServiceImpl;
import com.github.xfc.proxy.cglib.service.ICglibQueryService;
import com.github.xfc.proxy.common.User;
import net.sf.cglib.core.DebuggingClassWriter;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author : chenxingfei
 * @date: 2019-04-13  21:25
 * @description:
 */
public class CglibQueryServiceProxyTest {

    @Test
    public void testCglibProxy() {
        // 将字节码文件写到指定地方
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/chenxingfei");
        CglibQueryServiceProxy cglibQueryServiceProxy = new CglibQueryServiceProxy();
        ICglibQueryService iCglibQueryService = new CglibQueryServiceImpl();
        System.out.println("原始对象hashCode" + iCglibQueryService.hashCode());
        Object proxy = cglibQueryServiceProxy.getProxy(iCglibQueryService);
//        System.out.println("代理对象hashCode"+.hashCode()+" toString"+proxy.toString());
        Boolean flag = false;
        if (proxy instanceof ICglibQueryService) {
            flag = true;
        }
        Assert.assertTrue(flag);
        // 强转proxy为父类对象
        ICglibQueryService proxy1 = (ICglibQueryService) proxy;
        User user = proxy1.findUser(1L);
        System.out.println(user);
    }
}