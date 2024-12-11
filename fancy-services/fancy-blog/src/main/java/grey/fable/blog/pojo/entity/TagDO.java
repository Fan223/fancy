package grey.fable.blog.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import grey.fable.common.mybatis.plus.entity.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 标签实体类.
 *
 * @author GreyFable
 * @since 2024/11/28 11:21
 */
@Data
@TableName("tag")
@EqualsAndHashCode(callSuper = true)
public class TagDO extends BaseDO {

    /**
     * 名称.
     */
    private String name;
}
