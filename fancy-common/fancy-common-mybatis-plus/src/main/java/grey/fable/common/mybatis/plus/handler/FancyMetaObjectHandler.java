package grey.fable.common.mybatis.plus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import grey.fable.common.core.util.IdUtils;
import grey.fable.common.core.util.LambdaUtils;
import grey.fable.common.mybatis.plus.entity.BaseDO;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;

/**
 * 自动填充.
 *
 * @author GreyFable
 * @since 2024/12/9 16:05
 */
public class FancyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        // 自动填充主键ID.
        this.strictInsertFill(metaObject, LambdaUtils.getFieldName(BaseDO::getId), Long.class, IdUtils.getSnowflakeNextId());
        // 自动填充创建和更新时间.
        LocalDateTime now = LocalDateTime.now();
        this.strictInsertFill(metaObject, LambdaUtils.getFieldName(BaseDO::getCreateTime), LocalDateTime.class, now);
        this.strictInsertFill(metaObject, LambdaUtils.getFieldName(BaseDO::getUpdateTime), LocalDateTime.class, now);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 自动填充更新时间.
        this.strictInsertFill(metaObject, LambdaUtils.getFieldName(BaseDO::getUpdateTime), LocalDateTime::now, LocalDateTime.class);
    }
}
