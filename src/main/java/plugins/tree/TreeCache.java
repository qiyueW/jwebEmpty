package plugins.tree;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wo
 */
public class TreeCache {

	private static final Map<Class<?>, TreeField> TREE_CACHE = new HashMap<>();

    public static TreeField getTreeField(final Class<?> c, final String id, final String pid, final String name) {
        TreeField tf = TREE_CACHE.get(c);
        if (null == tf) {
            tf = new TreeField(c, id, pid, name);
            TREE_CACHE.put(c, tf);
        }
        return tf;
    }
}
