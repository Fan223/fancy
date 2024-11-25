package grey.fable.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import grey.fable.blog.dao.ArticleDAO;
import grey.fable.blog.pojo.entity.ArticleDO;
import grey.fable.blog.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文章接口实现类.
 *
 * @author powersi
 * @since 2024/11/25 15:48
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleDAO articleDAO;

    public ArticleServiceImpl(ArticleDAO articleDAO) {
        this.articleDAO = articleDAO;
    }

    @Override
    public List<ArticleDO> listArticles() {
        return articleDAO.selectList(new QueryWrapper<>());
    }
}
