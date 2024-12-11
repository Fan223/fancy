package grey.fable.vocabulary.pojo.vo;

import lombok.Data;

import java.util.List;

/**
 * 词汇展示类.
 *
 * @author GreyFable
 * @since 2024/11/29 11:08
 */
@Data
public class VocabularyVO {

    /**
     * 词汇ID.
     */
    private String id;

    /**
     * 单词.
     */
    private String word;

    /**
     * 音标.
     */
    private String phonetic;

    /**
     * 状态.
     */
    private String state;

    /**
     * 翻译列表.
     */
    private List<TranslationVO> translationVos;
}
