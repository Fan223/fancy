package grey.fable.blog.pojo.query;

import grey.fable.common.mybatis.plus.pojo.query.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 文章查询参数.
 *
 * @author GreyFable
 * @since 2025/3/6 9:41
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ArticleQuery extends PageQuery {

    /**
     * 标题.
     */
    private String title;

    /**
     * 状态.
     */
    private String state;
}
