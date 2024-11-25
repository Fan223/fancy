package grey.fable.blog.service;

import grey.fable.blog.pojo.entity.ArticleDO;

import java.util.List;

/**
 * 文章接口.
 *
 * @author powersi
 * @since 2024/11/25 15:44
 */
public interface ArticleService {

    List<ArticleDO> listArticles();
}
