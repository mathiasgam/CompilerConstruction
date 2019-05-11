
package junit;
import junit.framework.TestCase;
import pass.Parent;
import pass.Child;

import java.io.*;
import java.lang.System;

public class InitializerBlockTest extends TestCase {

    private final PrintStream originalOut = System.out;

    protected void setUp() throws Exception {
        super.setUp();

    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    // Test is functioning by printing in each block, static block and constructor and then assessing if the output is the expected.
    public void testBlock1() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Parent p = new Parent();

        Child c = new Child();

        originalOut.println(outContent.toString());
        assertEquals("PSI PI PSC PC CSI PI PSC PC CI CSC CC ", outContent.toString());

        System.setOut(originalOut);
    }

}