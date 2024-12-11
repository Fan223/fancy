package grey.fable.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import grey.fable.base.text.StringUtils;
import grey.fable.base.util.IdUtils;
import grey.fable.blog.dao.ArticleDAO;
import grey.fable.blog.pojo.entity.ArticleDO;
import grey.fable.blog.pojo.query.ArticleQuery;
import grey.fable.blog.service.ArticleService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * 文章接口实现类.
 *
 * @author GreyFable
 * @since 2024/11/25 15:48
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleDAO articleDAO;

    public ArticleServiceImpl(ArticleDAO articleDAO) {
        this.articleDAO = articleDAO;
    }

    @Override
    public Page<ArticleDO> pageArticles(ArticleQuery articleQuery) {
        LambdaQueryWrapper<ArticleDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StringUtils.isNotBlank(articleQuery.getState()), ArticleDO::getState, articleQuery.getState())
                .like(StringUtils.isNotBlank(articleQuery.getTitle()), ArticleDO::getTitle, articleQuery.getTitle());
        return articleDAO.selectPage(new Page<>(articleQuery.getCurrentPage(), articleQuery.getPageSize()), queryWrapper);
    }

    @Override
    public ArticleDO getArticle(String id) {
        return articleDAO.selectById(id);
    }

    @Override
    public Boolean saveArticle(ArticleDO articleDO) {
        LocalDateTime now = LocalDateTime.now();
        articleDO.setUpdateTime(now);

        Optional<Long> id = Optional.ofNullable(articleDO.getId());
        id.ifPresentOrElse(aLong -> {
        }, () -> {
            articleDO.setId(IdUtils.getSnowflakeNextId());
            articleDO.setCreateTime(now);
        });

        Optional<String> cover = Optional.ofNullable(articleDO.getCover());
        articleDO.setCover(cover.orElse("https://img.fan223.cn/wallpaper/12.jpg"));
        return articleDAO.insertOrUpdate(articleDO);
    }

    @Override
    public int deleteArticle(String id) {
        return articleDAO.deleteById(id);
    }
}
