package grey.fable.blog.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import grey.fable.common.mybatis.plus.pojo.entity.MetaDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 文章分类关联实体类.
 *
 * @author GreyFable
 * @since 2025/3/7 15:15
 */
@Data
@TableName("article_category")
@EqualsAndHashCode(callSuper = true)
public class ArticleCategoryDO extends MetaDO {

    /**
     * 文章ID.
     */
    private Long articleId;

    /**
     * 分类ID.
     */
    private Long categoryId;
}
