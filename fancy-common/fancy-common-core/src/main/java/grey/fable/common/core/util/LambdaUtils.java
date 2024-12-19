package grey.fable.common.core.util;

import cn.hutool.core.lang.func.Func1;
import cn.hutool.core.lang.func.LambdaUtil;

/**
 * Lambda 工具类.
 *
 * @author GreyFable
 * @since 2024/12/10 16:42
 */
public record LambdaUtils() {

    /**
     * 获取 Lambda 表达式 Getter/Setter 方法对应的字段名称.
     *
     * @param func {@link Func1}
     * @return {@link String}
     * @author GreyFable
     * @since 2024/12/11 9:26
     */
    public static <T> String getFieldName(Func1<T, ?> func) {
        return LambdaUtil.getFieldName(func);
    }
}
