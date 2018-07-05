package configuration.mvc;

import configuration.DBO;
import configuration.MsgVO;
import configuration.Tool;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wo
 */
public class BaseService {
// 新增/保存-》审核-》进入流程（提交流程时）-》走后流程后，退出流程-》重新回到审核状态
// 新增/保存-》作废-》反作废-》重新进入-新增/保存状态

    /**
     * 新增状态
     */
    public final static int XINZENG = 0;
    /**
     * 审核状态
     */
    public final static int SHENHE = 1;

    /**
     * 流程状态
     */
    public final static int LIUCHENG = 2;

    /**
     * 锁定状态
     */
    public final static int SUODING = 3;

    /**
     * 作废状态
     */
    public final static int ZUOFEI = 4;

    /**
     * 审核 -只能审核保存状态的单据
     *
     * @param ids 进行审核的单据主键集合
     * @param tableName 操作的数据库表
     * @param idName 字段名：主键
     * @param styleName 字段名：状态
     * @return MsgVO
     */
    public static MsgVO updateStyle_examine(final String ids, final String tableName, final String idName, final String styleName) {
        if (ids == null || ids.length() < 24) {
            return MsgVO.setError();
        }
        int i = DBO.service.ADUS.executeUpdate(iniStyleSQL(ids, tableName, idName, styleName, SHENHE, XINZENG));
        if (i <= - 1) {
            return MsgVO.setError("审核异常。请通知管理查看");
        }
        if (i == 0) {
            return MsgVO.setNotOK("没有可操作的单据");
        }
        if (i > 0) {
            return MsgVO.setOK("审核成功");
        }
        return MsgVO.setError("未知情况");
    }

    /**
     * 反审核-针对审核状态的单据
     *
     * @param ids 进行反审核的单据主键集合
     * @param tableName 操作的数据库表
     * @param idName 字段名：主键
     * @param styleName 字段名：状态
     * @return MsgVO
     */
    public static MsgVO updateStyle_unExamine(final String ids, final String tableName, final String idName, final String styleName) {
        if (ids == null || ids.length() < 24) {
            return MsgVO.setError();
        }
        int i = DBO.service.ADUS.executeUpdate(iniStyleSQL(ids, tableName, idName, styleName, XINZENG, SHENHE));
        if (i <= - 1) {
            return MsgVO.setError("反审核异常。请通知管理查看");
        }
        if (i == 0) {
            return MsgVO.setNotOK("没有可操作的单据");
        }
        if (i > 0) {
            return MsgVO.setOK("反审核成功");
        }
        return MsgVO.setError("未知情况");
    }

    /**
     * 进入流程状态 -针对审核状态的单据
     *
     * @param ids 进行审核的单据主键集合
     * @param tableName 操作的数据库表
     * @param idName 字段名：主键
     * @param styleName 字段名：状态
     * @return MsgVO
     */
    public static MsgVO updateStyle_process(final String ids, final String tableName, final String idName, final String styleName) {
        if (ids == null || ids.length() < 24) {
            return MsgVO.setError();
        }
        int i = DBO.service.ADUS.executeUpdate(iniStyleSQL(ids, tableName, idName, styleName, LIUCHENG, SHENHE));
        if (i <= - 1) {
            return MsgVO.setError("进入流程异常。请通知管理查看");
        }
        if (i == 0) {
            return MsgVO.setNotOK("没有可操作的单据");
        }
        if (i > 0) {
            return MsgVO.setOK("进入流程成功");
        }
        return MsgVO.setError("未知情况");
    }

    /**
     * 退出流程状态 -只能针对流程状态的单据
     *
     * @param ids 进行审核的单据主键集合
     * @param tableName 操作的数据库表
     * @param idName 字段名：主键
     * @param styleName 字段名：状态
     * @return MsgVO
     */
    public static MsgVO updateStyle_unProcess(final String ids, final String tableName, final String idName, final String styleName) {
        if (ids == null || ids.length() < 24) {
            return MsgVO.setError();
        }
        int i = DBO.service.ADUS.executeUpdate(iniStyleSQL(ids, tableName, idName, styleName, SHENHE, LIUCHENG));
        if (i <= - 1) {
            return MsgVO.setError("进入流程异常。请通知管理查看");
        }
        if (i == 0) {
            return MsgVO.setNotOK("没有可操作的单据");
        }
        if (i > 0) {
            return MsgVO.setOK("进入流程成功");
        }
        return MsgVO.setError("未知情况");
    }

    /**
     * 作废 -只能针对保存状态的单据
     *
     * @param ids 进行审核的单据主键集合
     * @param tableName 操作的数据库表
     * @param idName 字段名：主键
     * @param styleName 字段名：状态
     * @return MsgVO
     */
    public static MsgVO updateStyle_void(final String ids, final String tableName, final String idName, final String styleName) {
        if (ids == null || ids.length() < 24) {
            return MsgVO.setError();
        }
        int i = DBO.service.ADUS.executeUpdate(iniStyleSQL(ids, tableName, idName, styleName, ZUOFEI, XINZENG));
        if (i <= - 1) {
            return MsgVO.setError("作废单据时发生异常。请通知管理查看");
        }
        if (i == 0) {
            return MsgVO.setNotOK("没有可操作的单据");
        }
        if (i > 0) {
            return MsgVO.setOK("作废单据成功");
        }
        return MsgVO.setError("未知情况");
    }

    /**
     * 反作废 -只能针对作废状态的单据
     *
     * @param ids 进行审核的单据主键集合
     * @param tableName 操作的数据库表
     * @param idName 字段名：主键
     * @param styleName 字段名：状态
     * @return MsgVO
     */
    public static MsgVO updateStyle_unVoid(final String ids, final String tableName, final String idName, final String styleName) {
        if (ids == null || ids.length() < 24) {
            return MsgVO.setError();
        }
        int i = DBO.service.ADUS.executeUpdate(iniStyleSQL(ids, tableName, idName, styleName, XINZENG, ZUOFEI));
        if (i <= - 1) {
            return MsgVO.setError("反作废单据时发生异常。请通知管理查看");
        }
        if (i == 0) {
            return MsgVO.setNotOK("没有可操作的单据");
        }
        if (i > 0) {
            return MsgVO.setOK("反作废单据成功");
        }
        return MsgVO.setError("未知情况");
    }

    private static String iniStyleSQL(final String ids, String tableName, String idName, String styleName, int setValue, int whereValue) {
        String in = ids.contains(",") ? (" IN('" + ids.replace(",", "','") + "')") : " IN('" + ids + "')";
        StringBuilder sb = new StringBuilder(50);
        sb.append("UPDATE ").append(tableName).append(" SET ")
                .append(styleName).append(" =").append(setValue).append(" WHERE ")//设置状态为1。即审核
                .append(styleName).append("=").append(whereValue).append(" AND ")//必须是状态为XINZENG的单据。即新增状态的单据。
                .append(idName).append(in);
        return sb.toString();
    }

//-------------------隔离标识管理    
	private static final Map<Class<?>, Field> GET_GELIBIAOSHI_FIELD = new HashMap<>();

    private static Field getGelibiaoshiField(final Class<?> c, final String fieldName) {
        Field f = GET_GELIBIAOSHI_FIELD.get(c);
        if (null != f) {
            return f;
        }
        try {
            Field field = c.getDeclaredField(fieldName);
            field.setAccessible(true);
            GET_GELIBIAOSHI_FIELD.put(c, field);
            return field;
        } catch (NoSuchFieldException | SecurityException ex) {
        }
        return null;
    }

    private static String getGelibiaoshiFieldValue(final Object obj, final Field f) {
        try {
            return f.get(obj).toString();
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(BaseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static <T> boolean isErrorGelibiaoshiVast(final Class<T> t, final String idFieldName, final String gelibiaoshiFieldName, final String ids, final String gelibiaoshi) {
        Field f = getGelibiaoshiField(t, gelibiaoshiFieldName);
        List<T> list = DBO.service.S.selectByCondition(t, "WHERE " + idFieldName + " IN(" + Tool.replaceDToDDD(ids) + ")");
        for (T obj : list) {
            if (!getGelibiaoshiFieldValue(obj, f).equals(gelibiaoshi)) {
                return true;
            }
        }
        return false;
    }

    public static <T> boolean isErrorGelibiaoshiVast(List<T> list, final String gelibiaoshiFieldName, final String gelibiaoshi) {
        if (null == list || list.isEmpty()) {
            return false;
        }
        Field f = getGelibiaoshiField(list.get(0).getClass(), gelibiaoshiFieldName);
        for (T obj : list) {
            if (!getGelibiaoshiFieldValue(obj, f).equals(gelibiaoshi)) {
                return true;
            }
        }
        return false;
    }

    public static <T> boolean isErrorGelibiaoshiOne(final Class<T> t, final String idFieldName, final String gelibiaoshiFieldName, final String id, final String gelibiaoshi) {
        Field f = getGelibiaoshiField(t, gelibiaoshiFieldName);
        T obj = DBO.service.S.selectOneByID(t, id);
        if (!getGelibiaoshiFieldValue(obj, f).equals(gelibiaoshi)) {
            return true;
        }
        return false;
    }

    public static <T> boolean isErrorGelibiaoshiOne(final T obj, final String gelibiaoshiFieldName, final String gelibiaoshi) {
        Field f = getGelibiaoshiField(obj.getClass(), gelibiaoshiFieldName);
        if (!getGelibiaoshiFieldValue(obj, f).equals(gelibiaoshi)) {
            return true;
        }
        return false;
    }
}
