package bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ScenarioConfig {

            @JsonProperty(value="FolderName")
            private String folderName;
            @JsonProperty(value="ParentFolderName")
            private String parentFolder;
            @JsonProperty(value="TestScenario")
            private String testScenario;
            @JsonProperty(value="ChildFolder1")
            private String childFolder1;
            @JsonProperty(value="ChildFolder2")
            private String childFolder2;
            @JsonProperty(value="GivenAction")
            private String givenAction;
            @JsonProperty(value="Age")
            private String age;
            @JsonProperty(value="WhenAction")
            private String whenAction;
            @JsonProperty(value="Integration")
            private String integration;
            @JsonProperty(value="Name")
            private String name;
            @JsonProperty(value="Value")
            private String value;
            @JsonProperty(value="ThenAction")
            private String thenAction;
}
