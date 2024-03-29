package com.aixuexi.sharding.service;


import com.aixuexi.sharding.mapper.InteractQuestionAnswerMapper;
import com.aixuexi.sharding.model.InteractQuestionAnswer;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 互动问题答案表(InteractQuestionAnswer)表服务实现类
 *
 * @author xf.chen
 * @since 2020-04-16 17:04:47
 */
@RequiredArgsConstructor
@Service("interactQuestionAnswerService")
public class InteractQuestionAnswerServiceImpl extends ServiceImpl<InteractQuestionAnswerMapper, InteractQuestionAnswer> implements InteractQuestionAnswerService {



}