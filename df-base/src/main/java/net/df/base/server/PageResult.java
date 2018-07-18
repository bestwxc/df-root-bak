package net.df.base.server;

import java.util.List;

/**
 * 分页结果
 */
public class PageResult extends Result {
    private Integer pageNum = 1;
    private Integer pageSize = 50;
    private Integer total = 50;
    private boolean isPage = true;

    public PageResult(){}

    public PageResult(Result result){
        Object object = result.getResult();
        if(object instanceof List){
            List list = (List) object;
            this.setResult(object);
            this.setErrorNo(result.getErrorNo());
            this.setErrorInfo(result.getErrorInfo());
            this.pageSize = list.size();
            this.total = list.size();
        }else{
            throw new IllegalArgumentException("原Result不是list,无法构造pageResult");
        }
    }

    public PageResult(Integer pageNum, Integer pageSize, Integer total){
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotal() {
        return total;
    }
}
