package grey.fable.blog.pojo.query;

import grey.fable.common.query.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 文章查询参数.
 *
 * @author GreyFable
 * @since 2024/11/26 16:12
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ArticleQuery extends PageQuery {

    private String title;

    private String state;
}
