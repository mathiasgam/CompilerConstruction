package pass;
import java.lang.System;

public class Parent {
    {
        System.out.print("PI ");
    }

    static {
        System.out.print("PSI ");
    }

    public Parent(int x){
        System.out.print("PSC ");
    }

    public Parent(){
        this(5);
        System.out.print("PC ");
    }
}

public class Child extends Parent{

    {
        System.out.print("CI ");
    }

    static {
        System.out.print("CSI ");
    }

    public Child(int x){
        System.out.print("CSC ");
    }
    public Child(){
        this(5);
        System.out.print("CC ");
    }
}
