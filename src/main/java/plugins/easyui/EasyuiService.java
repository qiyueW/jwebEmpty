package plugins.easyui;

import configuration.Tool;
import java.util.List;
import plugins.Tree;

import plugins.easyui.vo.EasyuiPage;

import system.web.JWeb;

/**
 *
 * @author wangchunzi
 */
final public class EasyuiService {

    private static final String EMPTYDATA = "{\"total\": \"0\",\"rows\":[]}";
    public final static String KEY_GRID_LIST = "#KEY_GRID_LIST";
    public final static String KEY_GRID_COUNT = "#KEY_GRID_COUNT";

    final public static String formatGrid(List<?> rsList, int count) {
        return null == rsList || rsList.isEmpty() ? EMPTYDATA : "{\"total\": \"" + count + "\",\"rows\":" + Tool.entityToJSON(rsList) + "}";
    }

    final public static String formatGrid(List<?> rsList) {
        return null == rsList || rsList.isEmpty() ? EMPTYDATA : "{\"total\": \"" + rsList.size() + "\",\"rows\":" + Tool.entityToJSON(rsList) + "}";
    }

    final public static String formatTreeGrid(List<?> rsList, String id, String pid, String name) {
        if (null == rsList || rsList.isEmpty()) {
            return EMPTYDATA;
        }
        Tree tree = new Tree<>(rsList, id, pid, name);
        return "{\"total\": \"" + rsList.size() + "\",\"rows\":" + tree.toTree() + "}";

    }

    final public static String formatTree(List<?> rsList, String id, String pid, String name) {
        if (null == rsList || rsList.isEmpty()) {
            return "[]";
        }
        Tree tree = new Tree<>(rsList, id, pid, name);
        return tree.toTree();

    }

    /**
     * 取得 easyui传来的分页数据
     *
     * @param jw
     * @return EasyuiPage
     */
    final public static EasyuiPage getPage(JWeb jw) {
        return new EasyuiPage(jw.getInt("page", 1), jw.getInt("rows", 10));
    }

    final public static String getOrderBy(JWeb jw) {
        String sortname = jw.request.getParameter("sort");
        if (null == sortname) {
            return "";
        }
        String sortorder = jw.request.getParameter("order");
        return "order by " + sortname + " " + (null == sortorder ? "ASC" : sortorder);
    }
}
