package com.taishou.console.common.utils;

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

    public EntityTransform(V v, Class<E> eClass){
        this.v=v;
        try {
            this.e=eClass.newInstance();
        }catch (Exception e){
            this.e=null;
        }
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
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        return e;
    }

    public static <V,E> EntityTransform<V,E> Build(V v,Class<E> eClass){
        return new EntityTransform<>(v,eClass);
    }

}
