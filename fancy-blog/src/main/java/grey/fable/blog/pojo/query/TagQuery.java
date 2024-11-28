package grey.fable.blog.pojo.query;

import grey.fable.common.query.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 标签查询参数.
 *
 * @author GreyFable
 * @since 2024/11/28 14:53
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TagQuery extends PageQuery {

    private String name;
}
