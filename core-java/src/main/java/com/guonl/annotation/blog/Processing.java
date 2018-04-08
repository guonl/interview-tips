package com.guonl.annotation.blog;

import java.lang.reflect.Field;

/**
 * Created by guonl
 * Description: 一个保存的方法，仿dao.save()
 */
public class Processing {
    public String save(Object cl) throws IllegalArgumentException, IllegalAccessException, NumException {
        String sql = "insert into ";
        if (cl != null) {
            Field[] fiels = cl.getClass().getDeclaredFields();//获得反射对象集合  返回 Field 对象的一个数组，这些对象反映此 Class 对象所表示的类或接口所声明的所有字段。
            boolean t = cl.getClass().isAnnotationPresent(Table.class);//获得类是否有注解 如果指定类型的注释存在于此元素上，则返回 true，否则返回 false。
            if (t) {
                Table tab = cl.getClass().getAnnotation(Table.class);// 如果存在该元素的指定类型的注释，则返回这些注释，否则返回 null。
                sql += tab.name();//获得表名
                String name = "";//记录字段名
                String value = "";//记录值名称
                boolean bl = false;//记录主键是否为空
                for (Field fl : fiels) {//循环组装
                    fl.setAccessible(true);//开启支持私有变量的访问权限
                    Object tobj = fl.get(cl);//返回指定对象上此 Field 表示的字段的值。
                    if (tobj != null) {
                        if (fl.isAnnotationPresent(Key.class)) {//判断是否存在主键
                            bl = true;
                        }
                        if (!fl.isAnnotationPresent(notRecord.class)) {
                            name += fl.getName() + ",";
                            value += "'" + tobj.toString() + "',";
                        }
                    }
                }
                if (bl) {
                    if (name.length() > 0)
                        name = name.substring(0, name.length() - 1);
                    if (value.length() > 0)
                        value = value.substring(0, value.length() - 1);
                    sql += "(" + name + ") values(" + value + ")";
                } else
                    throw new NumException("未找到类主键 主键不能为空");
            } else
                throw new NumException("传入对象不是实体类");
        } else
            throw new NumException("传入对象不能为空");//抛出异常
        return sql;
    }
}
