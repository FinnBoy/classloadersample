package com.awaken.classloadersample;

import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

public class MockUp {

    public static final int NUMBER = 1;

    public static final String LITERALS = "number";

    /**
     * priority: <br>
     * 1st part: class loading<br>
     * 1st load: static field, sequentially
     */
    public static int digit = 2;

    public static String word = "digit";

    /**
     * priority: <br>
     * 2nd part: object constructing<br>
     * 1st exec: fields initialize, sequentially
     */
    public int precision = 4;

    public final int decimal = 3;

    public String character = "precision";

    public final String string;// = "decimal";

    /**
     * priority: <br>
     * 1st part: class loading<br>
     * 2nd load: static block, sequentially
     */
    static {
        digit = 10;
        word = "message";
        System.out.println("static block");
    }

    /**
     * priority: <br>
     * 2nd part: object constructing<br>
     * 2nd exec: instance block, sequentially
     */ //
    {
        this.precision = 321;
        this.character = "information";
        System.out.println("instance block");
    }

    /**
     * priority: <br>
     * 2nd part: object constructing<br>
     * 3rd exec: constructor method
     */
    public MockUp() {
        this.string = NUMBER + LITERALS + this.decimal;
    }

    /**
     * show environment.
     */
    public void environment() {

        Map<String, String> env = System.getenv();

        Properties properties = System.getProperties();

        String jrehome = properties.getProperty("java.home");
        String classpath = properties.getProperty("java.class.path");
        String extDirs = properties.getProperty("java.ext.dirs");

        System.out.println(jrehome);
        System.out.println("************* classpath *************");
        Arrays.stream(classpath.split(":")).forEach(o -> {
            System.out.println(o);
        });

        System.out.println("************* ext dirs *************");
        Arrays.stream(extDirs.split(":")).forEach(o -> {
            System.out.println(o);
        });

    }
}
