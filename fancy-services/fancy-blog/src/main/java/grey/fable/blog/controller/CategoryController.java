package grey.fable.blog.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import grey.fable.base.net.Response;
import grey.fable.blog.pojo.dto.CategoryDTO;
import grey.fable.blog.pojo.entity.CategoryDO;
import grey.fable.blog.pojo.query.CategoryQuery;
import grey.fable.blog.pojo.vo.CategoryVO;
import grey.fable.blog.service.CategoryService;
import grey.fable.blog.util.MapStructUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 分类控制器.
 *
 * @author GreyFable
 * @since 2024/11/26 16:37
 */
@RestController
public class CategoryController {

    private final MapStructUtils mapStructUtils;
    private final CategoryService categoryService;

    public CategoryController(MapStructUtils mapStructUtils, CategoryService categoryService) {
        this.mapStructUtils = mapStructUtils;
        this.categoryService = categoryService;
    }

    @GetMapping("/categories/page")
    public Response<Page<CategoryVO>> pageCategories(CategoryQuery categoryQuery) {
        Page<CategoryDO> page = categoryService.pageCategories(categoryQuery);
        return Response.success(mapStructUtils.convertCategories(page));
    }

    @GetMapping("/categories/list")
    public Response<List<CategoryVO>> listCategories() {
        List<CategoryDO> categoryDos = categoryService.listCategories();
        return Response.success(mapStructUtils.convertCategories(categoryDos));
    }

    @PostMapping("/categories")
    public Response<Integer> addCategory(@RequestBody CategoryDTO categoryDTO) {
        CategoryDO categoryDO = mapStructUtils.convertCategories(categoryDTO);
        return Response.success(categoryService.addCategory(categoryDO));
    }

    @PutMapping("/categories")
    public Response<Integer> updateCategory(@RequestBody CategoryDTO categoryDTO) {
        CategoryDO categoryDO = mapStructUtils.convertCategories(categoryDTO);
        return Response.success(categoryService.updateCategory(categoryDO));
    }

    @DeleteMapping("/categories/{id}")
    public Response<Integer> deleteCategory(@PathVariable("id") String id) {
        return Response.success(categoryService.deleteCategory(id));
    }
}
