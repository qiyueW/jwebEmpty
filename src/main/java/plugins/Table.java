/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plugins;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wo
 * @param <T>
 */
public class Table<T> {

    private final List<T> list;
    private final Field[] fields;
    private final Map<String, Field> map = new HashMap<>();

    public Table(List<T> list) {
        this.list = list;
        if (null != list && list.size() > 0) {
            fields = list.get(0).getClass().getDeclaredFields();
            for (Field f : fields) {
                f.setAccessible(true);
                map.put(f.getName(), f);
            }
        } else {
            fields = null;
        }
    }

    private Object get(Object obj, String fieldName) {
        try {
            return map.get(fieldName).get(obj);
        } catch (IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean isUnique(String fieldName) {
        Set<Object> s = new HashSet<>();
        for (T dz : list) {
            s.add(this.get(dz, fieldName));
        }
        return s.size() == this.list.size();
    }

    public static void main(String args[]) {
        List<TT> list=new ArrayList<>();
        list.add(new TT());
//        list.add(new TT());
//        list.add(new TT());
//        list.add(new TT());
        
        
        Table<TT> t = new Table<TT>(list);
        System.out.println(t.isUnique("i"));
    }

}

class TT {

    private int i=0;
    private String code="1";

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
