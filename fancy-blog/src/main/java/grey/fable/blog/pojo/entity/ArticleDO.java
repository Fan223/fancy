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

    @TableId
    private Long id;

    private String title;

    private String content;

    private String cover;

    private Integer state;

    @TableLogic
    @TableField("is_deleted")
    private Integer deleted;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
