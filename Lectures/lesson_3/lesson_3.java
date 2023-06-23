package Lectures.lesson_3;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class lesson_3 {
    
    /* Продвинутая работа с исключениями в Java 

        Урок 3
            try-with-resources, обработка исключений выше по стеку,
            собственные типы исключений

        Блок try-with-resources
        При использовании внешних для JVM ресурсов, таких как файлы,
        сетевые соединения, соединения с базами данных и прочие,
        требуется обязательно закрывать их в блоке finally. Это связано с
        тем, что если приложение аварийно завершит свою работу, JVM сама
        почистит используемую память и освободит все свои служебные
        файлы. Но если ваше приложение получило доступ к сетевым
        соединениям, файлам или соединениям с базами данных, все эти
        ресурсы будут внешними для JVM, и она никак на них не сможет
        повлиять. Поэтому вы обязательно должны их освобождать, иначе всё
        заблокируете.

        При работе с внешними ресурсами в коде старайтесь использовать
        try-with-resources. Это гарантирует, что вы не забудете закрыть ресурс в
        блоке finally, и значительно уменьшит количество кода.
    */

    public static void main(String[] args) {
        tryWithResources();
    }


    /**
     * Блок try-with-resources
     */
    static void tryWithResources() {
        
        try (FileReader reader = new FileReader("/Users/sergey/учеба/Programming_exceptions/Programming_exceptions_and_thei_handling/Lectures/TestFile");
             FileWriter writer = new FileWriter("test")) {
            while (reader.ready()){
                writer.write(reader.read());
            }
        } catch (RuntimeException | IOException e) {
            System.out.println("Перехвачено исключение: " + e.getClass().getSimpleName());
        } 
        System.out.println("Copy successfully");
    }



    /* Обработка исключений выше по стеку 
    
        throws позволяет не обрабатывать checked
        исключение в методе, а пробросить его
        методу, который вызвал наш метод.



        В том случае, если на уровне метода нельзя
        корректно его обработать.

        Если можете корректно обработать, то используйте
        try-catch.

    */


    /* Создание нового типа исключений
        Требования:
        ➔ Создать новый класс
        ➔ Унаследовать его от существующего типа исключения
        ➔ Будет ли созданное исключение Checked или Unchecked зависит от типа родителя 
    */


}
