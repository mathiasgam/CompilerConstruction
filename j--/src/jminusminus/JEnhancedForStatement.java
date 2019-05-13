// Copyright 2013 Bill Campbell, Swami Iyer and Bahar Akbal-Delibas

package jminusminus;

import static jminusminus.CLConstants.*;
import java.util.ArrayList;

/**
 * The AST node for a while-statement.
 */

class JEnhancedForStatement extends JStatement {

    private JFormalParameter item;
    private JExpression collection;


    /** The body. */
    private JStatement body;

    /** The generated loop structure*/
    private JVariableDeclaration forInit;
    private JStatement forBody;
    private JExpression forCondition;



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

    public JEnhancedForStatement(int line, JFormalParameter item, JExpression collection, JStatement body) {
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
        LocalContext lcon = new LocalContext(context);
        item = (JFormalParameter) item.analyze(lcon);
        collection = (JExpression) collection.analyze(lcon);

        if (collection.type().isArray()){
            item.type().mustMatchExpected(line, collection.type().componentType());

            //Index variable;
            ArrayList<JVariableDeclarator> forParams = new ArrayList<>();
            String randomName = "random_name";
            JVariable indexVar = new JVariable(line, randomName);
            forParams.add(new JVariableDeclarator(line, indexVar.name(), Type.INT, new JLiteralInt(line, "0")));
            this.forInit = new JVariableDeclaration(line, null, forParams);

            // Create variable loader
            ArrayList<JVariableDeclarator> blockParams = new ArrayList<>();
            JVariable arrayVar = new JVariable(line, item.name());
            blockParams.add(new JVariableDeclarator(line, item.name(), item.type(), new JArrayExpression(line, collection, indexVar)));

            ArrayList<JStatement> statements = new ArrayList<JStatement>();
            statements.add(new JVariableDeclaration(line, null, blockParams));
            statements.add(this.body);

            JExpression incExpr = new JPreIncrementOp(line, indexVar);
            incExpr.isStatementExpression = true;
            statements.add(new JStatementExpression(line, incExpr));

            this.forBody = new JBlock(line, statements);

            //Set condition
            this.forCondition = new JLessThanOp(line, indexVar, new JFieldSelection(line, collection, "length"));

        }else{
            JAST.compilationUnit.reportSemanticError(line,
                    "Collection must be of type Array: \"%s\"", collection.type().toString());
        }

        forInit = (JVariableDeclaration) forInit.analyze(lcon);
        forCondition = (JExpression) forCondition.analyze(lcon);
        forBody = (JStatement) forBody.analyze(lcon);

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
        // Need two labels
        String test = output.createLabel();
        String end = output.createLabel();

        forInit.codegen(output);

        output.addLabel(test);
        forCondition.codegen(output, end, false);

        forBody.codegen(output);

        // Unconditional jump back up to test
        output.addBranchInstruction(GOTO, test);

        // The label below and outside the loop
        output.addLabel(end);

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
        p.printf("<Collection type=\"%s\">\n", collection.type());
        p.indentRight();
        collection.writeToStdOut(p);
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
