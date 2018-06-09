package plugins.easyui;

import configuration.Page;

/**
 *
 * @author wo
 */
public class EasyuiPage implements Page {

    private final int page;
    private final int rows;
    private final String orderby;
    private final String pageName = "page";
    private final String rowsName = "rows";

    public EasyuiPage(int page, int rows, String orderby) {
        this.page = page;
        this.rows = rows;
        this.orderby = orderby;
    }

    @Override
    public int getPage() {
        return page;
    }

    @Override
    public int getRows() {
        return this.rows;
    }

    @Override
    public String getPageName() {
        return this.pageName;
    }

    @Override
    public String getRowsName() {
        return this.rowsName;
    }

    @Override
    public String getOrderBy() {
        return this.orderby;
    }

    @Override
    public String getOrderBy(String defaultOrderby) {
        return null == orderby || orderby.isEmpty() ? defaultOrderby : orderby;
    }

}
