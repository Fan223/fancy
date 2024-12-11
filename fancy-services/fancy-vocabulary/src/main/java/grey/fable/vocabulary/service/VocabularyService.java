package grey.fable.vocabulary.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import grey.fable.vocabulary.pojo.entity.VocabularyDO;
import grey.fable.vocabulary.pojo.query.VocabularyQuery;

/**
 * 词汇接口.
 *
 * @author GreyFable
 * @since 2024/11/29 11:11
 */
public interface VocabularyService {

    Page<VocabularyDO> pageVocabularies(VocabularyQuery vocabularyQuery);

    Integer addVocabulary(VocabularyDO vocabularyDO);

    Integer updateVocabulary(VocabularyDO vocabularyDO);

    Integer deleteVocabulary(String id);
}
