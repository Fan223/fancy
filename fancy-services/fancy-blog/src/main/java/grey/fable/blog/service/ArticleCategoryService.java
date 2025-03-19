package grey.fable.blog.service;

import java.util.List;
import java.util.Map;

/**
 * 文章分类关联接口.
 *
 * @author GreyFable
 * @since 2025/3/7 16:57
 */
public interface ArticleCategoryService {

    Map<String, List<Long>> listArticleIds();

    List<Long> listArticleIds(String categoryId);

    void addArticleCategory(String categoryId, List<String> ids);
}
