package grey.fable.vocabulary.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 翻译实体类.
 *
 * @author GreyFable
 * @since 2024/11/29 13:43
 */
@Data
@TableName("translation")
public class TranslationDO {

    /**
     * 翻译ID.
     */
    @TableId
    private Long id;

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
