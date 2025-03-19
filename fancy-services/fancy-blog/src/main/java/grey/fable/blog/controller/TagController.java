package grey.fable.blog.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import grey.fable.base.net.Response;
import grey.fable.blog.converter.BlogConverter;
import grey.fable.blog.pojo.dto.TagDTO;
import grey.fable.blog.pojo.entity.TagDO;
import grey.fable.blog.pojo.query.TagQuery;
import grey.fable.blog.pojo.vo.TagVO;
import grey.fable.blog.service.TagService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 标签控制器.
 *
 * @author GreyFable
 * @since 2025/3/7 15:52
 */
@RestController
public class TagController {

    private final TagService tagService;

    private final BlogConverter blogConverter;

    public TagController(TagService tagService, BlogConverter blogConverter) {
        this.tagService = tagService;
        this.blogConverter = blogConverter;
    }

    @GetMapping("/tags/page")
    public Response<Page<TagVO>> pageTags(TagQuery tagQuery) {
        Page<TagDO> page = tagService.pageTags(tagQuery);
        return Response.success(blogConverter.convertTags(page));
    }

    @GetMapping("/tags/list")
    public Response<List<TagVO>> listTags() {
        List<TagDO> tagDos = tagService.listTags();
        return Response.success(blogConverter.convertTags(tagDos));
    }

    @PostMapping("/tags")
    public Response<Integer> addTag(@RequestBody TagDTO tagDTO) {
        TagDO tagDO = blogConverter.convertTags(tagDTO);
        return Response.success(tagService.addTag(tagDO));
    }

    @PutMapping("/tags")
    public Response<Integer> updateTag(@RequestBody TagDTO tagDTO) {
        TagDO tagDO = blogConverter.convertTags(tagDTO);
        return Response.success(tagService.updateTag(tagDO));
    }

    @DeleteMapping("/tags/{id}")
    public Response<Integer> deleteTag(@PathVariable("id") String id) {
        return Response.success(tagService.deleteTag(id));
    }

}
