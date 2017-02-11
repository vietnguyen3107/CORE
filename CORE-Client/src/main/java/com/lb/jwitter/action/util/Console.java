package com.lb.jwitter.action.util;

/**
 * Created by manh on 29/01/2016.
 */
public class Console {
    public static void Log(Object... objs){
        for(Object obj : objs){
            System.out.print(obj);
            System.out.print(" ");
        }
        System.out.println();
    }
}
