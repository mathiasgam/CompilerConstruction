// Copyright 2013 Bill Campbell, Swami Iyer and Bahar Akbal-Delibas

package jminusminus;



class JTernaryConditionalExpression extends JExpression {

    /** The expression. */
    JExpression conditional;
    JExpression lhs;
    JExpression rhs;

    public JTernaryConditionalExpression(int line, JExpression conditional, JExpression lhs, JExpression rhs) {
        super(line);
        this.conditional = conditional;
        this.lhs = lhs;
        this.rhs = rhs;
    }


    public JExpression analyze(Context context) {
        return this;
    }

    public void codegen(CLEmitter output) {
    }

    public void writeToStdOut(PrettyPrinter p) {
        p.printf("<JTernaryConditionalExpression line=\"%d\">\n", line());
        p.indentRight();
        p.printf("<conditional>\n");
        p.indentRight();
        conditional.writeToStdOut(p);
        p.indentLeft();
        p.printf("</conditional>\n");
        p.printf("<lhs>\n");
        p.indentRight();
        lhs.writeToStdOut(p);
        p.indentLeft();
        p.printf("</lhs>\n");
        p.printf("<rhs>\n");
        p.indentRight();
        rhs.writeToStdOut(p);
        p.indentLeft();
        p.printf("</rhs>\n");
        p.indentLeft();
        p.printf("</JTernaryConditionalExpression>\n");
    }

}
