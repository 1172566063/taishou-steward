package com.zkl.taishou.common.PO;

import com.zkl.taishou.common.constants.CalculateType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName:
 * @Author ：lishixiang
 * @Date：2020/5/14-14:24
 * @Version:
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
public class CalculateResultPO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long resultType;

    private String resultName;

    private Map<String,Double> map;

    public CalculateResultPO(CalculateType calculateType){
        this.resultType = new Long(calculateType.getType());
        this.resultName = calculateType.getName();
        this.map = new ConcurrentHashMap<String,Double>();
    }

    public CalculateResultPO(){
        this.map = new ConcurrentHashMap<String,Double>();
    }
}
