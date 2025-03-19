package grey.fable.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import grey.fable.blog.pojo.entity.TagDO;
import grey.fable.blog.pojo.query.TagQuery;

import java.util.List;

/**
 * 标签接口.
 *
 * @author GreyFable
 * @since 2025/3/7 15:53
 */
public interface TagService {
    
    Page<TagDO> pageTags(TagQuery tagQuery);

    List<TagDO> listTags();

    Integer addTag(TagDO tagDO);

    Integer updateTag(TagDO tagDO);

    Integer deleteTag(String id);
}
