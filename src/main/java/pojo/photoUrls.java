package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class photoUrls {

    private List<String> url=new ArrayList<>();


    public void setUrls(String url) {
        this.url.add(url);
    }
    public List<String> getUrls() {
        return this.url;
    }
}
