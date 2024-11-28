package grey.fable.blog.pojo.query;

import grey.fable.common.query.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 分类查询参数.
 *
 * @author GreyFable
 * @since 2024/11/26 16:34
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CategoryQuery extends PageQuery {

    private String name;

    private String state;
}
