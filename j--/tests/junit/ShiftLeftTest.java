package junit;

import junit.framework.TestCase;
import pass.ShiftLeft;

public class ShiftLeftTest extends TestCase {
    private ShiftLeft shiftLeft;

    protected void setUp() throws Exception {
        super.setUp();
        shiftLeft = new ShiftLeft();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testDivide() {
        this.assertEquals(shiftLeft.shift_left(0,42), 0);
        this.assertEquals(shiftLeft.shift_left(42,1), 42);
        this.assertEquals(shiftLeft.shift_left(127,3), 42);
    }
}