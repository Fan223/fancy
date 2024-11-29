package grey.fable.vocabulary.pojo.query;

import grey.fable.common.query.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 词汇查询参数.
 *
 * @author GreyFable
 * @since 2024/11/29 13:38
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class VocabularyQuery extends PageQuery {

    private String word;

    private String state;
}
