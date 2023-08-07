package lesson2.hwork;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
 * и возвращает введенное значение.
 * Ввод текста вместо числа не должно приводить к падению приложения,
 * вместо этого, необходимо повторно запросить у пользователя ввод данных.
 * <p>
 * Если необходимо, исправьте данный код
 * (задание 2 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
 */
public class OneTwo {
    public static float onlyFloat(){
        System.out.println("Введите вещественное число");
        Scanner scanner;
        float number;
        while (true) {
            try {
                scanner = new Scanner(System.in);
                number = scanner.nextFloat();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Принимается только дробное или целое число");
                System.out.println("Попробуйте еще раз ");

            }

        }
        return number;
    }

    public static void divByZero(){

        try {
            int d = 0;
//            double catchedRes1 = intArray[8] / d;
            // здесь синтаксическая ошибка , так как массива intArray не существует

            double catchedRes1 = 6.8 / d;   // здесь исключения не будет , т.к.
            //                                 бесконечность доступна для чисел с плавающей запятой

            double catchedRes2 = 6 / d;  // здесь исключение конечно будет , т.к.
            //                              целое число делится на ноль
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }
    public static void main(String[] args) {

        // Задание 1
        System.out.println(onlyFloat());

        // Задание 2
        divByZero();

    }

}
