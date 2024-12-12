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
 * @since 2024/11/26 16:38
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDAO categoryDAO;

    public CategoryServiceImpl(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @Override
    public Page<CategoryDO> pageCategories(CategoryQuery categoryQuery) {
        LambdaQueryWrapper<CategoryDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StringUtils.isNotBlank(categoryQuery.getState()), CategoryDO::getState, categoryQuery.getState())
                .like(StringUtils.isNotBlank(categoryQuery.getName()), CategoryDO::getName, categoryQuery.getName());
        return categoryDAO.selectPage(new Page<>(categoryQuery.getCurrentPage(), categoryQuery.getPageSize()), queryWrapper);
    }

    @Override
    public List<CategoryDO> listCategories() {
        return categoryDAO.selectList(new LambdaQueryWrapper<>());
    }

    @Override
    public int addCategory(CategoryDO categoryDO) {
        return categoryDAO.insert(categoryDO);
    }

    @Override
    public int updateCategory(CategoryDO categoryDO) {
        return categoryDAO.updateById(categoryDO);
    }

    @Override
    public int deleteCategory(String id) {
        return categoryDAO.deleteById(id);
    }
}
