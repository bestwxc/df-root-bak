package net.df.base.server;

import net.df.base.constants.ErrorNo;

/**
 * 结果
 */
public class Result {
    private int errorNo = ErrorNo.SUCCESS;
    private String errorInfo = "success";
    private Object result;
    private boolean isPage = false;

    public void setErrorNo(int errorNo) {
        this.errorNo = errorNo;
    }

    public int getErrorNo() {
        return errorNo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Object getResult() {
        return result;
    }
}
