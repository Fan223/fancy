package grey.fable.common.mybatis.plus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import grey.fable.base.utils.IdUtils;
import grey.fable.base.utils.LambdaUtils;
import grey.fable.common.mybatis.plus.pojo.entity.MetaDO;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;

/**
 * 自动填充处理器.
 *
 * @author GreyFable
 * @since 2025/3/6 9:04
 */
public class FancyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        // 自动填充主键ID.
        this.strictInsertFill(metaObject, LambdaUtils.getFieldName(MetaDO::getId), Long.class, IdUtils.getSnowflakeId());
        // 自动填充创建和更新时间.
        LocalDateTime now = LocalDateTime.now();
        this.strictInsertFill(metaObject, LambdaUtils.getFieldName(MetaDO::getCreateTime), LocalDateTime.class, now);
        this.strictInsertFill(metaObject, LambdaUtils.getFieldName(MetaDO::getUpdateTime), LocalDateTime.class, now);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 自动填充更新时间.
        this.strictInsertFill(metaObject, LambdaUtils.getFieldName(MetaDO::getUpdateTime), LocalDateTime::now, LocalDateTime.class);
    }
}
