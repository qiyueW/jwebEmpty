package plugins.tree;

import java.lang.reflect.Field;

/**
 *
 * @author wo
 */
public class TreeField {

    private Field idField;
    private Field pidField;
    private Field nameField;
    public final Field[] fields;

    public TreeField(Class<?> c, String id, String pid, String name){
        this.fields = c.getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            if (f.getName().equals(id)) {
                this.idField = f;
            } else if (f.getName().equals(pid)) {
                this.pidField = f;
            } else if (f.getName().equals(name)) {
                this.nameField = f;
            }
        }
    }

    public String getName(Object obj) {
        try {
            return nameField.get(obj).toString();
        } catch (IllegalArgumentException | IllegalAccessException ex) {
        }
        return null;
    }

    public String getPID(Object obj) {
        try {
            return pidField.get(obj).toString();
        } catch (IllegalArgumentException | IllegalAccessException ex) {
        }
        return null;
    }

    public String getID(Object obj) {
        try {
            return idField.get(obj).toString();
        } catch (IllegalArgumentException | IllegalAccessException ex) {
        }
        return null;
    }
}
