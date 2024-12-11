package grey.fable.vocabulary.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import grey.fable.common.mybatis.plus.entity.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 词汇主题关联实体类.
 *
 * @author GreyFable
 * @since 2024/11/29 13:46
 */
@Data
@TableName("vocabulary_topic")
@EqualsAndHashCode(callSuper = true)
public class VocabularyTopicDO extends BaseDO {

    /**
     * 单词ID.
     */
    private Long wordId;

    /**
     * 主题ID.
     */
    private String topicId;
}
