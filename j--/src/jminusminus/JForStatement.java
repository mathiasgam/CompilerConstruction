// Copyright 2013 Bill Campbell, Swami Iyer and Bahar Akbal-Delibas

package jminusminus;

import static jminusminus.CLConstants.*;

/**
 * The AST node for a while-statement.
 */

class JForStatement extends JStatement {

    /** Initialization expression. */
    private JStatement init;

    /** Termination expression. */
    private JExpression term;

    /** Increment expression. */
    private JStatement inc;

    /** The body. */
    private JStatement body;

    /**
     * Construct an AST node for a while-statement given its line number, the
     * test expression, and the body.
     *
     * @param line
     *            line in which the while-statement occurs in the source file.
     * @param condition
     *            test expression.
     * @param body
     *            the body.
     */

    public JForStatement(int line, JStatement init, JExpression term, JStatement inc, JStatement body) {
        super(line);
        this.init = init;
        this.term = term;
        this.inc = inc;
        this.body = body;
    }

    /**
     * Analysis involves analyzing the test, checking its type and analyzing the
     * body statement.
     *
     * @param context
     *            context in which names are resolved.
     * @return the analyzed (and possibly rewritten) AST subtree.
     */

    public JForStatement analyze(Context context) {

        return this;
    }

    /**
     * Generate code for the for loop.
     *
     * @param output
     *            the code emitter (basically an abstraction for producing the
     *            .class file).
     */

    public void codegen(CLEmitter output) {

    }

    /**
     * @inheritDoc
     */

    public void writeToStdOut(PrettyPrinter p) {
        p.printf("<JForStatement line=\"%d\">\n", line());
        p.indentRight();
        p.printf("<InitExpression>\n");
        p.indentRight();
        if(init != null)
            init.writeToStdOut(p);
        p.indentLeft();
        p.printf("</InitExpression>\n");
        p.printf("<TermExpression>\n");
        p.indentRight();
        if(term != null)
            term.writeToStdOut(p);
        p.indentLeft();
        p.printf("</TermExpression>\n");
        p.printf("<IncExpression>\n");
        p.indentRight();
        if(inc != null)
            inc.writeToStdOut(p);
        p.indentLeft();
        p.printf("</IncExpression>\n");
        p.printf("<Body>\n");
        p.indentRight();
        body.writeToStdOut(p);
        p.indentLeft();
        p.printf("</Body>\n");
        p.indentLeft();
        p.printf("</JForStatement>\n");
    }

}
