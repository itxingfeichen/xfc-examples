package com.github.xfc.mapper;

import com.github.xfc.base.Member;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author : chenxingfei
 * @date: 2019-04-27  20:31
 * @description: 会员mapper
 */
public interface MemberMapper {


    @Select({"select  * from t_member where id=#{id}"})
    Member getMember(Long id);
}
