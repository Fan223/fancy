package grey.fable.blog.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import grey.fable.common.mybatis.plus.entity.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 文章分类关联实体类.
 *
 * @author GreyFable
 * @since 2024/11/29 0:34
 */
@Data
@TableName("article_category")
@EqualsAndHashCode(callSuper = true)
public class ArticleCategoryDO extends BaseDO {

    /**
     * 文章ID.
     */
    private Long articleId;

    /**
     * 分类ID.
     */
    private Long categoryId;
}
