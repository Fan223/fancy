package grey.fable.blog.service;

import java.util.List;

/**
 * 文章标签关联接口.
 *
 * @author GreyFable
 * @since 2024/11/29 0:50
 */
public interface ArticleTagService {

    List<Long> ListArticleIds(String tagId);
}
