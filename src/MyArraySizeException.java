import java.io.IOException;

public class MyArraySizeException extends IOException {
    public MyArraySizeException(String message) {
        super(message);
    }

    public MyArraySizeException(String message, Exception e) {
        super(message, e);
    }
}
