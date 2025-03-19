package grey.fable.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import grey.fable.blog.dao.ArticleCategoryDAO;
import grey.fable.blog.pojo.entity.ArticleCategoryDO;
import grey.fable.blog.service.ArticleCategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 文章分类关联接口实现类.
 *
 * @author GreyFable
 * @since 2025/3/7 16:58
 */
@Service
public class ArticleCategoryServiceImpl implements ArticleCategoryService {

    private final ArticleCategoryDAO articleCategoryDAO;

    public ArticleCategoryServiceImpl(ArticleCategoryDAO articleCategoryDAO) {
        this.articleCategoryDAO = articleCategoryDAO;
    }

    @Override
    public Map<String, List<Long>> listArticleIds() {
        List<ArticleCategoryDO> articleCategoryDos = articleCategoryDAO.selectList(new LambdaQueryWrapper<>());
        return articleCategoryDos.stream().collect(
                Collectors.groupingBy(articleCategoryDO -> articleCategoryDO.getCategoryId().toString(),
                        Collectors.mapping(ArticleCategoryDO::getArticleId, Collectors.toList())));
    }

    @Override
    public List<Long> listArticleIds(String categoryId) {
        LambdaQueryWrapper<ArticleCategoryDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ArticleCategoryDO::getCategoryId, categoryId);
        return articleCategoryDAO.selectList(wrapper).stream().map(ArticleCategoryDO::getArticleId).toList();
    }

    @Override
    @Transactional
    public void addArticleCategory(String categoryId, List<String> ids) {
        ArrayList<ArticleCategoryDO> articleCategoryDos = new ArrayList<>();
        for (String id : ids) {
            ArticleCategoryDO articleCategoryDO = new ArticleCategoryDO();
            articleCategoryDO.setCategoryId(Long.valueOf(categoryId));
            articleCategoryDO.setArticleId(Long.valueOf(id));
            articleCategoryDos.add(articleCategoryDO);
        }
        // 先删除, 再插入
        deleteArticleCategory(categoryId);
        articleCategoryDAO.insert(articleCategoryDos);
    }

    public void deleteArticleCategory(String categoryId) {
        LambdaUpdateWrapper<ArticleCategoryDO> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(ArticleCategoryDO::getCategoryId, categoryId);
        articleCategoryDAO.delete(wrapper);
    }
}
