package grey.fable.common.core.util;

import cn.hutool.core.lang.func.Func1;
import cn.hutool.core.lang.func.LambdaUtil;

/**
 * Lambda 工具类.
 *
 * @author GreyFable
 * @since 2024/12/10 16:42
 */
public final class LambdaUtils {

    private LambdaUtils() {
    }

    public static <T> String getFieldName(Func1<T, ?> func) {
        return LambdaUtil.getFieldName(func);
    }
}
