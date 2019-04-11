// Copyright 2013 Bill Campbell, Swami Iyer and Bahar Akbal-Delibas

package jminusminus;

import static jminusminus.CLConstants.*;

/**
 * The AST node for a while-statement.
 */

class JEnhancedForStatement extends JStatement {

    private JFormalParameter item;
    private String collection;

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

    public JEnhancedForStatement(int line, JFormalParameter item, String collection, JStatement body) {
        super(line);
        this.item = item;
        this.collection = collection;
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

    public JEnhancedForStatement analyze(Context context) {

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
        p.printf("<JEnhancedForStatement line=\"%d\">\n", line());
        p.indentRight();
        p.printf("<ItemVariable>\n");
        p.indentRight();
        item.writeToStdOut(p);
        p.indentLeft();
        p.printf("</ItemVariable>\n");
        p.printf("<Collection>\n");
        p.indentRight();
        p.printf(collection + "\n");
        p.indentLeft();
        p.printf("</Collection>\n");
        p.printf("<Body>\n");
        p.indentRight();
        body.writeToStdOut(p);
        p.indentLeft();
        p.printf("</Body>\n");
        p.indentLeft();
        p.printf("</JEnhancedForStatement>\n");
    }

}
