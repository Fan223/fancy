package grey.fable.vocabulary.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import grey.fable.common.mybatis.plus.entity.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 主题实体类.
 *
 * @author GreyFable
 * @since 2024/11/29 13:45
 */
@Data
@TableName("topic")
@EqualsAndHashCode(callSuper = true)
public class TopicDO extends BaseDO {

    /**
     * 名称.
     */
    private String name;
}
