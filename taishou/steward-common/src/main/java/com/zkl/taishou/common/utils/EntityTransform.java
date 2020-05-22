package com.zkl.taishou.common.utils;

import java.lang.reflect.Field;

/**
 * @ClassName: 实体类之间转换(需要赋值的对象字段名必须一样)
 * @Author ：lishixiang
 * @Date：2020/5/22-15:35
 * @Version:
 */
public class EntityTransform<V,E> {

    private V v;
    private E e;

    public EntityTransform(V v,E e){
        this.v=v;
        this.e=e;
    }

    public E toEntity(){
        try {
            Class<?> vClass = v.getClass();
            Class<?> eClass = e.getClass();
            Field[] declaredFields = vClass.getDeclaredFields();
            for(Field field:declaredFields){
                field.setAccessible(true);
                String name = field.getName();

                if(name.trim().equals("serialVersionUID")){
                    continue;
                }

                Object value = field.get(v);
                Field declaredField = eClass.getDeclaredField(name);
                declaredField.setAccessible(true);
                declaredField.set(e,value);
            }
        }catch (Exception eex){
            return null;
        }
        return e;
    }

    public static <V,E> EntityTransform<V,E> Build(V v,E e){
        return new EntityTransform<>(v,e);
    }

}
