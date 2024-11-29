package grey.fable.vocabulary.util;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import grey.fable.vocabulary.pojo.dto.TopicDTO;
import grey.fable.vocabulary.pojo.dto.VocabularyDTO;
import grey.fable.vocabulary.pojo.entity.TopicDO;
import grey.fable.vocabulary.pojo.entity.TranslationDO;
import grey.fable.vocabulary.pojo.entity.VocabularyDO;
import grey.fable.vocabulary.pojo.vo.TopicVO;
import grey.fable.vocabulary.pojo.vo.TranslationVO;
import grey.fable.vocabulary.pojo.vo.VocabularyVO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * 词汇转换类.
 *
 * @author GreyFable
 * @since 2024/11/29 11:12
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapStructUtils {

    VocabularyVO convertVocabularies(VocabularyDO vocabularyDO);

    List<VocabularyVO> convertVocabularies(List<VocabularyDO> vocabularyDos);

    Page<VocabularyVO> convertVocabularies(Page<VocabularyDO> page);

    VocabularyDO convertVocabularies(VocabularyDTO vocabularyDTO);

    TranslationVO convertTranslations(TranslationDO translationDO);

    List<TranslationVO> convertTranslations(List<TranslationDO> translationDos);

//    Page<TranslationVO> convertTranslations(Page<TranslationDO> page);

//    TranslationDO convertTranslations(TranslationDTO translationDTO);

    TopicVO convertTopics(TopicDO topicDO);

    List<TopicVO> convertTopics(List<TopicDO> topicDos);

    Page<TopicVO> convertTopics(Page<TopicDO> page);

    TopicDO convertTopics(TopicDTO topicDTO);
}
