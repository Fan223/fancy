package grey.fable.blog.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import grey.fable.base.net.Response;
import grey.fable.blog.pojo.dto.ArticleDTO;
import grey.fable.blog.pojo.entity.ArticleDO;
import grey.fable.blog.pojo.query.ArticleQuery;
import grey.fable.blog.pojo.vo.ArticleVO;
import grey.fable.blog.service.ArticleService;
import grey.fable.blog.util.MapStructUtils;
import org.springframework.web.bind.annotation.*;

/**
 * 文章控制器.
 *
 * @author GreyFable
 * @since 2024/11/25 15:44
 */
@RestController
public class ArticleController {

    private final MapStructUtils mapStructUtils;
    private final ArticleService articleService;

    public ArticleController(MapStructUtils mapStructUtils, ArticleService articleService) {
        this.mapStructUtils = mapStructUtils;
        this.articleService = articleService;
    }

    @GetMapping("/articles")
    public Response<Page<ArticleVO>> pageArticles(ArticleQuery articleQuery) {
        Page<ArticleDO> page = articleService.pageArticles(articleQuery);
        return Response.success(mapStructUtils.convertArticles(page));
    }

    @GetMapping("/articles/{id}")
    public Response<ArticleVO> getArticle(@PathVariable("id") String id) {
        ArticleDO articleDO = articleService.getArticle(id);
        return Response.success(mapStructUtils.convertArticles(articleDO));
    }

    @PostMapping("/articles")
    public Response<Boolean> saveArticle(@RequestBody ArticleDTO articleDTO) {
        ArticleDO articleDO = mapStructUtils.convertArticles(articleDTO);
        return Response.success(articleService.saveArticle(articleDO));
    }

    @DeleteMapping("/articles/{id}")
    public Response<Integer> deleteArticle(@PathVariable("id") String id) {
        return Response.success(articleService.deleteArticle(id));
    }
}
