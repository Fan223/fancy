package grey.fable.blog.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import grey.fable.base.net.Response;
import grey.fable.base.text.StringUtils;
import grey.fable.blog.converter.BlogConverter;
import grey.fable.blog.pojo.dto.ArticleDTO;
import grey.fable.blog.pojo.entity.ArticleDO;
import grey.fable.blog.pojo.query.ArticleQuery;
import grey.fable.blog.pojo.vo.ArticleVO;
import grey.fable.blog.service.ArticleCategoryService;
import grey.fable.blog.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文章控制器.
 *
 * @author GreyFable
 * @since 2025/3/6 8:50
 */
@RestController
public class ArticleController {

    private final ArticleService articleService;

    private final ArticleCategoryService articleCategoryService;

    private final BlogConverter blogConverter;

    public ArticleController(ArticleService articleService, ArticleCategoryService articleCategoryService, BlogConverter blogConverter) {
        this.articleService = articleService;
        this.articleCategoryService = articleCategoryService;
        this.blogConverter = blogConverter;
    }

    @GetMapping("/articles")
    public Response<Page<ArticleVO>> pageArticles(ArticleQuery articleQuery) {
        if (StringUtils.isNotBlank(articleQuery.getCategoryId())) {
            List<Long> longs = articleCategoryService.listArticleIds(articleQuery.getCategoryId());
            articleQuery.setIds(longs);
        }

        Page<ArticleDO> page = articleService.pageArticles(articleQuery);
        return Response.success(blogConverter.convertArticles(page));
    }

    @GetMapping("/articles/recommend")
    public Response<List<ArticleVO>> listRecommendArticles() {
        return Response.success(blogConverter.convertArticles(articleService.listRecommendArticles()));
    }

    @GetMapping("/articles/{id}")
    public Response<ArticleVO> getArticle(@PathVariable("id") String id) {
        ArticleDO articleDO = articleService.getArticle(id);
        // 增加浏览量
        articleService.incrementView(id);
        return Response.success(blogConverter.convertArticles(articleDO));
    }

    @PostMapping("/articles")
    public Response<Boolean> saveArticle(@RequestBody ArticleDTO articleDTO) {
        ArticleDO articleDO = blogConverter.convertArticles(articleDTO);
        return Response.success(articleService.saveArticle(articleDO));
    }

    @DeleteMapping("/articles/{id}")
    public Response<Integer> deleteArticle(@PathVariable("id") String id) {
        return Response.success(articleService.deleteArticle(id));
    }
}
