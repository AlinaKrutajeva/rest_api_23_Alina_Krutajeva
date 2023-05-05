package rest_api_23_Alina_Krutajeva.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Task {
    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private String id;
}
