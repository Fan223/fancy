package grey.fable.blog.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import grey.fable.common.mybatis.plus.entity.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 文章实体类.
 *
 * @author GreyFable
 * @since 2024/11/25 15:48
 */
@Data
@TableName("article")
@EqualsAndHashCode(callSuper = true)
public class ArticleDO extends BaseDO {

    /**
     * 标题.
     */
    private String title;

    /**
     * 内容.
     */
    private String content;

    /**
     * 封面.
     */
    private String cover;

    /**
     * 状态.
     */
    private Integer state;
}
