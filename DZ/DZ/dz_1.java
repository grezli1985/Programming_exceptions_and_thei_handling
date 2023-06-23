package DZ;

public class dz_1 {

    public static void main(String[] args) {
        // task5();
        task6DZ();
    }


    /*
        Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
        и возвращающий новый массив, каждый элемент которого равен сумме 
        элементов двух входящих массивов в той же ячейке.
        Если длины массивов не равны, необходимо как-то оповестить пользователя.
    */

    static void task5(){

        try {
            int[] res = getSumArray(new int[]{1, -2, 3, 0}, new int[] {4, 3, 1, 0, 1});
            for (int e: res) {
                System.out.printf("%d\t", e);
            }
            System.out.println();
        }
        catch (CustomArraySizeException e){
            System.out.println(e.getMessage());
            System.out.printf("Длина первого массива: %d\nДлина второго массива: %d\n",
                    e.getLength1(), e.getLength2());
        }

    }

    static int[] getSumArray(int[] arr1, int[] arr2){
        if (arr1 == null || arr2 == null)
            throw new NullPointerException("Оба массива должны существовать.");
        if (arr1.length != arr2.length)
            throw new CustomArraySizeException("Кол-во элементов массива должно быть одинаковым.", arr1.length, arr2.length);

        int[] res = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++)
            res[i] = arr1[i] + arr2[i];
        return res;
    }


    /* Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, 
        и возвращающий новый массив, каждый элемент которого равен частному элементов 
        двух входящих массивов в той же ячейке. Если длины массивов не равны, 
        необходимо как-то оповестить пользователя. Важно: При выполнении метода 
        единственное исключение, которое пользователь может 
        увидеть - RuntimeException, т.е. ваше. 
    */


    static void task6DZ(){
        int[] res = getSumArrayV2(new int[]{1, -2, 3, 0}, new int[] {4, 3, 1, 0, 1});
        for (int e: res) {
            System.out.printf("%d\t", e);
        }
        System.out.println();
    }

    static int[] getSumArrayV2(int[] arr1, int[] arr2){
        if (arr1 == null || arr2 == null)
            throw new NullPointerException("Оба массива должны существовать.");
        if (arr1.length != arr2.length)
            throw new RuntimeException(String.format("Кол-во элементов массива должно быть одинаковым.", arr1.length, arr2.length));

        int[] res = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++)
            res[i] = arr1[i] + arr2[i];
        return res;
    }



}



class CustomArraySizeException extends RuntimeException{

    private int length1;
    private int length2;

    public int getLength1() {
        return length1;
    }

    public int getLength2() {
        return length2;
    }

    public CustomArraySizeException(String message, int length1, int length2) {
        super(message);
        this.length1 = length1;
        this.length2 = length2;
    }
}