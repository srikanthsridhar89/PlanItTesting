package bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EnvironmentConfig {

    @JsonProperty(value = "Username")
    private String userName;

    @JsonProperty(value = "Password")
    private String password;

    @JsonProperty(value = "URL")
    private String url;

    @JsonProperty(value = "Browser")
    private String browser;

    @JsonProperty(value = "RemoteMachine")
    private String remoteMachine;

}
