/*
1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4,
при подаче массива другого размера необходимо бросить исключение MyArraySizeException.
2. Далее метод должен пройтись по всем элементам массива, преобразовать в int, и просуммировать.
Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
должно быть брошено исключение MyArrayDataException, с детализацией в какой именно ячейке лежат неверные данные.
3. В методе main() вызвать полученный метод, обработать возможные исключения
MyArraySizeException и MyArrayDataException и вывести результат расчета
(сумму элементов, при условии что подали на вход корректный массив).
 */

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        // для теста исключения по размеру
        String[][] arr = {{"5","7","3","4"}, {"7","0","z"}, {"8","1","h"}};

        // для теста исключения по типу данных
//        String[][] arr = {{"5","7","3","4"}, {"7","0","1","5"}, {"8","1","h","1"}, {"5","7","3","4"}};

        // для теста отработки без исключений
//        String[][] arr = {{"5","7","3","4"}, {"7","0","1","5"}, {"8","1","2","1"}, {"5","7","3","4"}};

        // для теста исключения по размеру (null)
//        String[][] arr = null;

        try {
            int a = sumTwoDimArray(arr);
            System.out.printf("Сумма элементов массива = %d", a);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public static int maxSecondDimCheck(String[][] arr){
        int maxLen = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length > maxLen){
                maxLen = arr[i].length;
            }
        }
        return maxLen;
    }

    public static int sumTwoDimArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;

        try {
            if (arr.length != 4 || maxSecondDimCheck(arr) != 4){
                throw new MyArraySizeException("Размер входного массива некорректен. Оба измерения должны быть равны 4.");
            }
        } catch (NullPointerException e){
            throw new MyArraySizeException("На вход не передан массив.", e);
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum+=Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e){
                    String message = "Значение в ячейке [" +
                            (i + 1) + "]" + "[" + (j + 1) + "]" +
                            " не является числом";
                    throw new MyArrayDataException(message, e);
                }
            }
        }

        return sum;
    }
}