package lesson2.hwork;

// Разработайте программу, которая выбросит Exception,
//  когда пользователь вводит пустую строку.
//  Пользователю должно показаться сообщение,
//  что пустые строки вводить нельзя.

import java.util.Scanner;

public class Foure {
    public static void doNotEmptyString() {
        System.out.println("Делайте что хотите , только не нажимайте ввод!!!");
        Scanner scanner;
        scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            String str = scanner.nextLine();
            if (str.equals("")) {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    System.out.println("Не раздражайте меня сударь, введите хоть что-нибудь!");
                }
            } else flag = false;

        }
        System.out.println("Good job!!!");

    }

    public static void main(String[] args) {
        doNotEmptyString();

    }
}
