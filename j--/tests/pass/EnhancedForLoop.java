// Copyright 2013 Bill Campbell, Swami Iyer and Bahar Akbal-Delibas

package pass;

import java.lang.System;
import java.util.LinkedList;

public class EnhancedForLoop {

    public static int times(){
        int[] collection = { 3, 4, 5, 6, 7 };
        int sum = 0;

        for (int i : collection){
            sum += i;
        }

        return sum;
    }
/*
    public static int times2(){
        int sum = 0;

        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(5);
        list.add(2);
        list.add(3);

        for (int i : list){
            sum += i;
        }
        return sum;
    }
*/
    public static void main(String[] args) {
    }


}
