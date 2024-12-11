package grey.fable.vocabulary.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import grey.fable.common.mybatis.plus.entity.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 词汇实体类.
 *
 * @author GreyFable
 * @since 2024/11/29 11:03
 */
@Data
@TableName("vocabulary")
@EqualsAndHashCode(callSuper = true)
public class VocabularyDO extends BaseDO {

    /**
     * 单词.
     */
    private String word;

    /**
     * 音标.
     */
    private String phonetic;

    /**
     * 状态.
     */
    private Integer state;
}
