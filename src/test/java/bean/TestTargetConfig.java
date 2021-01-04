package bean;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class TestTargetConfig {

    @JsonProperty(value = "WFDName")
    private String testTargetWFDName;

    @JsonProperty(value = "WFCName")
    private String testTargetWFCName;

    @JsonProperty(value = "Username")
    private String testTargetUserName;

    @JsonProperty(value = "Password")
    private String testTargetPassword;

    @JsonProperty(value = "WFCUsername")
    private String testTargetWFCUserName;

    @JsonProperty(value = "WFCPassword")
    private String testTargetWFCPassword;

    @JsonProperty(value = "WFDHost")
    private String testTargetWFDHost;

    @JsonProperty(value = "WFCHost")
    private String testTargetWFCHost;

    @JsonProperty(value = "AppKey")
    private String testTargetAppkey;

    @JsonProperty(value = "ClientID")
    private String testTargetClientId;

    @JsonProperty(value = "ClientSecret")
    private String testTargetClientSecret;

    @JsonProperty(value = "SFTPHost")
    private String testTargetSFTPHost;

    @JsonProperty(value = "SFTPUserName")
    private String testTargetSFTPUserName;

    @JsonProperty(value = "SFTPPassword")
    private String testTargetSFTPPassword;

    @JsonProperty(value = "SFTPPort")
    private String testTargetSFTPPort;

    @JsonProperty(value = "PGPPublicKey")
    private String testTargetPGPublicKey;

    @JsonProperty(value = "UpdatedName")
    private String updateTestTargetName;

}
