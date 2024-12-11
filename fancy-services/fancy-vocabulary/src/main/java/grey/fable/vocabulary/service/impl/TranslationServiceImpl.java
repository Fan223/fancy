package grey.fable.vocabulary.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import grey.fable.vocabulary.dao.TranslationDAO;
import grey.fable.vocabulary.pojo.entity.TranslationDO;
import grey.fable.vocabulary.service.TranslationService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 翻译接口实现类.
 *
 * @author GreyFable
 * @since 2024/11/29 14:14
 */
@Service
public class TranslationServiceImpl implements TranslationService {

    private final TranslationDAO translationDAO;

    public TranslationServiceImpl(TranslationDAO translationDAO) {
        this.translationDAO = translationDAO;
    }

    @Override
    public List<TranslationDO> listTranslations(List<String> wordIds) {
        LambdaQueryWrapper<TranslationDO> queryWrapper = new LambdaQueryWrapper<TranslationDO>()
                .in(TranslationDO::getWordId, wordIds);
        return translationDAO.selectList(queryWrapper);
    }
}
