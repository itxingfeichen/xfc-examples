package com.aixuexi.shardingshpere.test;

import com.aixuexi.sharding.ShardingBootstrap;
import com.aixuexi.sharding.mapper.InteractQuestionMapper;
import com.aixuexi.sharding.model.InteractQuestion;
import com.aixuexi.sharding.model.InteractQuestionAnswer;
import com.aixuexi.sharding.service.InteractQuestionAnswerService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

/**
 * 测试类
 *
 * @author xf.chen
 * @date 2020/6/29 13:58
 * @since 1.2.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingBootstrap.class)
public class InteractQuestionAnswerTest {

    @Autowired
    private InteractQuestionAnswerService service;
    @Autowired
    private InteractQuestionMapper questionMapper;

    @Test
    public void addQuestionAnswer() {
        ArrayList<InteractQuestionAnswer> objects = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            InteractQuestionAnswer interactQuestionAnswer = new InteractQuestionAnswer();
            interactQuestionAnswer.setClassName("className" + i);
            interactQuestionAnswer.setCourseId(Long.valueOf(i + ""));
            objects.add(interactQuestionAnswer);
        }
        service.saveBatch(objects);
    }

    @Test
    public void addQuestion() {
        for (int i = 0; i < 10; i++) {
            InteractQuestion question = new InteractQuestion();
            question.setCourseName("courseName" + i);
            question.setCourseId(Long.valueOf(i + ""));
            questionMapper.insert(question);
        }
    }

    @Test
    public void findQuestionAnswer() {

//        Wrapper<InteractQuestionAnswer> wrapper = new LambdaQueryWrapper<>();
//        List<InteractQuestionAnswer> answerList = service.list(wrapper);
//        System.out.println(answerList.size());
//        System.out.println(JSONArray.toJSONString(answerList));
//        InteractQuestionAnswer questionAnswer = service.getById(1277496540409479169L);
        LambdaQueryWrapper<InteractQuestionAnswer> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(InteractQuestionAnswer::getCourseId,2L);
        InteractQuestionAnswer questionAnswer = service.getOne(wrapper);
        System.out.println(questionAnswer.toString());

    }



}
