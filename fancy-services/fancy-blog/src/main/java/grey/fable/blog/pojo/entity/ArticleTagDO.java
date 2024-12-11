package grey.fable.blog.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import grey.fable.common.mybatis.plus.entity.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 文章标签关联实体类.
 *
 * @author GreyFable
 * @since 2024/11/29 0:45
 */
@Data
@TableName("article_tag")
@EqualsAndHashCode(callSuper = true)
public class ArticleTagDO extends BaseDO {

    /**
     * 文章ID.
     */
    private Long articleId;

    /**
     * 标签ID.
     */
    private Long tagId;
}
