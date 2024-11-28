package grey.fable.blog.pojo.dto;

import lombok.Data;

/**
 * 文章传输类.
 *
 * @author GreyFable
 * @since 2024/11/26 16:33
 */
@Data
public class CategoryDTO {

    private String id;

    private String name;

    private String sortOrder;

    private String state;
}
