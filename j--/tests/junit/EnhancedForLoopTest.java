// Copyright 2013 Bill Campbell, Swami Iyer and Bahar Akbal-Delibas

package junit;

import junit.framework.TestCase;
import pass.EnhancedForLoop;

public class EnhancedForLoopTest extends TestCase {

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testEnhancedForLoop() {
        this.assertEquals(25, EnhancedForLoop.times());
        //this.assertEquals(10, EnhancedForLoop.times2());
    }

}
