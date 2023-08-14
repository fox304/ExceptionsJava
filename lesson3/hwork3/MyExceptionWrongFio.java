package lesson3.hwork3;

public class MyExceptionWrongFio extends RuntimeException{

    public MyExceptionWrongFio(String s,String fio) {
        this("\""+s+"\" " + "- это  неверный формат "+" в "
                + fio);
    }

    public MyExceptionWrongFio(String message) {
        super(message);
    }
}
