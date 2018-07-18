package net.df.base.exception;

/**
 * 业务异常，带有特定意义的错误号
 */
public class BusinessException extends BaseException{
    private int errorNo;
    protected BusinessException(){
        super();
    }
    public BusinessException(int errorNo, String message, Throwable cause){
        super(message, cause);
        this.errorNo = errorNo;
    }
    public BusinessException(int errorNo, String message){
        this(errorNo, message, null);
    }

    public int getErrorNo() {
        return errorNo;
    }
}
