package grey.fable.blog.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 分类实体类.
 *
 * @author GreyFable
 * @since 2024/11/26 16:30
 */
@Data
@TableName("category")
public class CategoryDO {

    @TableId
    private Long id;

    private String name;

    private Integer sortOrder;

    private Integer state;

    @TableLogic
    @TableField("is_deleted")
    private Integer deleted;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
