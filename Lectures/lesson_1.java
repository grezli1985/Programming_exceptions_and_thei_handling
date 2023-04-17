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
        //Массив размером 10, а запрос на 1000, для просмотра ошибки в стектрейсе.
        int[] ints = new int[10];
        System.out.println(ints[1000]);
    }

    // public static int divide(int a1, int a2){
    //     if (a2 == 0){
    //         return -1;
    //     }
    //     return a1/a2;
    // }

    //функция деления на ноль
    public static int divide(int a1, int a2){
        //обработчик ошибки деления на ноль
        if (a2 == 0){
            throw new RuntimeException("Divide by zero permited");
        }
        return a1/a2;
    }

    //long-так обозначается размер файла, в функцию передаём объект файл (File file)
    public static long getFileSize(File file) {
        //добавим обработчик ошибки, если файл не существует
        if (!file.exists()){
            return -1L;
        }
        return file.length();
        //по умолчанию у файла уже есть информация о размере length
    }

}