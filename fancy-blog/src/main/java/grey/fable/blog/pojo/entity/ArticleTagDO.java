package grey.fable.blog.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 文章标签关联实体类.
 *
 * @author GreyFable
 * @since 2024/11/29 0:45
 */
@Data
@TableName("article_tag")
public class ArticleTagDO {

    /**
     * 主键ID.
     */
    @TableId
    private Long id;

    /**
     * 文章ID.
     */
    private Long articleId;

    /**
     * 标签ID.
     */
    private Long tagId;

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
