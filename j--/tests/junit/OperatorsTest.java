package junit;

import junit.framework.TestCase;
import pass.Operators;

public class OperatorsTest extends TestCase {
    private Operators operators;

    protected void setUp() throws Exception {
        super.setUp();
        operators = new Operators();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testOperators() {
        // interger test
        this.assertEquals(10, operators.addInt(8,2));
        this.assertEquals(6, operators.subInt(8,2));
        this.assertEquals(16, operators.mulInt(8,2));
        this.assertEquals(4, operators.divInt(8,2));
        this.assertEquals(0, operators.remInt(8,2));

        this.assertEquals(10, operators.assignAddInt(8,2));
        this.assertEquals(6, operators.assignSubInt(8,2));
        this.assertEquals(16, operators.assignMulInt(8,2));
        this.assertEquals(4, operators.assignDivInt(8,2));
        this.assertEquals(0, operators.assignRemInt(8,2));

        // increment and decrement test
        this.assertEquals(6, operators.postIncInt(5));
        this.assertEquals(4, operators.postDecInt(5));
        this.assertEquals(7, operators.preIncInt(5));
        this.assertEquals(3, operators.preDecInt(5));

        // Double test
        this.assertEquals(10.0d, operators.addDouble(8.0d, 2.0f));
        this.assertEquals(6.0d, operators.subDouble(8.0d, 2.0f));
        this.assertEquals(16.0d, operators.mulDouble(8.0d, 2.0f));
        this.assertEquals(4.0d, operators.divDouble(8.0d, 2.0f));
        this.assertEquals(0.0d, operators.remDouble(8.0d, 2.0f));
    }
}