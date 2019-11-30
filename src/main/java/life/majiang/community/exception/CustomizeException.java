package life.majiang.community.exception;

/*
@author mark
@time 2019/11/30
*/
public class CustomizeException extends RuntimeException {
    String message;

    public CustomizeException(ICustomizeErrorCode customizeErrorCode) {
        this.message = customizeErrorCode.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }
}
