package com.atguigu.pojo;

import java.util.List;

/**
 * @author AOA
 * @version 1.0
 * @description: TODO
 * @date 2022/4/26 7:03
 */

public class Page<T> {
    public static final Integer PAGE_SIZE = 4;

    //当前页码
    private Integer pageNum;
    //总页码
    private Integer pageTotal;
    //当前页容量
    private Integer pageSiza = PAGE_SIZE;
    //总记录数
    private Integer pageTotalCount;
    //数据
    private List<T> items;
    //請求數據路徑
    private String url;

    public Integer getPageNum() {
        return pageNum;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSiza() {
        return pageSiza;
    }

    public void setPageSiza(Integer pageSiza) {
        this.pageSiza = pageSiza;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNum=" + pageNum +
                ", pageTotal=" + pageTotal +
                ", pageSiza=" + pageSiza +
                ", pageTotalCount=" + pageTotalCount +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }
}
