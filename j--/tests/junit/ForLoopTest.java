// Copyright 2013 Bill Campbell, Swami Iyer and Bahar Akbal-Delibas

package junit;

import junit.framework.TestCase;
import pass.ForLoop;

public class ForLoopTest extends TestCase {

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testForLoop() {
        this.assertEquals("bb", ForLoop.times(2,'b'));
        this.assertEquals("bbbbbbbbbb", ForLoop.noInc(10, 'b'));
        this.assertEquals("aaa", ForLoop.noInit(3, 'a'));
        this.assertEquals("cccccc", ForLoop.noBody(6, 'c'));
    }

}
