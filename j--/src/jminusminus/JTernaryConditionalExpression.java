// Copyright 2013 Bill Campbell, Swami Iyer and Bahar Akbal-Delibas

package jminusminus;

import static jminusminus.CLConstants.*;

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
        // Analyse inputs
        conditional = (JExpression) conditional.analyze(context);
        lhs = (JExpression) lhs.analyze(context);
        rhs = (JExpression) rhs.analyze(context);

        // test if the conditioal is a type of boolean
        conditional.type().mustMatchExpected(line(), type.BOOLEAN);
        // check that both lhs and rhs is of the same type
        lhs.type().mustMatchExpected(line(), rhs.type());
        type = lhs.type();

        return this;
    }

    public void codegen(CLEmitter output) {
        String LabelRhs = output.createLabel();
        String LabelEnd = output.createLabel();

        conditional.codegen(output, LabelRhs, false);

        lhs.codegen(output);
        output.addBranchInstruction(GOTO, LabelEnd);
        output.addLabel(LabelRhs);

        rhs.codegen(output);
        output.addLabel(LabelEnd);
    }

    public void writeToStdOut(PrettyPrinter p) {
        p.printf("<JTernaryConditionalExpression line=\"%d\" type=\"%s\">\n", line(), type());
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
