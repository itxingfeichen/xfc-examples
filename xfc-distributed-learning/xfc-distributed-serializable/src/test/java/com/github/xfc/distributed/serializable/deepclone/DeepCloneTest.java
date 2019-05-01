package com.github.xfc.distributed.serializable.deepclone;

import com.github.xfc.distributed.serializable.model.Teacher;
import com.github.xfc.distributed.serializable.model.User;
import org.junit.Test;

import java.io.IOException;

/**
 * @author : chenxingfei
 * @date: 2019-05-01  09:53
 * @description:
 */
public class DeepCloneTest {

    @Test
    public void deepClone() throws IOException, ClassNotFoundException {
        DeepClone deepClone = new DeepClone();
        User user = new User();
        Teacher teacher = new Teacher();
        teacher.setTeacherAge(100);
        teacher.setTeacherName("姥姥是");
        user.setTeacher(teacher);
        user.setUsername("user name");
        user.setId(11L);
        User user1 = deepClone.deepClone(user);
        System.out.println("user == user1 = " + (user == user1));

        System.out.println("user = " + user);
        // 深度克隆，所有的数据重新复制一份，因此这里会返回false
        System.out.println("user1.getTeacher() == user.getTeacher() = " + (user1.getTeacher() == user.getTeacher()));
        System.out.println("user1 = " + user1);
        System.out.println("user.hashCode() +\" \"+ user1.hashCode() = " + user.hashCode() + " " + user1.hashCode());

    }

    @Test
    public void simpleClone() {
        User user = new User();
        Teacher teacher = new Teacher();
        teacher.setTeacherAge(100);
        teacher.setTeacherName("姥姥是");
        user.setTeacher(teacher);
        user.setUsername("user name");
        user.setId(11L);
        User clone = user.getClone(user);
        System.out.println("clone = " + clone);
        System.out.println("user = " + user);
        // 浅克隆，只是复制简单数据类型和String，对象类型，只会复制引用 ，因此这里返回的一定是true
        System.out.println("clone.getTeacher() == user.getTeacher() = " + (clone.getTeacher() == user.getTeacher()));
        System.out.println(clone == user);

    }
}