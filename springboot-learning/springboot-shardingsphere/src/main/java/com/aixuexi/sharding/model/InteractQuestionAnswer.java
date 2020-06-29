package com.aixuexi.sharding.model;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

/**
 * 互动问题答案表(InteractQuestionAnswer)表实体类
 *
 * @author xf.chen
 * @since 2020-04-18 15:35:55
 */
@Data
@SuppressWarnings("serial")
public class InteractQuestionAnswer extends Model<InteractQuestionAnswer> {

    /**
     * 主键
     */
    private Long id;

    /**
     * 课程id
     */
    private Long courseId;

    /**
     * 讲次id
     */
    private Long lessonId;

    /**
     * diy讲次id
     */
    private Long diyLessonId;

    /**
     * 题目id
     */
    private Long questionId;

    /**
     * 班级id
     */
    private Long classId;

    /**
     * 老师id
     */
    private Long teacherId;

    /**
     * 学生id
     */
    private Long studentId;

    /**
     * 爱校管学生id
     */
    private Long axgStudentId;

    /**
     * 互动问题表id
     */
    private Long interactId;

    /**
     * 互动题目类型
     */
    private Integer interactQuestionType;

    /**
     * 答案
     */
    private String answer;

    /**
     * 辅导老师名称
     */
    private String tutorName;

    /**
     * 学生名称
     */
    private String studentName;

    /**
     * 班级名称
     */
    private String className;

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 讲次名称
     */
    private String lessonName;

    /**
     * 主讲老师名称
     */
    private String teacherName;

    /**
     * 是否正确（1：正确，0：错误）
     */
    private Boolean correctStatus;

    /**
     * 是否有效（1：有效，0：无效）
     */
    private Object effectiveStatus;

    /**
     * 推题记录id (来自教师端)
     */
    private Long logId;

    /**
     * 答题类型(1:直播互动答题，2：回放互动答题)
     */
    private Integer playType;

    /**
     * 互动类型(1:投票互动，2:推题互动，3:红包互动)
     */
    private Integer interactType;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建时间
     */
    private Date createTime;


}