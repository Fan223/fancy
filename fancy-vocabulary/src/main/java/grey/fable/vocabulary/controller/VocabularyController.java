package grey.fable.vocabulary.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import grey.fable.base.net.Response;
import grey.fable.vocabulary.pojo.dto.VocabularyDTO;
import grey.fable.vocabulary.pojo.entity.TranslationDO;
import grey.fable.vocabulary.pojo.entity.VocabularyDO;
import grey.fable.vocabulary.pojo.query.VocabularyQuery;
import grey.fable.vocabulary.pojo.vo.TranslationVO;
import grey.fable.vocabulary.pojo.vo.VocabularyVO;
import grey.fable.vocabulary.service.TranslationService;
import grey.fable.vocabulary.service.VocabularyService;
import grey.fable.vocabulary.util.MapStructUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 词汇控制器.
 *
 * @author GreyFable
 * @since 2024/11/29 11:10
 */
@RestController
public class VocabularyController {

    private final MapStructUtils mapStructUtils;
    private final VocabularyService vocabularyService;
    private final TranslationService translationService;

    public VocabularyController(MapStructUtils mapStructUtils, VocabularyService vocabularyService, TranslationService translationService) {
        this.mapStructUtils = mapStructUtils;
        this.vocabularyService = vocabularyService;
        this.translationService = translationService;
    }

    @GetMapping("/vocabularies")
    public Response<Page<VocabularyVO>> pageVocabularies(VocabularyQuery vocabularyQuery) {
        Page<VocabularyDO> doPage = vocabularyService.pageVocabularies(vocabularyQuery);
        Page<VocabularyVO> voPage = mapStructUtils.convertVocabularies(doPage);

        List<String> wordIds = voPage.getRecords().stream().map(VocabularyVO::getId).toList();
        List<TranslationDO> translationDos = translationService.listTranslations(wordIds);
        List<TranslationVO> translationVos = mapStructUtils.convertTranslations(translationDos);
        Map<String, List<TranslationVO>> map = translationVos.stream().collect(Collectors.groupingBy(TranslationVO::getWordId));

        voPage.getRecords().forEach(vocabularyVO -> vocabularyVO.setTranslationVos(map.get(vocabularyVO.getId())));
        return Response.success(voPage);
    }

    @PostMapping("/vocabularies")
    public Response<Integer> addVocabulary(VocabularyDTO vocabularyDTO) {
        VocabularyDO vocabularyDO = mapStructUtils.convertVocabularies(vocabularyDTO);
        return Response.success(vocabularyService.addVocabulary(vocabularyDO));
    }

    @PutMapping("/vocabularies")
    public Response<Integer> updateVocabulary(VocabularyDTO vocabularyDTO) {
        VocabularyDO vocabularyDO = mapStructUtils.convertVocabularies(vocabularyDTO);
        return Response.success(vocabularyService.updateVocabulary(vocabularyDO));
    }

    @DeleteMapping("/vocabularies/{id}")
    public Response<Integer> deleteVocabulary(@PathVariable String id) {
        return Response.success(vocabularyService.deleteVocabulary(id));
    }
}
