package grey.fable.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import grey.fable.blog.dao.ArticleTagDAO;
import grey.fable.blog.pojo.entity.ArticleTagDO;
import grey.fable.blog.service.ArticleTagService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文章标签关联接口实现类.
 *
 * @author GreyFable
 * @since 2024/11/29 0:50
 */
@Service
public class ArticleTagServiceImpl implements ArticleTagService {

    private final ArticleTagDAO articleTagDAO;

    public ArticleTagServiceImpl(ArticleTagDAO articleTagDAO) {
        this.articleTagDAO = articleTagDAO;
    }

    @Override
    public List<Long> ListArticleIds(String tagId) {
        LambdaQueryWrapper<ArticleTagDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ArticleTagDO::getTagId, tagId);
        List<ArticleTagDO> articleTagDos = articleTagDAO.selectList(queryWrapper);
        return articleTagDos.stream().map(ArticleTagDO::getArticleId).toList();
    }
}
