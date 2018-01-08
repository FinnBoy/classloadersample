package com.awaken.classloadersample;

import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandlerFactory;

/**
 * Demo
 */
public class MockUpClassLoader extends URLClassLoader {

    public MockUpClassLoader(URL[] urls) {
        super(urls);
    }

    public MockUpClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public MockUpClassLoader(URL[] urls, ClassLoader parent, URLStreamHandlerFactory factory) {
        super(urls, parent, factory);
    }

    /* ------------------------------------------------------------ */
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return loadClass(name, false);
    }

    /* ------------------------------------------------------------ */
    @Override
    protected synchronized Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        System.out.println("this is Mock up ClassLoader.");
        Class<?> c = this.findLoadedClass(name);
        if (c != null) {
            return c;
        }
        c = this.findClass(name);
        if (c != null) {
            return c;
        }
        return super.loadClass(name, resolve);
    }
}
