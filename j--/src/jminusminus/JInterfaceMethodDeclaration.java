// Copyright 2011 Bill Campbell, Swami Iyer and Bahar Akbal-Delibas

package jminusminus;

import java.util.ArrayList;
import static jminusminus.CLConstants.*;

/**
 * The AST node for a method declaration.
 */

class JInterfaceMethodDeclaration
        extends JAST implements JMember {

    /** Method modifiers. */
    protected ArrayList<String> mods;

    /** Method name. */
    protected String name;

    /** Return type. */
    protected Type returnType;

    /** The formal parameters. */
    protected ArrayList<JFormalParameter> params;

    /** Built in analyze(). */
    protected MethodContext context;

    /** Computed by preAnalyze(). */
    protected String descriptor;

    protected ArrayList<Type> method_throws;

    /** Is method static. */
    protected boolean isStatic;

    /** Is method private. */
    protected boolean isPrivate;

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

    public JInterfaceMethodDeclaration(int line, ArrayList<String> mods,
                              String name, Type returnType,
                              ArrayList<JFormalParameter> params, ArrayList<Type> _throws)

    {
        super(line);
        this.mods = mods;
        this.name = name;
        this.returnType = returnType;
        this.params = params;
        this.method_throws = _throws;
        this.isStatic = mods.contains("static");
        this.isPrivate = mods.contains("private");
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

    public void preAnalyze(Context context, CLEmitter partial) {

    }

    /**
     * Analysis for a method declaration involves (1) creating a
     * new method context (that records the return type; this is
     * used in the analysis of the method body), (2) bumping up
     * the offset (for instance methods), (3) declaring the
     * formal parameters in the method context, and (4) analyzing
     * the method's body.
     *
     * @param context
     *                context in which names are resolved.
     * @return the analyzed (and possibly rewritten) AST subtree.
     */

    public JAST analyze(Context context) {

        return this;
    }

    /**
     * Add this method declaration to the partial class.
     *
     * @param context
     *                the parent (class) context.
     * @param partial
     *                the code emitter (basically an abstraction
     *                for producing the partial class).
     */

    public void partialCodegen(Context context, CLEmitter partial) {

    }

    /**
     * Generate code for the method declaration.
     *
     * @param output
     *                the code emitter (basically an abstraction
     *                for producing the .class file).
     */

    public void codegen(CLEmitter output) {

    }

    /**
     * @inheritDoc
     */

    public void writeToStdOut(PrettyPrinter p) {
        p.printf("<JInterfaceMethodDeclaration line=\"%d\" name=\"%s\" "
                + "returnType=\"%s\">\n", line(), name, returnType
                .toString());
        p.indentRight();
        if (context != null) {
            context.writeToStdOut(p);
        }
        if (mods != null) {
            p.println("<Modifiers>");
            p.indentRight();
            for (String mod : mods) {
                p.printf("<Modifier name=\"%s\"/>\n", mod);
            }
            p.indentLeft();
            p.println("</Modifiers>");
        }
        if (params != null) {
            p.println("<FormalParameters>");
            for (JFormalParameter param : params) {
                p.indentRight();
                param.writeToStdOut(p);
                p.indentLeft();
            }
            p.println("</FormalParameters>");
        }
        if (method_throws != null) {
            p.println("<Throws>");
            p.indentRight();
            for (Type t : method_throws){
                p.printf("<Exception Type = %s>\n", t.toString());
            }
            p.indentLeft();
            p.println("</Throws>");
        }
        p.indentLeft();
        p.println("</JInterfaceMethodDeclaration>");
    }
}
