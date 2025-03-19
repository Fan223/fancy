package grey.fable.blog.pojo.dto;

import lombok.Data;

/**
 * 分类数据传输类.
 *
 * @author GreyFable
 * @since 2025/3/7 15:35
 */
@Data
public class CategoryDTO {

    /**
     * 分类ID.
     */
    private String id;

    /**
     * 名称.
     */
    private String name;

    /**
     * 排序.
     */
    private String sort;

    /**
     * 状态.
     */
    private String state;
}
