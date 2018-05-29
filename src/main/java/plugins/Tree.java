package plugins;

import com.alibaba.fastjson.JSON;
import configuration.Tool;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wo
 * @param <T>
 */
public class Tree<T> {

    final List<T> allList;
    private List<T> topList;
    final Class c;
    private Field fid = null, fpid = null, fname = null;
    Field[] fs;
    private final List<T> mysaon = new ArrayList<>();

    public Tree(List<T> list, String id, String pid, String name) {
        this.allList = list;
        if (list.size() > 0) {
            this.c = list.get(0).getClass();
            fs = c.getDeclaredFields();
            for (Field fobj : fs) {
                fobj.setAccessible(true);
                if (fobj.getName().equals(id)) {
                    fid = fobj;
                } else if (fobj.getName().equals(pid)) {
                    fpid = fobj;
                } else if (fobj.getName().equals(name)) {
                    fname = fobj;
                }
            }
            this.topList = new ArrayList<>();
            iniTopFather();
        } else {
            c = null;
            fs = null;
        }
    }

    public String toTree() {
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
            if (getPID(t).equals(getID(tobj))) {
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
            id = getFieldValue(fpid, t);
            if (null == id || id.isEmpty() || id.equals("0")) {
                this.topList.add(t);//表示顶层。
            } else {
                for (T t2 : this.allList) {
                    id = getFieldValue(fid, t);//拿出自己的主键。
                    if (id.equals(getFieldValue(fpid, t2))) {//如果自己的主键，是别人的父键。表示此节点不是顶节点。
                        continue next;//结束查询。
                    }
                }
                this.topList.add(t);

            }
        }

        this.allList.removeAll(this.topList);
    }

    String getFieldValue(Field f, Object obj) {
        try {
            return f.get(obj).toString();
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(Tool.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    String getPID(Object obj) {
        try {
            return fpid.get(obj).toString();
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(Tool.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    String getID(Object obj) {
        try {
            return fid.get(obj).toString();
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(Tool.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
