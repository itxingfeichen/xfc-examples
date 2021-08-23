package com.github.xfc.classloader;

public class ClassLoaderTree {

    public static void main(String[] args) { 
        ClassLoader loader = ClassLoaderTree.class.getClassLoader();
        while (loader != null) {
            System.out.println(loader.toString());
            loader = loader.getParent();
        }

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        while (classLoader != null) {
            System.out.println(classLoader.toString());
            classLoader = classLoader.getParent();
        }

        // sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(ClassLoader.getSystemClassLoader());

    }
 }