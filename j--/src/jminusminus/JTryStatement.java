//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package jminusminus;

import java.util.ArrayList;

class JTryStatement extends JStatement {
    private JStatement tryStatement;
    private ArrayList<JFormalParameter> parameters;
    private ArrayList<JStatement> catchStatements;
    private JStatement finallyStatement;


    public JTryStatement(int line, JStatement tryStatement, ArrayList<JFormalParameter> parameters, ArrayList<JStatement> catchStatements, JStatement finallyStatement) {
        super(line);
        this.tryStatement = tryStatement;
        this.parameters = parameters;
        this.catchStatements = catchStatements;
        this.finallyStatement = finallyStatement;
    }

    public JStatement analyze(Context context) {
        return this;
    }

    public void codegen(CLEmitter output) {
        return;
    }

    public void writeToStdOut(PrettyPrinter p) {
        p.printf("<JTryStatement line=\"%d\">\n", line());
        p.indentRight();
        p.printf("<TryStatement>\n");
        p.indentRight();
        tryStatement.writeToStdOut(p);
        p.indentLeft();
        p.printf("</TryStatement>\n");
        if (parameters != null){
            for (int i = 0; i < parameters.size(); i++){
                p.printf("<CatchParameters>\n");
                p.indentRight();
                parameters.get(i).writeToStdOut(p);
                p.indentLeft();
                p.printf("</CatchParameters>\n");
                p.printf("<CatchStatement>\n");
                p.indentRight();
                catchStatements.get(i).writeToStdOut(p);
                p.indentLeft();
                p.printf("</CatchStatement>\n");
            }
        }
        if (finallyStatement != null){
            p.printf("<FinallyStatement>\n");
            p.indentRight();
            finallyStatement.writeToStdOut(p);
            p.indentLeft();
            p.printf("</FinallyStatement>\n");
        }

        p.indentLeft();
        p.printf("</JTryStatement>\n");
    }
}
