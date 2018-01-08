package com.awaken.classloadersample;

import java.net.URL;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws Exception {

        URL main = Thread.currentThread().getContextClassLoader().getResource("");

        MockUpClassLoader mockUpClassLoader = new MockUpClassLoader(new URL[]{main});

        Class threadClass = mockUpClassLoader.loadClass("java.lang.Thread");
        threadClass.getConstructor();
        Thread thread = new Thread(() -> {
            /*
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            Class mockUpClazz = null;
            Class mockUpBuilderClazz = null;
            try {
                mockUpClazz = classLoader.loadClass("com.awaken.classloadersample.MockUp");
                mockUpBuilderClazz = classLoader.loadClass("com.awaken.classloadersample.MockUpBuilder");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                MockUp mockUp = (MockUp) mockUpClazz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }*/
            MockUp mockUp = new MockUpBuilder().create();
            mockUp.environment();
        }, "mock-up");

        thread.setContextClassLoader(mockUpClassLoader);

        thread.start();
    }
}
