package com.jobhunter.employeeform.dao;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SimpleRunner {
    public static void main(String[] args) {
        SimpleRunner sr = new SimpleRunner();
        sr.runTest();
    }

    private void runTest() {
        try {
            Class clazz = Class.forName("com.jobhunter.employeeform.dao.DictionaryDaoImplTest");

            Constructor cst = clazz.getConstructor();
            Object o = cst.newInstance();
            Method[] methods = clazz.getMethods();
            for(Method m : methods) {
                m.getAnnotation(Test.class);
                m.invoke(o);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
