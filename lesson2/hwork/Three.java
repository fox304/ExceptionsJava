package lesson2.hwork;
//       Дан следующий код, исправьте его там, где требуется
//      (задание 3 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
public class Three {

    // в блоке try здесь нет checked исключений ,
    // поэтому обязательный выброс исключения в методе
    // printSum удалил

    public static void main(String[] args) {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);

            // если дополнить массив двумя элементами ,
            // а переменной b присвоить ноль ,
            // тогда сработает последний блок catch

            int[] abc = { 1, 2 };
            abc[3] = 9;

            // блок catch с Throwable переместил в конец ,
            // т.к. блоки ниже него просто не обработаются

        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }
    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }

}


