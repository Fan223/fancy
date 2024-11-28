package grey.fable.blog.pojo.dto;

import lombok.Data;

/**
 * 文章传输类.
 *
 * @author GreyFable
 * @since 2024/11/26 16:04
 */
@Data
public class ArticleDTO {

    private String id;

    private String title;

    private String content;

    private String cover;

    private String state;
}
