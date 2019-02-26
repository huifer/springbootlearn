package com.lesson13.demo13.entity;

import java.io.Serializable;

/**
 * <p>Title : DoLog </p>
 * <p>Description : </p>
 *
 * @author huifer
 * @date 2019-02-26
 */
public class DoLog implements Serializable {


    private Long id;
    /**
     * asplog value 属性值
     */
    private String aspVal;

    /**
     * 操作的具体类
     */
    private String doClass;
    /**
     * 操作方法
     */
    private String methodName;

    public Object getParams() {
        return params;
    }

    public void setParams(Object params) {
        this.params = params;
    }

    /**
     * 参数
     */
    private Object params;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAspVal() {
        return aspVal;
    }

    public void setAspVal(String aspVal) {
        this.aspVal = aspVal;
    }

    public String getDoClass() {
        return doClass;
    }

    public void setDoClass(String doClass) {
        this.doClass = doClass;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"aspVal\":\"")
                .append(aspVal).append('\"');
        sb.append(",\"doClass\":\"")
                .append(doClass).append('\"');
        sb.append(",\"methodName\":\"")
                .append(methodName).append('\"');
        sb.append(",\"params\":")
                .append(params);
        sb.append('}');
        return sb.toString();
    }
}
