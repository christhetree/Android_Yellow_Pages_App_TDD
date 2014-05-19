package com.tddrampup.models;

import com.google.gson.annotations.Expose;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

/**
 * Created by WX009-PC on 2/21/14.
 */
@Generated("com.googlecode.jsonschema2pojo")
public class Keywords {

    @Expose
    private List<String> OpenHrs = new ArrayList<String>();
    @Expose
    private List<String> LangSpk = new ArrayList<String>();
    @Expose
    private List<String> ProdServ = new ArrayList<String>();
    @Expose
    private List<String> Special = new ArrayList<String>();
    @Expose
    private List<String> BrndCrrd = new ArrayList<String>();

    public List<String> getOpenHrs() {
        return OpenHrs;
    }

    public void setOpenHrs(List<String> OpenHrs) {
        this.OpenHrs = OpenHrs;
    }

    public List<String> getLangSpk() {
        return LangSpk;
    }

    public void setLangSpk(List<String> LangSpk) {
        this.LangSpk = LangSpk;
    }

    public List<String> getProdServ() {
        return ProdServ;
    }

    public void setProdServ(List<String> ProdServ) {
        this.ProdServ = ProdServ;
    }

    public List<String> getSpecial() {
        return Special;
    }

    public void setSpecial(List<String> Special) {
        this.Special = Special;
    }

    public List<String> getBrndCrrd() {
        return BrndCrrd;
    }

    public void setBrndCrrd(List<String> BrndCrrd) {
        this.BrndCrrd = BrndCrrd;
    }

}