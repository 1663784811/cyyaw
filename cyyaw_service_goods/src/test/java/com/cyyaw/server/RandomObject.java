package com.cyyaw.server;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class RandomObject {

    private RandomObject(){}


//    public static  <T> T crateRandomObject(Class<T> clazz){
//
//        clazz.get
//        BeanWrapper beanWrapper = new BeanWrapperImpl(target);
//        PropertyDescriptor[] propertyDescriptors = beanWrapper.getPropertyDescriptors();
//        Set<String> notNullFieldSet = new HashSet<>();
//        if (propertyDescriptors.length > 0) {
//            for (PropertyDescriptor p : propertyDescriptors) {
//                String name = p.getName();
//                Object value = beanWrapper.getPropertyValue(name);
//                if (Objects.isNull(value)) {
//                    notNullFieldSet.add(name);
//                }
//            }
//        }
//        String[] notNullField = new String[notNullFieldSet.size()];
//        return notNullFieldSet.toArray(notNullField);
//
//
//        return t;
//    }
}
