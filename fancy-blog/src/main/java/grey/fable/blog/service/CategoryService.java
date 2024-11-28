package grey.fable.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import grey.fable.blog.pojo.entity.CategoryDO;
import grey.fable.blog.pojo.query.CategoryQuery;

import java.util.List;

/**
 * 分类接口.
 *
 * @author GreyFable
 * @since 2024/11/26 16:37
 */
public interface CategoryService {

    Page<CategoryDO> pageCategories(CategoryQuery categoryQuery);

    List<CategoryDO> listCategories();

    int addCategory(CategoryDO categoryDO);

    int updateCategory(CategoryDO categoryDO);

    int deleteCategory(String id);
}
