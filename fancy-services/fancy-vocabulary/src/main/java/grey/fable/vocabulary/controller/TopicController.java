package grey.fable.vocabulary.controller;

import grey.fable.base.net.Response;
import grey.fable.vocabulary.pojo.dto.TopicDTO;
import grey.fable.vocabulary.pojo.entity.TopicDO;
import grey.fable.vocabulary.pojo.query.TopicQuery;
import grey.fable.vocabulary.pojo.vo.TopicVO;
import grey.fable.vocabulary.service.TopicService;
import grey.fable.vocabulary.util.MapStructUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 主题控制器.
 *
 * @author GreyFable
 * @since 2024/11/29 13:57
 */
@RestController
public class TopicController {

    private final MapStructUtils mapStructUtils;
    private final TopicService topicService;

    public TopicController(MapStructUtils mapStructUtils, TopicService topicService) {
        this.mapStructUtils = mapStructUtils;
        this.topicService = topicService;
    }

    @GetMapping("/topics")
    public Response<List<TopicVO>> listTopics(TopicQuery topicQuery) {
        List<TopicDO> topicDos = topicService.listTopics(topicQuery);
        return Response.success(mapStructUtils.convertTopics(topicDos));
    }

    @PostMapping("/topics")
    public Response<Integer> addTopic(@RequestBody TopicDTO topicDTO) {
        TopicDO topicDO = mapStructUtils.convertTopics(topicDTO);
        return Response.success(topicService.addTopic(topicDO));
    }

    @PutMapping("/topics")
    public Response<Integer> updateTopic(@RequestBody TopicDTO topicDTO) {
        TopicDO topicDO = mapStructUtils.convertTopics(topicDTO);
        return Response.success(topicService.updateTopic(topicDO));
    }

    @DeleteMapping("/topics/{id}")
    public Response<Integer> deleteTopic(@PathVariable("id") String id) {
        return Response.success(topicService.deleteTopic(id));
    }
}
