package bugcodes.exception;

/**
 * @author bugcoder
 * @date 18/11/8
 */
public class BusinessException extends BugCoderException{

    public BusinessException() {
    }

    public BusinessException(String code, String message) {
        super(code, message);
    }
}
