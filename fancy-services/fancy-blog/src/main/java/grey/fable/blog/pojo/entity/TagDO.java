package grey.fable.blog.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import grey.fable.common.mybatis.plus.pojo.entity.MetaDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 标签实体类.
 *
 * @author GreyFable
 * @since 2025/3/7 15:15
 */
@Data
@TableName("tag")
@EqualsAndHashCode(callSuper = false)
public class TagDO extends MetaDO {

    /**
     * 名称.
     */
    private String name;
}
