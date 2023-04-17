package DZ;

import java.util.InputMismatchException;
import java.util.Scanner;

public class dz_2 {

    public static void main(String[] args) {

        task1(); // Задание 1

        // task2(); // Задание 2

        // task3(); // Задание 3

        // task4(); // Задание 4

    }

    /* 
        Задание 1
            Реализуйте метод, который запрашивает у пользователя ввод 
            дробного числа (типа float), и возвращает введенное значение. 
            Ввод текста вместо числа не должно приводить к падению приложения, 
            вместо этого, необходимо повторно запросить у пользователя ввод данных.
    */

    public static float task1() {
        try {
            System.out.println("\nВведите дробное число через запятую: ");
            Scanner scan = new Scanner(System.in);
            float num = scan.nextFloat();
            System.out.println("Вы ввели:\n" + (num));
            return num;
        } catch (InputMismatchException e) {
            System.out.println("Неверный ввод!");
            task1();
        }
        return 0;
    }
    



    /* Задание 2
            Если необходимо, исправьте данный код 

        
            try {
                int d = 0;
                double catchedRes1 = intArray[8] / d;
                System.out.println("catchedRes1 = " + catchedRes1);
            } catch (ArithmeticException e) {
                System.out.println("Catching exception: " + e);
            } 
    */

    public static void task2() {
        try {
            int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }

    /* Задание 3
            Дан следующий код, исправьте его там, где требуется 


        public static void main(String[] args) throws Exception {
            try {
                int a = 90;
                int b = 3;
                System.out.println(a / b);
                printSum(23, 234);
                int[] abc = { 1, 2 };
                abc[3] = 9;
            } catch (Throwable ex) {
                System.out.println("Что-то пошло не так...");
            } catch (NullPointerException ex) {
                System.out.println("Указатель не может указывать на null!");
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Массив выходит за пределы своего размера!");
            }
        }
        public static void printSum(Integer a, Integer b) throws FileNotFoundException {
            System.out.println(a + b);
        } 
    */

    public static void task3() {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } catch (NullPointerException e) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Exception e) {
            System.out.println("Что-то пошло не так...");
        }
    }

    public static void printSum(Integer a, Integer b) throws Exception {
        System.out.println(a + b);
    }




    /* Задание 4 
            Разработайте программу, которая выбросит Exception, 
            когда пользователь вводит пустую строку. 
            Пользователю должно показаться сообщение, 
            что пустые строки вводить нельзя. 
    */

    public static String task4() {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        if(str.isEmpty())
          throw new IllegalArgumentException("Пустые строки вводить нельзя!");
        else
          System.out.println(str);
        return str;
      }
    
}
