package grey.fable.blog.converter;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import grey.fable.blog.pojo.dto.ArticleDTO;
import grey.fable.blog.pojo.dto.CategoryDTO;
import grey.fable.blog.pojo.dto.TagDTO;
import grey.fable.blog.pojo.entity.ArticleDO;
import grey.fable.blog.pojo.entity.CategoryDO;
import grey.fable.blog.pojo.entity.TagDO;
import grey.fable.blog.pojo.vo.ArticleVO;
import grey.fable.blog.pojo.vo.CategoryVO;
import grey.fable.blog.pojo.vo.TagVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * 实体类转换类.
 *
 * @author GreyFable
 * @since 2025/3/6 9:55
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BlogConverter {

    @Mapping(target = "updateTime", source = "updateTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    ArticleVO convertArticles(ArticleDO articleDO);

    List<ArticleVO> convertArticles(List<ArticleDO> articleDos);

    Page<ArticleVO> convertArticles(Page<ArticleDO> page);

    ArticleDO convertArticles(ArticleDTO articleDTO);

    CategoryVO convertCategories(CategoryDO categoryDO);

    List<CategoryVO> convertCategories(List<CategoryDO> categoryDos);

    Page<CategoryVO> convertCategories(Page<CategoryDO> page);

    CategoryDO convertCategories(CategoryDTO categoryDTO);

    TagVO convertTags(TagDO tagDO);

    List<TagVO> convertTags(List<TagDO> tagDos);

    Page<TagVO> convertTags(Page<TagDO> page);

    TagDO convertTags(TagDTO tagDTO);
}
