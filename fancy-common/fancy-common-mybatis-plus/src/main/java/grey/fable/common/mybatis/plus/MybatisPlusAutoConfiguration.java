package grey.fable.common.mybatis.plus;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import grey.fable.common.mybatis.plus.handler.FancyMetaObjectHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * MyBatis-Plus 自动配置类.
 *
 * @author GreyFable
 * @since 2025/3/6 9:03
 */
@Import(FancyMetaObjectHandler.class)
public class MybatisPlusAutoConfiguration {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 防全表更新与删除插件.
        interceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());
        // 分页插件. 多数据源可以不配具体类型, 否则建议配置. 如果配置多个插件, 最后添加.
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
}
