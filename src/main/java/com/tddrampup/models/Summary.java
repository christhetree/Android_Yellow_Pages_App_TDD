package com.tddrampup.models;

/**
 * Created by WX009-PC on 2/19/14.
 */
import com.google.gson.annotations.Expose;

public class Summary {

    @Expose
    private String what;
    @Expose
    private String where;
    @Expose
    private Integer firstListing;
    @Expose
    private Integer lastListing;
    @Expose
    private Integer totalListings;
    @Expose
    private Integer pageCount;
    @Expose
    private Integer currentPage;
    @Expose
    private Integer listingsPerPage;
    @Expose
    private String Prov;

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public Integer getFirstListing() {
        return firstListing;
    }

    public void setFirstListing(Integer firstListing) {
        this.firstListing = firstListing;
    }

    public Integer getLastListing() {
        return lastListing;
    }

    public void setLastListing(Integer lastListing) {
        this.lastListing = lastListing;
    }

    public Integer getTotalListings() {
        return totalListings;
    }

    public void setTotalListings(Integer totalListings) {
        this.totalListings = totalListings;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getListingsPerPage() {
        return listingsPerPage;
    }

    public void setListingsPerPage(Integer listingsPerPage) {
        this.listingsPerPage = listingsPerPage;
    }

    public String getProv() {
        return Prov;
    }

    public void setProv(String Prov) {
        this.Prov = Prov;
    }

}
