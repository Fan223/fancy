package grey.fable.blog.pojo.dto;

import lombok.Data;

/**
 * 文章数据传输类.
 *
 * @author GreyFable
 * @since 2025/3/6 8:57
 */
@Data
public class ArticleDTO {

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
    private String view;

    /**
     * 状态.
     */
    private String state;
}
