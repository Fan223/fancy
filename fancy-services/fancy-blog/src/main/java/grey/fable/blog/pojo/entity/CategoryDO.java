package grey.fable.blog.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import grey.fable.common.mybatis.plus.pojo.entity.MetaDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 分类实体类.
 *
 * @author GreyFable
 * @since 2025/3/7 15:10
 */
@Data
@TableName("category")
@EqualsAndHashCode(callSuper = true)
public class CategoryDO extends MetaDO {

    /**
     * 名称.
     */
    private String name;

    /**
     * 排序.
     */
    private Integer sort;

    /**
     * 状态.
     */
    private Integer state;
}
