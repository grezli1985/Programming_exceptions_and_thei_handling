package Lectures;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class lesson_2 {
    
    public static void main(String[] args) {
    
        /* Типы исключений и их описание */

        /*      Тип исключения                       Описание
            - ArithmeticException                 Арифметическая ошибка

            - ArrayIndexOutOfВoundsException      Выход индекса за пределы массива

            - ClassCastException                  Неверное приведение типов

            - IllegalArgumentException            Употребление недопустимого аргумента 
                                                при вызове метода

            - IndexOutOfВoundsException           Выход индекса некоторого типа за
                                                допустимые пределы

            - NullPointerException                Обращение к несуществующему объекту

            - NumberFormatException               Неверное преобразование символьной
                                                строки в числовой формат

            - IOException                         Ошибка при работе с потоками ввода/вывода

            - FileNotFoundException               Файл не найден

            - ClassNotFoundException              Класс не найден

            - UnsupportedOperationException       Попытка выполнения нереализованного метода 
        */
    
        // emptyObject();          //Вызываем исключение NullPointerException
        // ClassTypeOther();       //Вызываем исключение ClassCastException
        // stringToNumber();          //Вызываем NumberFormatException
        // listEmpty();           //Вызываем UnsupportedOperationException

        // interceptionProcessing();   /* несколько отдельных исключений 
        //                             "ArithmeticException", "NullPointerException", "Exception" */
        
        readFile();          // Чтение файла, и finally
    }


    /*
        Создаём объект со значением "ничего нет" обращаемся к объекту 
        и хотим узнать длину массива
        NullPointerException - это исключения, возникающие при попытке 
        использовать ссылку, которая не указывает ни на какое место в памяти (null)
    */
    static void emptyObject() {
        String name = null;
        System.out.println(name.length());
    }


    /*
        Преобразуем объект типа string к объекту типа file 
        ClassCastException - это исключение, которое может возникнуть 
        при попытке неправильного преобразования класса из одного типа в другой.
    */
    static void ClassTypeOther() {
        Object object = new String("123");
        File file = (File) object;
        System.out.println(file);
    }


    /*
        Попытка преобразовать строку к числу, вызов исключения 
         1. Создаём строку с числом 
         2. Пытаемся преобразовать её в число 
        NumberFormatException - неверное преобразование строки в числовой формат.
     */
    static void stringToNumber() {
        String number = "123fq";
        int result = Integer.parseInt(number);
        System.out.println(result);
    }

    /*
        Пытаемся добавить в недобовляемый список данные 
         1. Создаём не добовляемый список 
         2. Добавляем в список 
        UnsupportedOperationException - указанной операции не существует
    */
    static void listEmpty() {
        List<Object> emptyList = Collections.emptyList();
        emptyList.add(new Object());
    }


    /* Иерархия исключений */
    /* смотри рисунок - "Programming_exceptions_and_thei_handling/Lectures/Иерархия исключений.png" */
    
    /*  
        1. Exception — это ошибка, которую можно «на лету» перехватит и исправить.
        2. Error — это критическая (непоправимая) ошибка, которую невозможно
        обработать, и которая приведёт к завершению работы  
    */
    /*  Checked исключения. 
        Класс Exception и его подклассы —
        исключения, которые вы обязаны обработать в
        вашем коде. Если этого не сделать, будет ошибка
        на этапе компиляции.

        Unchecked исключения. 
        Класс RuntimeException и его
        подклассы — исключения, охватывающие такие
        ситуации, как деление на ноль или ошибочная
        индексация массивов.  

            ✔ Их можно обрабатывать, если есть
            вероятность возникновения.

            ✔ А можно и не обрабатывать, поскольку
            предполагается, что при правильном
            поведении программы такие
            исключения вовсе не должны
            возникать.
    */

    /*  
        Как бороться с OutOfMemoryError
        Продумывать код так, чтобы:
            ● объекты не могли заполнить кучу,
            ● либо заранее увеличить её максимальный размер.  
    */


    /* Применяем try-catch */

    /* 
        ●   try — попытка выполнить код, в котором потенциально может 
            возникнуть исключение
        ●   catch — перехват исключения указанного типа (или его наследника) 
            с целью обработать возникшую ошибочную ситуацию 
    */

    /* 
        Используем try-catch, поиск ошибки и перехват try - сюда вставляем 
        код в котором возможна потенциальная ошибка catch - тут происходит 
        перехват исключения с целью обработки 
            1. Если, разделить на ноль, то перехватим ошибку и вернём "номер" 
               не обновится и вернёт = 1, то есть продолжим работу, 
               без падения программы. 
            2. Если, ошибки в try нет, то catch не исполняется, пропускается. 
            3. И будет ловить следующую ошибку в файл = null -> файл.length() 
            4. Следующая ошибка в add emptyList и если для неё не прописан 
               конкретный перехват, то можно поставить перехват уровнем выше, 
               то есть Exception. 
            5. Уровень выше всегда должен стоять ниже, уровня ниже.
    */
    static void interceptionProcessing() {
        int number = 1;
        try {
            number = 10 / 1;  // 10 / 0;
            String test = null;
            // System.out.println(test.length());
            Collections.emptyList().add(new Object());
        } catch (ArithmeticException e) {
            System.out.println("Делить на ноль нельзя!!!");
        } catch (NullPointerException е) {
            System.out.println("Файла не существует!!!");
        } catch (Exception e) {
            System.out.println("Все исключения!!!");
        }
        System.out.println(number);
    }
     
    /* 
        Исключения разного типа требуют разной реакции

        Если вы хотите в своей программе передать файл по сети, могут возникнуть
        два или больше исключений:
            1. FileNotFoundException — файл по указанному пути не найден.
            2. IOException — сетевое соединение разорвалось. 
    */




    /*
        Исключение при чтении файла 
          1. Возможность записи нескольких исключений в один catch 
          2. finally - даже если произошло исключение, 
             всё равно продолжаем выполнять
    */
    static void readFile() {
        FileReader test = null;
        try {
            test = new FileReader("/Users/sergey/учеба/Programming_exceptions/Programming_exceptions_and_thei_handling/Lectures/TestFile");
            // test.read();
        } catch (RuntimeException | IOException e) {
            System.out.println("Перехвачено исключение: " + e.getClass().getSimpleName());
        } finally {
            System.out.println("finally start");
            if (test != null) {
                try {
                    test.close();
                } catch (IOException e) {
                    System.out.println("Исключение при закрытии");
                }
            }
        System.out.println("finally finish");
        }
    }
}
