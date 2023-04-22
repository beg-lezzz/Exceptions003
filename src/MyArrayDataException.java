import java.io.IOException;

public class MyArrayDataException extends IOException {

    public MyArrayDataException(String message) {
        super(message);
    }

    public MyArrayDataException(String message, Exception cause) {
        super(message, cause);
    }
}
