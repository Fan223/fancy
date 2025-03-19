package grey.fable.blog.pojo.query;

import grey.fable.common.mybatis.plus.pojo.query.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 分类查询参数.
 *
 * @author GreyFable
 * @since 2025/3/7 15:37
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CategoryQuery extends PageQuery {

    /**
     * 名称.
     */
    private String name;

    /**
     * 状态.
     */
    private String state;
}
