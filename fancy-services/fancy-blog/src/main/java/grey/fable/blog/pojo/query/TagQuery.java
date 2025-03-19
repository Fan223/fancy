package grey.fable.blog.pojo.query;

import grey.fable.common.mybatis.plus.pojo.query.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 标签查询参数.
 *
 * @author GreyFable
 * @since 2025/3/7 15:38
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TagQuery extends PageQuery {

    /**
     * 名称.
     */
    private String name;
}
