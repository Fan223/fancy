package grey.fable.vocabulary.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import grey.fable.base.text.StringUtils;
import grey.fable.base.util.IdUtils;
import grey.fable.vocabulary.dao.VocabularyDAO;
import grey.fable.vocabulary.pojo.entity.VocabularyDO;
import grey.fable.vocabulary.pojo.query.VocabularyQuery;
import grey.fable.vocabulary.service.VocabularyService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * 词汇接口实现类.
 *
 * @author GreyFable
 * @since 2024/11/29 11:11
 */
@Service
public class VocabularyServiceImpl implements VocabularyService {

    private final VocabularyDAO vocabularyDAO;

    public VocabularyServiceImpl(VocabularyDAO vocabularyDAO) {
        this.vocabularyDAO = vocabularyDAO;
    }

    @Override
    public Page<VocabularyDO> pageVocabularies(VocabularyQuery vocabularyQuery) {
        LambdaQueryWrapper<VocabularyDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StringUtils.isNotBlank(vocabularyQuery.getState()), VocabularyDO::getState, vocabularyQuery.getState())
                .like(StringUtils.isNotBlank(vocabularyQuery.getWord()), VocabularyDO::getWord, vocabularyQuery.getWord());
        return vocabularyDAO.selectPage(new Page<>(vocabularyQuery.getCurrentPage(), vocabularyQuery.getPageSize()), queryWrapper);
    }

    @Override
    public Integer addVocabulary(VocabularyDO vocabularyDO) {
        LocalDateTime now = LocalDateTime.now();

        vocabularyDO.setId(IdUtils.getSnowflakeNextId());
        vocabularyDO.setCreateTime(now);
        vocabularyDO.setUpdateTime(now);
        return vocabularyDAO.insert(vocabularyDO);
    }

    @Override
    public Integer updateVocabulary(VocabularyDO vocabularyDO) {
        vocabularyDO.setUpdateTime(LocalDateTime.now());
        return vocabularyDAO.updateById(vocabularyDO);
    }

    @Override
    public Integer deleteVocabulary(String id) {
        return vocabularyDAO.deleteById(id);
    }
}
