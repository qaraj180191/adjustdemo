package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetpetByStatusResponce {

    private pojo.petResponse[] pets;

    public pojo.petResponse[] getpest() {
        return this.pets;
    }
}
