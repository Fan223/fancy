package grey.fable.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import grey.fable.base.map.MapUtils;
import grey.fable.base.text.StringUtils;
import grey.fable.blog.dao.ArticleDAO;
import grey.fable.blog.pojo.entity.ArticleDO;
import grey.fable.blog.pojo.query.ArticleQuery;
import grey.fable.blog.service.ArticleService;
import grey.fable.common.redis.support.RedisClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * 文章接口实现类.
 *
 * @author GreyFable
 * @since 2025/3/6 8:51
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    private static final String ARTICLE_VIEWS_KEY = "article:view";

    private final ArticleDAO articleDAO;

    private final RedisClient redisClient;

    public ArticleServiceImpl(ArticleDAO articleDAO, RedisClient redisClient) {
        this.articleDAO = articleDAO;
        this.redisClient = redisClient;
    }

    @Override
    public Page<ArticleDO> pageArticles(ArticleQuery query) {
        LambdaQueryWrapper<ArticleDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(query.getState()), ArticleDO::getState, query.getState())
                .like(StringUtils.isNotBlank(query.getTitle()), ArticleDO::getTitle, query.getTitle());
        return articleDAO.selectPage(new Page<>(query.getCurrentPage(), query.getPageSize()), wrapper);
    }

    @Override
    public ArticleDO getArticle(String id) {
        return articleDAO.selectById(id);
    }

    @Override
    public void incrementView(String id) {
        CompletableFuture.runAsync(() -> redisClient.hIncrement(ARTICLE_VIEWS_KEY, id, 1));
    }

    @Scheduled(cron = "0 0 4 * * ?")
    public void syncView() {
        Map<Object, Object> map = redisClient.hEntries(ARTICLE_VIEWS_KEY);
        if (MapUtils.isNotEmpty(map)) {
            for (Map.Entry<Object, Object> entry : map.entrySet()) {
                long id = Long.parseLong(entry.getKey().toString());
                int view = Integer.parseInt(entry.getValue().toString());
                updateView(id, view);
            }
            redisClient.delete(ARTICLE_VIEWS_KEY);
        }
    }

    private void updateView(long id, int view) {
        LambdaUpdateWrapper<ArticleDO> wrapper = new LambdaUpdateWrapper<>();
        wrapper.setSql("view = view + {0}", view).eq(ArticleDO::getId, id);
        articleDAO.update(null, wrapper);
    }

    @Override
    public Boolean saveArticle(ArticleDO articleDO) {
        return articleDAO.insertOrUpdate(articleDO);
    }

    @Override
    public Integer deleteArticle(String id) {
        return articleDAO.deleteById(id);
    }
}
