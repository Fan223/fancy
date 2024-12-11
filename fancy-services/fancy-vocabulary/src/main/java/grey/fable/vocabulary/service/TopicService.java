package grey.fable.vocabulary.service;

import grey.fable.vocabulary.pojo.entity.TopicDO;
import grey.fable.vocabulary.pojo.query.TopicQuery;

import java.util.List;

/**
 * 主题接口.
 *
 * @author GreyFable
 * @since 2024/11/29 14:06
 */
public interface TopicService {

    List<TopicDO> listTopics(TopicQuery topicQuery);

    Integer addTopic(TopicDO topicDO);

    Integer updateTopic(TopicDO topicDO);

    Integer deleteTopic(String id);
}
