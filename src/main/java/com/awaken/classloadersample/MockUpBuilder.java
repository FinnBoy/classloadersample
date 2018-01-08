package com.awaken.classloadersample;

/**
 * build MockUp Object
 */
public class MockUpBuilder {

    public MockUp create() {

        MockUp mockUp = null;

        mockUp = new MockUp();

        mockUp = new MockUp() {

            /**
             * priority: <br>
             * 2nd part: object constructing<br>
             * last exec: external instance block.
             */ //
            {
                this.character = "anonymous test";
            }
        };

        return mockUp;
    }
}
