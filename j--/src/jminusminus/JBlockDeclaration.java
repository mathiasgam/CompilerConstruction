// Copyright 2011 Bill Campbell, Swami Iyer and Bahar Akbal-Delibas

package jminusminus;

import java.util.ArrayList;
import static jminusminus.CLConstants.*;

/**
 * The AST node for a method declaration.
 */

class JBlockDeclaration
        extends JAST implements JMember {

    /** Method modifiers. */
    protected ArrayList<String> mods;

    /** Method body. */
    protected JBlock body;

    /** Is method static. */
    protected boolean isStatic;


    /**
     * Construct an AST node for a method declaration given the
     * line number, method name, return type, formal parameters,
     * and the method body.
     *
     * @param line
     *                line in which the method declaration occurs
     *                in the source file.
     * @param mods
     *                modifiers.
     * @param name
     *                method name.
     * @param returnType
     *                return type.
     * @param params
     *                the formal parameters.
     * @param body
     *                method body.
     */

    public JBlockDeclaration(int line, ArrayList<String> mods, JBlock body)

    {
        super(line);
        this.mods = mods;
        this.body = body;
        this.isStatic = mods.contains("static");
    }

    /**
     * Declare this method in the parent (class) context.
     *
     * @param context
     *                the parent (class) context.
     * @param partial
     *                the code emitter (basically an abstraction
     *                for producing the partial class).
     */


    public void writeToStdOut(PrettyPrinter p) {
        p.printf("<JBlockDeclaration line=\"%d\">\n", line());
        p.indentRight();
        if (mods != null) {
            p.println("<Modifiers>");
            p.indentRight();
            for (String mod : mods) {
                p.printf("<Modifier name=\"%s\"/>\n", mod);
            }
            p.indentLeft();
            p.println("</Modifiers>");
        }
        if (body != null) {
            p.println("<Body>");
            p.indentRight();
            body.writeToStdOut(p);
            p.indentLeft();
            p.println("</Body>");
        }
        p.indentLeft();
        p.println("</JBlockDeclaration>");
    }

    public JAST analyze(Context context) {}

    public void codegen(CLEmitter output){}
}
