package grey.fable.blog.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import grey.fable.base.net.Response;
import grey.fable.blog.converter.BlogConverter;
import grey.fable.blog.pojo.dto.CategoryDTO;
import grey.fable.blog.pojo.entity.CategoryDO;
import grey.fable.blog.pojo.query.CategoryQuery;
import grey.fable.blog.pojo.vo.CategoryVO;
import grey.fable.blog.service.ArticleCategoryService;
import grey.fable.blog.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 分类控制器.
 *
 * @author GreyFable
 * @since 2025/3/7 15:52
 */
@RestController
public class CategoryController {

    private final CategoryService categoryService;

    private final ArticleCategoryService articleCategoryService;

    private final BlogConverter blogConverter;

    public CategoryController(CategoryService categoryService, ArticleCategoryService articleCategoryService, BlogConverter blogConverter) {
        this.categoryService = categoryService;
        this.articleCategoryService = articleCategoryService;
        this.blogConverter = blogConverter;
    }

    @GetMapping("/categories/page")
    public Response<Page<CategoryVO>> pageCategories(CategoryQuery categoryQuery) {
        Page<CategoryDO> page = categoryService.pageCategories(categoryQuery);
        return Response.success(blogConverter.convertCategories(page));
    }

    @GetMapping("/categories/list")
    public Response<List<CategoryVO>> listCategories() {
        List<CategoryDO> categoryDos = categoryService.listCategories();
        List<CategoryVO> categoryVos = blogConverter.convertCategories(categoryDos);

        Map<String, List<Long>> map = articleCategoryService.listArticleIds();
        for (CategoryVO categoryVo : categoryVos) {
            List<Long> articleIds = Optional.ofNullable(map.get(categoryVo.getId())).orElse(Collections.emptyList());
            categoryVo.setCount(articleIds.size());
        }
        return Response.success(categoryVos);
    }

    @PostMapping("/categories")
    public Response<Integer> addCategory(@RequestBody CategoryDTO categoryDTO) {
        CategoryDO categoryDO = blogConverter.convertCategories(categoryDTO);
        return Response.success(categoryService.addCategory(categoryDO));
    }

    @PutMapping("/categories")
    public Response<Integer> updateCategory(@RequestBody CategoryDTO categoryDTO) {
        CategoryDO categoryDO = blogConverter.convertCategories(categoryDTO);
        return Response.success(categoryService.updateCategory(categoryDO));
    }

    @DeleteMapping("/categories/{id}")
    public Response<Integer> deleteCategory(@PathVariable("id") String id) {
        return Response.success(categoryService.deleteCategory(id));
    }
}
