package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class updatePetServiceResponse {

    @JsonProperty("code")
    private int code;

    @JsonProperty("type")
    private String type;

    @JsonProperty("message")
    private String message;

    public void setcode(int id) {
        this.code = id;
    }
    public int getcode() {
        return this.code;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return this.type;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return this.message;
    }
}
