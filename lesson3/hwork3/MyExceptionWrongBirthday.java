package lesson3.hwork3;

public class MyExceptionWrongBirthday extends IllegalArgumentException{
    public MyExceptionWrongBirthday(String s) {
        super(s);
    }
}
