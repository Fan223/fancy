package grey.fable.blog.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import grey.fable.common.mybatis.plus.pojo.entity.MetaDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 文章标签关联实体类.
 *
 * @author GreyFable
 * @since 2025/3/7 15:25
 */
@Data
@TableName("article_tag")
@EqualsAndHashCode(callSuper = true)
public class ArticleTagDO extends MetaDO {

    /**
     * 文章ID.
     */
    private Long articleId;

    /**
     * 标签ID.
     */
    private Long tagId;
}
