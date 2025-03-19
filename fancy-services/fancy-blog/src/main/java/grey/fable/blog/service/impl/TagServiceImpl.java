package grey.fable.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import grey.fable.base.text.StringUtils;
import grey.fable.blog.dao.TagDAO;
import grey.fable.blog.pojo.entity.TagDO;
import grey.fable.blog.pojo.query.TagQuery;
import grey.fable.blog.service.TagService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 标签接口实现类.
 *
 * @author GreyFable
 * @since 2025/3/7 15:53
 */
@Service
public class TagServiceImpl implements TagService {

    private final TagDAO tagDAO;

    public TagServiceImpl(TagDAO tagDAO) {
        this.tagDAO = tagDAO;
    }

    @Override
    public Page<TagDO> pageTags(TagQuery query) {
        LambdaQueryWrapper<TagDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(StringUtils.isNotBlank(query.getName()), TagDO::getName, query.getName());
        return tagDAO.selectPage(new Page<>(query.getCurrentPage(), query.getPageSize()), wrapper);
    }

    @Override
    public List<TagDO> listTags() {
        return tagDAO.selectList(new LambdaQueryWrapper<>());
    }

    @Override
    public Integer addTag(TagDO tagDO) {
        return tagDAO.insert(tagDO);
    }

    @Override
    public Integer updateTag(TagDO tagDO) {
        return tagDAO.updateById(tagDO);
    }

    @Override
    public Integer deleteTag(String id) {
        return tagDAO.deleteById(id);
    }
}
