package grey.fable.common.mybatis.plus.handler;

import cn.hutool.core.lang.func.LambdaUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import grey.fable.base.util.IdUtils;
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
        this.strictInsertFill(metaObject, LambdaUtil.getFieldName(BaseDO::getId), Long.class, IdUtils.getSnowflakeNextId());

        LocalDateTime now = LocalDateTime.now();
        this.strictInsertFill(metaObject, LambdaUtils.getFieldName(BaseDO::getCreateTime), LocalDateTime.class, now);
        this.strictInsertFill(metaObject, LambdaUtils.getFieldName(BaseDO::getUpdateTime), LocalDateTime.class, now);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, LambdaUtils.getFieldName(BaseDO::getUpdateTime), LocalDateTime::now, LocalDateTime.class);
    }
}
