package bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PersonaConfig {

    @JsonProperty(value="label")
    private String personaLabel;

    @JsonProperty(value="Description")
    private String personaDescription;

    @JsonProperty(value="ActivityProfile")
    private String personaActProfile;

    @JsonProperty(value="AdjustmentRule")
    private String personaAdjRule;

    @JsonProperty(value="CategoryProfile")
    private String personaCatProfile;

    @JsonProperty(value="EditLabel")
    private String personaEditLabel;

}
