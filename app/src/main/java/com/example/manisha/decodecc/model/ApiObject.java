package com.example.manisha.decodecc.model;

import com.google.gson.annotations.SerializedName;

public class ApiObject {

    @SerializedName("candidateName")
    private String title;

    @SerializedName("partyName")
    private String description;

    @SerializedName("partySymbolUrl")
    private String symbolUrl;

    @SerializedName("candidateUrl")
    private String canUrl;

    @SerializedName("affidavitUrl")
    private String affidevit;

    public String getAffidevit() {
        return affidevit;
    }

    public void setAffidevit(String affidevit) {
        this.affidevit = affidevit;
    }

    public ApiObject(String title, String description, String symbolUrl, String canUrl, String affidevit) {

        this.title = title;
        this.description = description;
        this.symbolUrl = symbolUrl;
        this.canUrl = canUrl;
        this.affidevit = affidevit;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSymbolUrl() {
        return symbolUrl;
    }

    public void setSymbolUrl(String symbolUrl) {
        this.symbolUrl = symbolUrl;
    }

    public String getCanUrl() {
        return canUrl;
    }

    public void setCanUrl(String canUrl) {
        this.canUrl = canUrl;
    }

    public ApiObject(String title, String description, String symbolUrl, String canUrl) {

        this.title = title;
        this.description = description;
        this.symbolUrl = symbolUrl;
        this.canUrl = canUrl;
    }
}
