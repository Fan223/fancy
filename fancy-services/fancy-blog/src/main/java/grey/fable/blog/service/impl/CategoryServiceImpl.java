package grey.fable.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import grey.fable.base.text.StringUtils;
import grey.fable.blog.dao.CategoryDAO;
import grey.fable.blog.pojo.entity.CategoryDO;
import grey.fable.blog.pojo.query.CategoryQuery;
import grey.fable.blog.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 分类接口实现类.
 *
 * @author GreyFable
 * @since 2025/3/7 15:54
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDAO categoryDAO;

    public CategoryServiceImpl(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @Override
    public Page<CategoryDO> pageCategories(CategoryQuery query) {
        LambdaQueryWrapper<CategoryDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StringUtils.isNotBlank(query.getState()), CategoryDO::getState, query.getState())
                .like(StringUtils.isNotBlank(query.getName()), CategoryDO::getName, query.getName());
        return categoryDAO.selectPage(new Page<>(query.getCurrentPage(), query.getPageSize()), wrapper);
    }

    @Override
    public List<CategoryDO> listCategories() {
        LambdaQueryWrapper<CategoryDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByAsc(CategoryDO::getSort);
        return categoryDAO.selectList(wrapper);
    }

    @Override
    public Integer addCategory(CategoryDO categoryDO) {
        return categoryDAO.insert(categoryDO);
    }

    @Override
    public Integer updateCategory(CategoryDO categoryDO) {
        return categoryDAO.updateById(categoryDO);
    }

    @Override
    public Integer deleteCategory(String id) {
        return categoryDAO.deleteById(id);
    }
}
