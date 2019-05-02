package com.github.xfc.distributed.serializable.model;

import org.junit.Ignore;
import org.junit.Test;

import java.io.*;

/**
 * @author : chenxingfei
 * @date: 2019-05-01  08:37
 * @description:
 */
public class UserTest {


    /**
     * 序列化测试
     */
    @Test
    @Ignore
    public void testSerializable() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("user")));
        User user = new User();
        user.setId(1L);
        user.setUsername("test");
        objectOutputStream.writeObject(user);

    }


    @Test
    @Ignore
    public void testDeSerializable() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("user")));
        User user = (User) objectInputStream.readObject();

        System.out.println("user = " + user);
    }

    /**
     * 说明：序列化并不保存静态变量的状态
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Test
    public void testStaticVariable() throws IOException, ClassNotFoundException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("user")));
        User user = new User();
        user.setId(1L);
        user.setUsername("test");
        // age为静态变量
        user.age = 2L;
        objectOutputStream.writeObject(user);
        // 序列化完成，修改静态变量的值
        user.age = 5L;
        System.out.println("user.hashCode() = " + user.hashCode());

        // 反系列化
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("user")));
        User user1 = (User) objectInputStream.readObject();

        System.out.println("user1 = " + user1+" age="+user1.age);
        // user1 = User(id=1, username=test) age=5
        System.out.println("user == user1 = " + (user == user1));
        System.out.println("user1.hashCode() = " + user1.hashCode());


    }
}