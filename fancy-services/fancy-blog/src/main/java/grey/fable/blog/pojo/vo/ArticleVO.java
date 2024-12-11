package grey.fable.blog.pojo.vo;

import lombok.Data;

/**
 * 文章展示类.
 *
 * @author GreyFable
 * @since 2024/11/25 15:53
 */
@Data
public class ArticleVO {

    private String id;

    private String title;

    private String content;

    private String cover;

    private String state;

    private String updateTime;
}
