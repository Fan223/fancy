package grey.fable.vocabulary.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 词汇实体类.
 *
 * @author GreyFable
 * @since 2024/11/29 11:03
 */
@Data
@TableName("vocabulary")
public class VocabularyDO {

    /**
     * 词汇ID.
     */
    @TableId
    private Long id;

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
