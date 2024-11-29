package grey.fable.blog.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 文章实体类.
 *
 * @author GreyFable
 * @since 2024/11/25 15:48
 */
@Data
@TableName("article")
public class ArticleDO {

    /**
     * 主键ID.
     */
    @TableId
    private Long id;

    /**
     * 标题.
     */
    private String title;

    /**
     * 内容.
     */
    private String content;

    /**
     * 封面.
     */
    private String cover;

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
