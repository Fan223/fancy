package grey.fable.vocabulary.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import grey.fable.base.text.StringUtils;
import grey.fable.vocabulary.dao.TopicDAO;
import grey.fable.vocabulary.pojo.entity.TopicDO;
import grey.fable.vocabulary.pojo.query.TopicQuery;
import grey.fable.vocabulary.service.TopicService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 主题接口实现类.
 *
 * @author GreyFable
 * @since 2024/11/29 14:06
 */
@Service
public class TopicServiceImpl implements TopicService {

    private final TopicDAO topicDAO;

    public TopicServiceImpl(TopicDAO topicDAO) {
        this.topicDAO = topicDAO;
    }

    @Override
    public List<TopicDO> listTopics(TopicQuery topicQuery) {
        LambdaQueryWrapper<TopicDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StringUtils.isNotBlank(topicQuery.getName()), TopicDO::getName, topicQuery.getName());
        return topicDAO.selectList(queryWrapper);
    }

    @Override
    public Integer addTopic(TopicDO topicDO) {
        return topicDAO.insert(topicDO);
    }

    @Override
    public Integer updateTopic(TopicDO topicDO) {
        return topicDAO.updateById(topicDO);
    }

    @Override
    public Integer deleteTopic(String id) {
        return topicDAO.deleteById(id);
    }
}
