package configuration;

import com.alibaba.fastjson.JSON;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wo
 */
final public class Tool {

    /**
     * 将字段串a,b,c 变成 字段串 'a','b','c'
     *
     * @param s 默认值为null或空，默认返回''
     * @return String
     */
    public static final String replaceDToDDD(String s) {
        if (null == s || s.isEmpty()) {
            return "''";
        } else if (s.contains("'")) {
            return s;
        }
        return "'" + s.replace(",", "','") + "'";
    }

    /**
     * 将对象转成json格式的字符串
     *
     * @param <T>
     * @param list 对象集合
     * @return String
     */
    public static <T> String entityToJSON(List<T> list) {
        if (null == list || list.isEmpty()) {
            return "[]";
        }
        Class t = list.get(0).getClass();
        String str = list.get(0).toString();
        if (str.startsWith("{")) {//表示覆盖toString方法的entity/bean/vo
            StringBuilder sb = new StringBuilder();
            sb.append("[").append(str);
            for (int i = 1; i < list.size(); i++) {
                sb.append(",").append(list.get(i).toString());
            }
            sb.append("]");
            return sb.toString();
        }

        return JSON.toJSONString(list);
    }

    public static String dateToString(final Date date, final String format) {
        if (null == date) {
            return "";
        }
        SimpleDateFormat sf = new SimpleDateFormat(format);
        return sf.format(date);
    }

    public static boolean isNumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static <T> String doListDataToTreeData(List<T> list, String id, String pid, String name) {
        List<T> topList = new ArrayList<>();
        Class c = list.get(0).getClass();
        Field fid = null, fpid = null, fname = null;
        Field[] fs = c.getDeclaredFields();
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
        String mpid, mid, mname;
        for (T t : list) {
            mpid = getFieldValue(fpid, t);
            if (null == mpid || mpid.isEmpty() || mpid.equals("0")) {
                topList.add(t);//表示顶层。
            }
        }
        for (T son : topList) {

        }
        return "";
    }

    public static String getFieldValue(Field f, Object obj) {
        try {
            return f.get(obj).toString();
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(Tool.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
