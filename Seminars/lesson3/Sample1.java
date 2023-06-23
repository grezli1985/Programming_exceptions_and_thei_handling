package Seminars.lesson3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Sample1 {

    public static void main(String[] args) {

        /**
         try (Class name = new Class()){
            // Инструкции, работающие с переменной типа Class
         }
         */

        /*try(Printer printer = new Printer()){

        }*/


        try
        {
            testNew("C:\\test\\test.txt");
        }
        catch (MyFileNotFoundException e){
            System.out.printf("%s\nНаименование файла: %s\n", e.getMessage(), e.getFileName());
        }

    }

    static void testNew(String fileName) throws MyFileNotFoundException{

        try (FileReader fileReader = new FileReader(fileName)) {
            char[] buf = new char[256];
            int count;
            while ( (count = fileReader.read(buf)) > 0){
                if (count < 256)
                    buf = Arrays.copyOf(buf, count);
                for (int i = 0; i < buf.length; i++){
                    System.out.print(buf[i]);
                }
            }
        }
        catch (FileNotFoundException e){
            throw new MyFileNotFoundException("Файл не найден.", fileName);
        }
        catch (IOException e){
            System.out.println("Ошибка чтения файла.");
        }
    }

    static void test(String fileName) throws MyFileNotFoundException{

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(fileName);
            char[] buf = new char[256];
            int count;
            while ( (count = fileReader.read(buf)) > 0){
                if (count < 256)
                    buf = Arrays.copyOf(buf, count);
                for (int i = 0; i < buf.length; i++){
                    System.out.print(buf[i]);
                }
            }
            //fileReader.close();
        }
        catch (FileNotFoundException e){
            throw new MyFileNotFoundException("Файл не найден.", fileName);
        }
        catch (IOException e){
            System.out.println("Ошибка чтения файла.");
        }
        finally {
            if (fileReader != null)
                try {
                    fileReader.close();
                }
                catch (IOException e){
                    System.out.println(e.getMessage());
                }
        }

    }

}

class Printer{

}
