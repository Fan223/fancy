package grey.fable.blog.service;

import java.util.List;

/**
 * 文章标签关联接口.
 *
 * @author GreyFable
 * @since 2025/3/7 16:57
 */
public interface ArticleTagService {

    List<Long> listArticleIds(String tagId);
}
