package grey.fable.blog.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import grey.fable.common.mybatis.plus.pojo.entity.MetaDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 文章实体类.
 *
 * @author GreyFable
 * @since 2025/3/6 8:52
 */
@Data
@TableName("article")
@EqualsAndHashCode(callSuper = true)
public class ArticleDO extends MetaDO {

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
    private Integer view;

    /**
     * 状态.
     */
    private Integer state;
}
