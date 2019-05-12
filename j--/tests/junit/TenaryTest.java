package junit;

import junit.framework.TestCase;
import pass.TenaryConditional;

public class TenaryTest extends TestCase {
    private TenaryConditional tenary;

    protected void setUp() throws Exception {
        super.setUp();
        tenary = new TenaryConditional();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testTenaryConditional() {
        this.assertEquals(tenary.tenaryConditional(true, 42,63), 42);
        this.assertEquals(tenary.tenaryConditional(false, 42,63), 63);
    }
}