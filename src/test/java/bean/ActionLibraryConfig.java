package bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ActionLibraryConfig {

    @JsonProperty(value = "Label")
    private String acLabel;
    @JsonProperty(value = "Description")
    private String acDescription;
    @JsonProperty(value = "Prefix")
    private String acPrefix;
    @JsonProperty(value = "Suffix")
    private String acSuffix;
    @JsonProperty(value = "DisplayKey")
    private String acDisplayKey;
    @JsonProperty(value = "UpdatedLabel")
    private String acUpdatedLabel;
    @JsonProperty(value = "UpdatedDescription")
    private String acUpdatedDescription;
    @JsonProperty(value = "ColumnType")
    private String acColumnType;
}
