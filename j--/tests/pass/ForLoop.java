// Copyright 2013 Bill Campbell, Swami Iyer and Bahar Akbal-Delibas

package pass;

import java.lang.System;

public class ForLoop {

    public static String times(int n, char c){
        String result = "";
        for (int i = 0; i < n; ++i){
            result += c;
        }
        return result;
    }

    public static String noInc(int n, char c){
        String result = "";
        for (int i = 0; i <= n-1;){
            result += c;
            ++i;
        }
        return result;
    }

    public static String noInit(int n, char c){
        String result = "";
        int i = 0;
        for (; i <= n-1; ++i){
            result += c;
        }
        return result;
    }

    public static String noBody(int n, char c){
        String result = "";
        int i = 0;
        for (; i <= n-1; ++i){
        }

        for (int j = 0; j <= i-1; ++j){
            result += c;
        }

        return result;
    }


    public static void main(String[] args) {
    }


}
