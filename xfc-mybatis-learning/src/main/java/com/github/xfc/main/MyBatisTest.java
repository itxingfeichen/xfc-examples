package com.github.xfc.main;

import com.github.xfc.base.Member;
import com.github.xfc.mapper.MemberMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
import java.util.List;

/**
 * @author : chenxingfei
 * @date: 2019-04-27  20:09
 * @description:
 */
public class MyBatisTest {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        Object o = sqlSession.selectOne("com.github.xfc.mapper.MemberMapper.getMember");
        MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
        Member member = mapper.getMember(1L);
        System.out.println(member);

        sqlSession.close();

    }
}
