package com.tddrampup.models;

import com.google.gson.annotations.Expose;

/**
 * Created by WX009-PC on 2/21/14.
 */

public class Phone {

    @Expose
    private String npa;
    @Expose
    private String nxx;
    @Expose
    private String num;
    @Expose
    private String dispNum;
    @Expose
    private String type;

    public String getNpa() {
        return npa;
    }

    public void setNpa(String npa) {
        this.npa = npa;
    }

    public String getNxx() {
        return nxx;
    }

    public void setNxx(String nxx) {
        this.nxx = nxx;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getDispNum() {
        return dispNum;
    }

    public void setDispNum(String dispNum) {
        this.dispNum = dispNum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}