package Lectures;

import java.io.File;

public class lesson_1 {

    public static void main(String[] args) {
        // System.out.println(getFileSize(new File("/Users/sergey/учеба/Programming_exceptions/Lectures/TestFile")));
        // System.out.println(divide(-10, 10));

    //    a();
        divide(10, 0);
    }

    public static void a(){
        b();
    }
    
    public static void b(){
        c();
    }

    public static void c(){
        int[] ints = new int[10];
        System.out.println(ints[1000]);
    }

    // public static int divide(int a1, int a2){
    //     if (a2 == 0){
    //         return -1;
    //     }
    //     return a1/a2;
    // }

    public static int divide(int a1, int a2){
        if (a2 == 0){
            throw new RuntimeException("Divide by zero permited");
        }
        return a1/a2;
    }

    public static long getFileSize(File file) {
        if (!file.exists()){
            return -1L;
        }
        return file.length();
    }

}