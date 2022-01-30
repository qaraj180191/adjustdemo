package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class petRequest {

    @JsonProperty("id")
    private BigInteger id;

    @JsonProperty("category")
    private pojo.category category;
    @JsonProperty("name")
    private String name;
    @JsonProperty("photoUrls")
    private List<String> photoUrls=new ArrayList<>();
    @JsonProperty("tags")
    private List<pojo.tags> tags=new ArrayList<>();;
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

    public void settags(pojo.tags tags) {
        this.tags.add(tags);
    }
    public List<pojo.tags> gettags() {
        return this.tags;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return this.status;
    }


}
