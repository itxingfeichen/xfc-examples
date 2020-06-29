package sharding.model;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

/**
 * 互动问题表(InteractQuestion)表实体类
 *
 * @author xf.chen
 * @since 2020-04-16 17:01:44
 */
@Data
public class InteractQuestion extends Model<InteractQuestion> {
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
     * source  题目来源 1:互动题库，2：集团题库，0：其他
     */
    private Integer source;

    /**
     * 互动题目类型(1：选择；2：填空；3：判断)
     */
    private Integer interactQuestionType;

    /**
     * 互动类型(1:投票互动，2:推题互动，3:红包互动)
     */
    private Integer interactType;

    /**
     * 教师类型(1:主讲，2:辅导)
     */
    private Integer teacherType;

    /**
     * 互动类型(1:检测性投票互动，2:开放性投票互动，3:红包互动，4：自定义题目互动)
     */
    private Integer interactSubType;

    /**
     * 正确答案
     */
    private String correctAnswer;
    /**
     * 模板code
     */
    private String templateCode;

    /**
     * 课程名称
     */
    private String courseName;
    /**
     * 讲次名称
     */
    private String lessonName;
    /**
     * 背景图url
     */
    private String backgroundImageUrl;
    /**
     * 素材url
     */
    private String materialUrl;

    /**
     * 创建人
     */
    private String createBy;
    /**
     * 课程开始时间
     */
    private Date lessonStartTime;
    /**
     * 课程结束时间
     */
    private Date lessonEndTime;
    /**
     * 发布状态（0:待发布,1:已发布）
     */
    private Boolean publishStatus;
    /**
     * 删除状态（0:未删除，1：删除）
     */
    private Boolean deleteStatus;
    /**
     * 发布时间
     */
    private Date publishTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 创建时间
     */
    private Date createTime;

}