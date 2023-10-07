package com.alvesguilherme.fastapi.utils;

public class URLUtils {

    private String url;

    public URLUtils(String url) {
        this.url = url;
    }

    public URLUtils addPath(String path){
        if(!url.endsWith("/")){
            url = url + "/";
        }
        url = url + path;
        return this;
    }

    public String build(){
        return this.url;
    }
}
