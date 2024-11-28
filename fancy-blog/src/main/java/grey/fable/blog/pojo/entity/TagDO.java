package grey.fable.blog.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 标签实体类.
 *
 * @author GreyFable
 * @since 2024/11/28 11:21
 */
@Data
@TableName("tag")
public class TagDO {

    private Long id;

    private String name;

    @TableLogic
    @TableField("is_deleted")
    private Integer deleted;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
