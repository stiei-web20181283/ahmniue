package com.ahmniue.generator.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class Test implements Serializable {
    private Integer column1;

    private Integer column2;

    private static final long serialVersionUID = 1L;

    public Integer getColumn1() {
        return column1;
    }

    public void setColumn1(Integer column1) {
        this.column1 = column1;
    }

    public Integer getColumn2() {
        return column2;
    }

    public void setColumn2(Integer column2) {
        this.column2 = column2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", column1=").append(column1);
        sb.append(", column2=").append(column2);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}