package grey.fable.common.core;

/**
 * 统一返回类.
 *
 * @author GreyFable
 * @since 2024/12/14 14:14
 */
public record Response<T>(int code, String message, T data) {

    public Response(String message, T data) {
        this(200, message, data);
    }

    public Response(T data) {
        this(200, "Successful", data);
    }
}
