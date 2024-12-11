package grey.fable.vocabulary.pojo.vo;

import lombok.Data;

/**
 * 翻译展示类.
 *
 * @author GreyFable
 * @since 2024/11/29 14:03
 */
@Data
public class TranslationVO {

    /**
     * 翻译ID.
     */
    private String id;

    /**
     * 单词ID.
     */
    private String wordId;

    /**
     * 词性.
     */
    private String pos;

    /**
     * 翻译.
     */
    private String translation;
}
