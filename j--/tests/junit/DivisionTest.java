package junit;

import junit.framework.TestCase;
import pass.Division;

public class DivisionTest extends TestCase {
    private Division division;

    protected void setUp() throws Exception {
        super.setUp();
        division = new Division();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testDivide() {
        this.assertEquals(division.divideInt(0,42), 0);
        this.assertEquals(division.divideInt(42,1), 42);
        this.assertEquals(division.divideInt(127,3), 42);
        //this.assertEquals(division.divideDouble(1.2d,1.2d), 1d);
    }
}