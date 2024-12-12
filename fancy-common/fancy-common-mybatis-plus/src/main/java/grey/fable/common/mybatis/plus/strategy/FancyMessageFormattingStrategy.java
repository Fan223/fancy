package grey.fable.common.mybatis.plus.strategy;

import com.p6spy.engine.common.P6Util;
import com.p6spy.engine.spy.appender.MessageFormattingStrategy;

/**
 * 日志格式化策略.
 *
 * @author GreyFable
 * @since 2024/12/11 10:30
 */
public class FancyMessageFormattingStrategy implements MessageFormattingStrategy {

    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String url) {
        return "Consume Time: " + elapsed + "ms " + now +
                "\n\tExecute SQL: " + P6Util.singleLine(sql);
    }
}
