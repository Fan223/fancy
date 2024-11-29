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

    /**
     * 主键ID.
     */
    @TableId
    private Long id;

    /**
     * 名称.
     */
    private String name;

    /**
     * 排序.
     */
    private Integer sortOrder;

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
