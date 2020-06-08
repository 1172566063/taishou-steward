package com.taishou.console.common.entity;

import com.github.pagehelper.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @ClassName:
 * @Author ：lishixiang
 * @Date：2020/6/4-10:09
 * @Version:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class PageInfo<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty("当前页数")
    private int pageNum;
    @ApiModelProperty("分页大小")
    private int pageSize;
    @ApiModelProperty("页数")
    private int pages;
    @ApiModelProperty("数据")
    private List<T> list;

    public PageInfo(List<T> list) {
        if (list instanceof Page) {
            Page page = (Page)list;
            this.pageNum = page.getPageNum();
            this.pageSize = page.getPageSize();
            this.pages = page.getPages();
            this.list = page;

        } else if (list instanceof Collection) {
            this.pageNum = 1;
            this.pageSize = list.size();
            this.pages = this.pageSize > 0 ? 1 : 0;
            this.list = list;
        }

    }
}
