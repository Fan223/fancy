package grey.fable.blog.pojo.vo;

import lombok.Data;

/**
 * 文章展示类.
 *
 * @author GreyFable
 * @since 2025/3/6 8:57
 */
@Data
public class ArticleVO {

    /**
     * 文章ID.
     */
    private String id;

    /**
     * 封面.
     */
    private String cover;

    /**
     * 标题.
     */
    private String title;

    /**
     * 摘要.
     */
    private String digest;

    /**
     * 内容.
     */
    private String content;

    /**
     * 浏览量.
     */
    private Long view;

    /**
     * 状态.
     */
    private Integer state;

    /**
     * 更新时间.
     */
    private String updateTime;
}
