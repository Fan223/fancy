package grey.fable.vocabulary.service;

import grey.fable.vocabulary.pojo.entity.TranslationDO;

import java.util.List;

/**
 * 翻译接口.
 *
 * @author GreyFable
 * @since 2024/11/29 14:14
 */
public interface TranslationService {

    List<TranslationDO> listTranslations(List<String> wordIds);
}
