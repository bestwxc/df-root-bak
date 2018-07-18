package net.df.base.exception;

import net.df.base.constants.ErrorNo;

public class ParamIllegalException extends  BusinessException{
    public ParamIllegalException(String message){
        super(ErrorNo.VALIDATE_FAIL, message);
    }
}
