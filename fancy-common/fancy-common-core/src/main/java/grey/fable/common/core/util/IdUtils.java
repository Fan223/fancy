package grey.fable.common.core.util;

/**
 * ID 工具类.
 *
 * @author GreyFable
 * @since 2024/12/11 9:23
 */
public record IdUtils() {

    /**
     * 获取雪花ID.
     *
     * @return {@link long}
     * @author GreyFable
     * @since 2024/12/11 9:26
     */
    public static long getSnowflakeNextId() {
        return grey.fable.base.util.IdUtils.getSnowflakeNextId();
    }
}
