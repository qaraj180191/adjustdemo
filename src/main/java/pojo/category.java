package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class category {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    public void setID(int id) {
        this.id = id;
    }
    public int getID() {
        return this.id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}
