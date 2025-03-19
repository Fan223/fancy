package grey.fable.blog.pojo.dto;

import lombok.Data;

/**
 * 标签数据传输类.
 *
 * @author GreyFable
 * @since 2025/3/7 15:36
 */
@Data
public class TagDTO {

    /**
     * 标签ID.
     */
    private String id;

    /**
     * 名称.
     */
    private String name;
}
