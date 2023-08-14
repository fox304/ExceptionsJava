package lesson3.hwork3;

public class MyExceptionWrongPhone extends IllegalArgumentException{
    public MyExceptionWrongPhone(String message) {
        super(message);
    }
}
