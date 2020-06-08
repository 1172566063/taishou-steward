package com.taishou.console.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 基础查询query
 *
 * @author Lishixiang
 */
@Data
@ApiModel("PageParam")
@Accessors(chain = true)
public class PageParam<T> implements Serializable {

    private static final long serialVersionUID = -1L;

    /**
     * 默认显示数量为10条
     */
    @JsonIgnore
    public static final int DEFAULT_PAGE_SIZE = 10;

    /**
     * 默认页数为第一页
     */
    @JsonIgnore
    public static final int DEFAULT_PAGE_NUMBER = 1;

    /**
     * 每页显示的数量
     */
    @ApiModelProperty("每页显示的数量")
    private int pageSize;

    /**
     * 当前页
     */
    @ApiModelProperty("当前页")
    private int pageNumber;

    /**
     * 请求参数
     */
    private T paramData;


    public int getPageSize() {
        return (pageSize < 1 ? DEFAULT_PAGE_SIZE : pageSize);
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize < 1 ? DEFAULT_PAGE_SIZE : pageSize;
    }

    public int getPageNumber() {
        return (pageNumber < 1 ? DEFAULT_PAGE_NUMBER : pageNumber);
    }

    public void setPageNumber(Integer pageNumber) {
        if (pageNumber == null) {
            pageNumber = 1;
        }
        this.pageNumber = pageNumber < 1 ? DEFAULT_PAGE_NUMBER : pageNumber;
    }
}
