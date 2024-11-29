package grey.fable.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import grey.fable.blog.dao.ArticleCategoryDAO;
import grey.fable.blog.pojo.entity.ArticleCategoryDO;
import grey.fable.blog.service.ArticleCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文章分类关联接口实现类.
 *
 * @author GreyFable
 * @since 2024/11/29 0:49
 */
@Service
public class ArticleCategoryServiceImpl implements ArticleCategoryService {

    private final ArticleCategoryDAO articleCategoryDAO;

    public ArticleCategoryServiceImpl(ArticleCategoryDAO articleCategoryDAO) {
        this.articleCategoryDAO = articleCategoryDAO;
    }

    @Override
    public List<Long> listArticleIds(String categoryId) {
        LambdaQueryWrapper<ArticleCategoryDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ArticleCategoryDO::getCategoryId, categoryId);
        List<ArticleCategoryDO> articleCategoryDos = articleCategoryDAO.selectList(queryWrapper);
        return articleCategoryDos.stream().map(ArticleCategoryDO::getArticleId).toList();
    }
}
