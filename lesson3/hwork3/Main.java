package lesson3.hwork3;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true){
            System.out.println("если хотите создать файл с данными, то нажмите \"y\"");
            Scanner sc = new Scanner(System.in);
            if(!Objects.equals(sc.nextLine(), "y")) break;
            start();
        }

    }
    public static void start(){

        String [] array;
        String str = request();
        while (count6(str) == -1)  str = request(); // вывод кода ошибки
        array = str.split(" ");
        Parse parse = new Parse(array);

        try {
            parse.fio();
            parse.birthday();
            parse.phone();
            parse.sex();
            createFile(array);
            System.out.println("файл создан или добавлен однофамилец в имеющийся файл");

        }catch (MyExceptionWrongPhone e){
            System.out.println(e+"\nкол-во цифр должно быть 10 и начинаться с 8");

        }catch (MyExceptionWrongFio e){
            System.out.println(e+"\nпринимаются символы только русского или латинского алфавитов");
        }catch (MyExceptionWrongBirthday e){
            System.out.println(e+"\nформат даты рождения должен быть такой(число,месяц,год): 00.00.0000");
        }catch (MyExceptionWrongSex e){
            System.out.println(e+"\nдля указания пола нужна буква \"f\" или \"m\"");
        }catch (IOException e) {
            System.out.println(e+"\nчто-то с файлом");
        }
    }
    public static String request(){
        System.out.println("введите пользовательские данные в нужном формате");

        String string1="Сидоров Петр Сергеевич 12.10.1998 8923930250 m";
        String string2="Сидрова Юлия Сергеевна 10.02.2000 8923492769 f";
        String string3="Петров Максим Евгеньевич 05.06.1990 8923348873 m";
        String string4="Орлов Егор Филипович 02.01.2003 8923954237 m";
        String string5="Орлов Петр Сергеевич 11.06.1995 8457583750 m";
        String string6="Сидоров Петр Сергеевич 2.02.1999 8235834585 m";

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        return str;
    }
    public static int count6(String str){
        String [] arr = str.split(" ");
        if (arr.length != 6) {
            System.out.println("код ошибки -1");
            String sign = arr.length<6 ?"меньше" :"больше";
            System.out.println("вы ввели "+sign+" данных чем нужно");
            System.out.println("попробуйте еще раз ");
            return -1;
        }return arr.length;

    }
    public static void createFile(String []array) throws IOException {
        boolean flag = false;
        File file = new File(array[0]+".txt");
        if(file.exists()) flag = true;

        try (FileWriter wr = new FileWriter(file,flag)){

            String dd = String.join(" ",Arrays.copyOfRange(array, 0, 3));// fio с пробелами
            String kk = String.join(",",Arrays.copyOfRange(array, 3, 6));// остальное с запятыми
            wr.write(dd+","+kk+"\n");
            wr.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
class Parse{
    private static final String [] constant = {"фамилии","имени","отчестве"};
    private final String [] arr;
    public Parse(String[] arr) {
        this.arr = arr;
    }

    /**
     * fio проверяется любыми буквами русского или латинского алфавита
     */
    public void fio(){
        for (int i=0; i<3; i++){
            String st = arr[i];
            if(!st.matches("[а-яА-Яa-zA-Z]+")) {
                throw new MyExceptionWrongFio(st,constant[i]);
            }
            System.out.println();
        }
    }

    /**
     * обработка номера телефона: 10 цифр с первой цифрой восемь
     */
    public void phone(){
        String ph = arr[4];
        if(!ph.matches("8\\d{9}")) {
            throw new MyExceptionWrongPhone("неверный формат при указании fio");
        };
    }

    /**
     * обработка даты дня рождения включает диапазоны с 1900 до 2005 года
     */
    public void birthday(){
        String birth = arr[3];
        String reg = "(0[1-9]|[12][0-9]|3(0|1))\\.(0[1-9]|1[012])\\.((1\\d{3})|200[1-5])";
        if(!birth.matches(reg)) {
            throw new MyExceptionWrongBirthday("неверный формат записи дня рождения");
        }
    }
    public void sex(){
        String s = arr[5];
        if(!s.equals("f") & !s.equals("m")){
            throw new MyExceptionWrongSex("Неверный формат при указании пола");
        }
    }

}
