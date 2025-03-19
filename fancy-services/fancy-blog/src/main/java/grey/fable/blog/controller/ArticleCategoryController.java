package grey.fable.blog.controller;

import grey.fable.blog.service.ArticleCategoryService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 文章分类关联控制器.
 *
 * @author GreyFable
 * @since 2025/3/10 14:57
 */
@RestController
public class ArticleCategoryController {

    private final ArticleCategoryService articleCategoryService;

    public ArticleCategoryController(ArticleCategoryService articleCategoryService) {
        this.articleCategoryService = articleCategoryService;
    }

    @PostMapping("/article-category/{categoryId}")
    public void addArticleCategory(@PathVariable("categoryId") String categoryId, @RequestParam("ids") List<String> ids) {
        articleCategoryService.addArticleCategory(categoryId, ids);
    }
}
