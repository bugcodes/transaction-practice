package bugcodes.exception;

/**
 * @author bugcoder
 * @date 18/11/8
 */
public abstract class BugCoderException extends RuntimeException{

    private String code;

    private String message;

    public BugCoderException() {
    }

    public BugCoderException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
