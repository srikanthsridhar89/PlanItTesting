package bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EnvironmentConfig {

  
    @JsonProperty(value = "URL")
    private String url;

    @JsonProperty(value = "Browser")
    private String browser;

  

}
