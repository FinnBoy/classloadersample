package com.awaken;

public class Mockup {

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
    }

    /**
     * priority: <br>
     * 2nd part: object constructing<br>
     * 2nd exec: instance block, sequentially
     */ //
    {
        this.precision = 321;
        this.character = "information";
    }

    /**
     * priority: <br>
     * 2nd part: object constructing<br>
     * 3rd exec: constructor method
     */
    public Mockup() {
        this.string = NUMBER + LITERALS + this.decimal;
    }

}
