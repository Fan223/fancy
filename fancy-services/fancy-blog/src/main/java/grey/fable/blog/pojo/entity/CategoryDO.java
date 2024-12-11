package grey.fable.blog.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import grey.fable.common.mybatis.plus.entity.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 分类实体类.
 *
 * @author GreyFable
 * @since 2024/11/26 16:30
 */
@Data
@TableName("category")
@EqualsAndHashCode(callSuper = true)
public class CategoryDO extends BaseDO {

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
}
