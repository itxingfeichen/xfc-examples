package sharding;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.common.collect.Lists;
import net.minidev.json.JSONArray;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sharding.mapper.InteractQuestionMapper;
import sharding.model.InteractQuestion;
import sharding.model.InteractQuestionAnswer;
import sharding.service.InteractQuestionAnswerService;

import java.util.ArrayList;
import java.util.List;

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

        Wrapper<InteractQuestionAnswer> wrapper = new LambdaQueryWrapper<>();
        List<InteractQuestionAnswer> answerList = service.list(wrapper);
        System.out.println(answerList.size());
        System.out.println(JSONArray.toJSONString(answerList));

        LambdaQueryWrapper<InteractQuestionAnswer> wrapper1 = new LambdaQueryWrapper<>();
        wrapper1.eq(InteractQuestionAnswer::getCourseId,7L);
        InteractQuestionAnswer questionAnswer1 = service.getOne(wrapper1);

        Assert.assertNotNull("数据为空",questionAnswer1);
        System.out.println(questionAnswer1.toString());

    }



}
