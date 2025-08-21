package local.mso.app_rest.exception;

public class ExceptionResponseOrigin extends RuntimeException{

    public ExceptionResponseOrigin(String content) {
        super(content);
    }
}
