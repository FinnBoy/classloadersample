package com.awaken;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        Mockup mockup = null;

        mockup = new Mockup();

        mockup = new Mockup() {

            /**
             * priority: <br>
             * 2nd part: object constructing<br>
             * last exec: external instance block.
             */ //
            {
                this.character = "anonymous test";
            }
        };

        System.out.println("Hello World!");
    }
}
