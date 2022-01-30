package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class petResponse {

    @JsonProperty("id")
    private BigInteger id;

    @JsonProperty("category")
    private pojo.category category;
    @JsonProperty("name")
    private String name;
    @JsonProperty("photoUrls")
    private List<String> photoUrls=new ArrayList<>();
    @JsonProperty("tags")
    private pojo.tags[] tags;
    @JsonProperty("status")
    private String status;


    public void setID(BigInteger id) {
        this.id = id;
    }
    public BigInteger getID() {
      return this.id;
    }

    public void setcategory(pojo.category cat) {
        this.category = cat;
    }
    public pojo.category getcategory() {
        return this.category;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void setphotoUrls(List<String> url) {
        this.photoUrls=url;
    }
    public List<String> getphotoUrls() {
        return this.photoUrls;
    }


    public pojo.tags[] gettags() {
        return this.tags;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return this.status;
    }


}
