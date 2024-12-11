package grey.fable.blog.pojo.vo;

import lombok.Data;

/**
 * 分类展示类.
 *
 * @author GreyFable
 * @since 2024/11/26 16:32
 */
@Data
public class CategoryVO {

    private String id;

    private String name;

    private String sortOrder;

    private String state;
}
