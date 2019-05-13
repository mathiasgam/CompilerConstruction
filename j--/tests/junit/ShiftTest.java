package junit;

import junit.framework.TestCase;
import pass.Shifts;

public class ShiftTest extends TestCase {
    private Shifts shifts;

    protected void setUp() throws Exception {
        super.setUp();
        shifts = new Shifts();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testShifts() {
        // interger test
        this.assertEquals(128, shifts.leftShiftInt(1,7));
        this.assertEquals(-8, shifts.rightShiftInt(-128,4));
        this.assertEquals(131071, shifts.logicalRightShiftInt(-2,15));
    }
}