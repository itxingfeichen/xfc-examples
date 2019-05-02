package com.github.xfc.distributed.serializable.deepclone;

import com.github.xfc.distributed.serializable.model.User;

import java.io.*;

/**
 * @author : chenxingfei
 * @date: 2019-05-01  09:38
 * @description: 深度克隆测试
 */
public class DeepClone {

    /**
     * 深度克隆
     *
     * @return
     */
    public User deepClone(User user) throws IOException, ClassNotFoundException {
        // 序列化
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(user);
        // 反序列化
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(outputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        return (User) objectInputStream.readObject();

    }
//
//    /**
//     * 深度克隆
//     *
//     * @return
//     */
//    public User simpleClone(User user) throws IOException, ClassNotFoundException {
//        // 序列化
//        return user.cjsk
//
//    }


}
