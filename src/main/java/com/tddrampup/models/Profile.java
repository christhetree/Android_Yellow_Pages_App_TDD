package com.tddrampup.models;

import com.google.gson.annotations.Expose;

/**
 * Created by WX009-PC on 2/21/14.
*/

public class Profile {

    @Expose
    private String lang;
    @Expose
    private Keywords keywords;

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Keywords getKeywords() {
        return keywords;
    }

    public void setKeywords(Keywords keywords) {
        this.keywords = keywords;
    }

}
