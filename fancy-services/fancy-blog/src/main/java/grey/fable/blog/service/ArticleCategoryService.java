package grey.fable.blog.service;

import java.util.List;

/**
 * 文章分类关联接口.
 *
 * @author GreyFable
 * @since 2024/11/29 0:49
 */
public interface ArticleCategoryService {

    List<Long> listArticleIds(String categoryId);
}
