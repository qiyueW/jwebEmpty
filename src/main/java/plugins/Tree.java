package plugins;

import configuration.Tool;
import java.util.ArrayList;
import java.util.List;
import plugins.tree.TreeCache;
import plugins.tree.TreeField;

/**
 *
 * @author wo
 * @param <T>
 */
public class Tree<T> {

    final List<T> allList;
    private List<T> topList;
    private final List<T> mysaon = new ArrayList<>();
    private TreeField treeField = null;

    public Tree(List<T> list, String id, String pid, String name) {
        this.allList = list;
        if (list.size() > 0) {
            this.treeField = TreeCache.getTreeField(list.get(0).getClass(), id, pid, name);
            this.topList = new ArrayList<>();
            iniTopFather();
        }
    }

    public String toTree() {
        if (null == this.treeField) {
            return "[]";
        }
        if (this.allList.isEmpty()) {
            return Tool.entityToJSON(topList);
        }
        StringBuilder sb = new StringBuilder();
        String json;
        boolean fist = true;

        for (T t : this.topList) {
            json = t.toString();
            if (fist) {
                fist = false;
                sb.append(json.substring(0, json.length() - 1));
            } else {
                sb.append(",").append(json.substring(0, json.length() - 1));
            }
            findMyAllSon(t, sb);
            this.allList.removeAll(mysaon);
            this.mysaon.clear();
            sb.append("}");
        }
        return "[" + sb.toString() + "]";
    }

    private void findMyAllSon(T tobj, StringBuilder sb) {
        String json;
        boolean fist = true;
        for (T t : this.allList) {
            if (this.treeField.getPID(t).equals(this.treeField.getID(tobj))) {
//            if (getPID(t).equals(getID(tobj))) {
                this.mysaon.add(t);
                json = t.toString();
                if (fist) {
                    sb.append(",\"children\":[").append(json.substring(0, json.length() - 1));
                    fist = false;
                } else {
                    sb.append(",").append(json.substring(0, json.length() - 1));
                }
                findMyAllSon(t, sb);
                sb.append("}");
            }
        }
        if (!fist) {
            sb.append("]");
        }
    }

    private void iniTopFather() {
        String id;
        next:
        for (T t : this.allList) {
            id = this.treeField.getPID(t);// getFieldValue(fpid, t);//拿出自己的父键。
            if (null == id || id.isEmpty() || id.equals("0")) {
                this.topList.add(t);//表示顶层。
            } else {
                for (T t2 : this.allList) {
                    if (id.equals(this.treeField.getPID(t2))) {//getFieldValue(fid, t2)如果自己的父键，是别人的主键。表示此节点不是顶节点。
                        continue next;//结束查询。
                    }
                }
                this.topList.add(t);
            }
        }
        this.allList.removeAll(this.topList);
    }
}
