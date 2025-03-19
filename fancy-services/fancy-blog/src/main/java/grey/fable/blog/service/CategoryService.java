package grey.fable.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import grey.fable.blog.pojo.entity.CategoryDO;
import grey.fable.blog.pojo.query.CategoryQuery;

import java.util.List;

/**
 * 分类接口.
 *
 * @author GreyFable
 * @since 2025/3/7 15:53
 */
public interface CategoryService {
    
    Page<CategoryDO> pageCategories(CategoryQuery categoryQuery);

    List<CategoryDO> listCategories();

    Integer addCategory(CategoryDO categoryDO);

    Integer updateCategory(CategoryDO categoryDO);

    Integer deleteCategory(String id);
}
