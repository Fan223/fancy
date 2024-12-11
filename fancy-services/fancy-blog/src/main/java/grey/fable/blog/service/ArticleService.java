package grey.fable.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import grey.fable.blog.pojo.entity.ArticleDO;
import grey.fable.blog.pojo.query.ArticleQuery;

/**
 * 文章接口.
 *
 * @author GreyFable
 * @since 2024/11/25 15:44
 */
public interface ArticleService {

    Page<ArticleDO> pageArticles(ArticleQuery articleQuery);

    ArticleDO getArticle(String id);

    Boolean saveArticle(ArticleDO articleDO);

    int deleteArticle(String id);
}
