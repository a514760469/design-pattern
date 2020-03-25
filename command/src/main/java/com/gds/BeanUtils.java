package com.gds;

import com.gds.linux.command.ls.AbstractLs;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

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

    /**
     * 获取所有子类
     * @param fatherClass 父类型
     * @return 子类Class List
     */
    public static List<Class<?>> getSonClass(Class<?> fatherClass) {
        List<Class<?>> returnClassList = new ArrayList<>();
        String packageName = fatherClass.getPackage().getName();
        // 获取包中所有的类
        List<Class<?>> packClasses = getClasses(packageName);
        // 判断是否是子类
        for (Class<?> c : packClasses) {
            if (fatherClass.isAssignableFrom(c) && !fatherClass.equals(c)) {
                returnClassList.add(c);
            }
        }

        return returnClassList;
    }

    /**
     * 从一个包中查找所有的类，在jar包中不能查找
     * @param packageName
     * @return
     */
    private static List<Class<?>> getClasses(String packageName) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace(".", "/");
        Enumeration<URL> resources;
        List<File> dirs = new ArrayList<>();
        try {
            resources = classLoader.getResources(path);
            while (resources.hasMoreElements()) {
                URL url = resources.nextElement();
                dirs.add(new File(url.getFile()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Class<?>> list = new ArrayList<>();
        for (File dir : dirs) {
            list.addAll(findClasses(dir, packageName));
        }
        return list;
    }


    private static List<Class<?>> findClasses(File directory, String packageName) {
        List<Class<?>> classes = new ArrayList<>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        if (files == null) {
            return classes;
        }
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                try {
                    classes.add(Class.forName(packageName + '.' + file.getName() .substring(0, file.getName().length() - 6)));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

        return classes;
    }


    public static void main(String[] args) {
        getSonClass(AbstractLs.class).forEach(System.out::println);
    }
}
