package grey.fable.common.mybatis.plus;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import grey.fable.common.mybatis.plus.handler.FancyMetaObjectHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * MyBatis-Plus 配置类.
 *
 * @author GreyFable
 * @since 2024/12/9 15:19
 */
@Import(FancyMetaObjectHandler.class)
public class MybatisPlusAutoConfiguration {

    /**
     * 插件.
     *
     * @return {@link MybatisPlusInterceptor}
     * @author GreyFable
     * @since 2024/12/10 11:15
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 防全表更新与删除插件.
        interceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());
        // 分页插件. 多数据源可以不配具体类型, 否则建议配置. 如果配置多个插件, 最后添加.
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

//    /**
//     * 自动填充字段.
//     *
//     * @return {@link FancyMetaObjectHandler}
//     * @author GreyFable
//     * @since 2024/12/10 11:15
//     */
//    @Bean
//    public FancyMetaObjectHandler fancyMetaObjectHandler() {
//        return new FancyMetaObjectHandler();
//    }
}
