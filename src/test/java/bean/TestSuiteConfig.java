package bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TestSuiteConfig {

    @JsonProperty(value="WFDTestSuiteTitle")
    private String testSuiteWFDTitle;

    @JsonProperty(value="WFDDescription")
    private String testWFDDescription;

    @JsonProperty(value = "WFDUpdateTestSuiteTitle")
    private String testWFDUpdateTestSuiteTitle;

    @JsonProperty(value="WFCTestSuiteTitle")
    private String testSuiteWFCTitle;

    @JsonProperty(value="WFCDescription")
    private String testWFCDescription;

    @JsonProperty(value = "WFCUpdateTestSuiteTitle")
    private String testWFCUpdateTestSuiteTitle;

}
