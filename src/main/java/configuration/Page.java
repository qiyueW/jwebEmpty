package configuration;

/**
 *
 * @author wo
 */
public interface Page {

    /**
     * 页码
     *
     * @return
     */
    int getPage();

    /**
     * 页记录数量
     *
     * @return
     */
    int getRows();

    /**
     * 页码字段名
     *
     * @return
     */
    String getPageName();

    /**
     * 页记录数量字段名
     *
     * @return
     */
    String getRowsName();

    /**
     * 获取排序字段的条件
     *
     * @return
     */
    String getOrderBy();

    /**
     * 获取排序的字段（没有时，直接返回defaultOrderby）
     *
     * @param defaultOrderby
     * @return
     */
    String getOrderBy(String defaultOrderby);
}
