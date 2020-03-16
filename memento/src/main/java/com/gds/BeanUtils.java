package com.gds;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhanglifeng
 * @since 2020-03-13 18:33
 */
public class BeanUtils {

    /**
     * 把Bean的所有属性放入map
     * @param bean 任意javaBean
     * @return map
     */
    public static Map<String, Object> backupProp(Object bean) {
        Map<String, Object> result = new HashMap<>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            // 获得所有属性描述
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            // 遍历所有属性
            for (PropertyDescriptor des : propertyDescriptors) {
                String fieldName = des.getName();
                Method getter = des.getReadMethod();
                Object fieldValue = getter.invoke(bean);
                result.put(fieldName, fieldValue);
            }
        } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 把map的值返回到bean中
     * @param bean
     * @param propMap
     */
    public static void restoreProp(Object bean, Map<String, Object> propMap) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            for (PropertyDescriptor des : beanInfo.getPropertyDescriptors()) {
                String fieldName = des.getName();
                if (propMap.containsKey(fieldName)) {
                    Method setter = des.getWriteMethod();
                    if (setter != null) {
                        setter.invoke(bean, propMap.get(fieldName));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
