package grey.fable.vocabulary.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 词汇主题关联实体类.
 *
 * @author GreyFable
 * @since 2024/11/29 13:46
 */
@Data
@TableName("vocabulary_topic")
public class VocabularyTopicDO {

    /**
     * 主键ID.
     */
    @TableId
    private Long id;

    /**
     * 单词ID.
     */
    private Long wordId;

    /**
     * 主题ID.
     */
    private String topicId;

    /**
     * 是否删除标志, 0:未删除, 1:已删除.
     */
    @TableLogic
    @TableField("is_deleted")
    private Integer deleted;

    /**
     * 创建时间.
     */
    private LocalDateTime createTime;

    /**
     * 更新时间.
     */
    private LocalDateTime updateTime;
}
