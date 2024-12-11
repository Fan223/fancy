package grey.fable.vocabulary.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import grey.fable.common.mybatis.plus.entity.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 翻译实体类.
 *
 * @author GreyFable
 * @since 2024/11/29 13:43
 */
@Data
@TableName("translation")
@EqualsAndHashCode(callSuper = true)
public class TranslationDO extends BaseDO {

    /**
     * 单词ID.
     */
    private Long wordId;

    /**
     * 词性.
     */
    private String pos;

    /**
     * 翻译.
     */
    private String translation;
}
