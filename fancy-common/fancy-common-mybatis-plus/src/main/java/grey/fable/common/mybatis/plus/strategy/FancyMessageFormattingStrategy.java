package grey.fable.common.mybatis.plus.strategy;

import com.p6spy.engine.common.P6Util;
import com.p6spy.engine.spy.appender.MessageFormattingStrategy;

/**
 * 日志格式化策略.
 *
 * @author GreyFable
 * @since 2025/3/6 9:26
 */
public class FancyMessageFormattingStrategy implements MessageFormattingStrategy {

    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String url) {
        return "\n\t耗时: " + elapsed + "ms\t" + P6Util.singleLine(sql);
    }
}
