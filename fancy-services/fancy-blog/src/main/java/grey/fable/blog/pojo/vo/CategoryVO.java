package grey.fable.blog.pojo.vo;

import lombok.Data;

/**
 * 分类展示类.
 *
 * @author GreyFable
 * @since 2025/3/7 15:33
 */
@Data
public class CategoryVO {

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
    private Integer sort;

    /**
     * 状态.
     */
    private Integer state;

    /**
     * 文章数量.
     */
    private Integer count;
}
