package grey.fable.blog.controller;

import grey.fable.blog.pojo.entity.ArticleDO;
import grey.fable.blog.service.ArticleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 文章控制器.
 *
 * @author powersi
 * @since 2024/11/25 15:44
 */
@RestController
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/articles")
    public List<ArticleDO> getArticles() {
        return articleService.listArticles();
    }
}
