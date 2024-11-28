package grey.fable.common.query;

import lombok.Setter;

/**
 * 分页查询参数.
 *
 * @author GreyFable
 * @since 2024/11/28 10:46
 */
@Setter
public class PageQuery {

    private Long currentPage;

    private Long pageSize;

    public long getCurrentPage() {
        if (null == currentPage || currentPage <= 0L) {
            currentPage = 1L;
        }
        return currentPage;
    }

    public long getPageSize() {
        if (null == pageSize || pageSize <= 0L) {
            pageSize = 12L;
        }
        return pageSize;
    }
}
