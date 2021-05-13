package bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ContactConfig {

	@JsonProperty(value ="Forename")
	private String fornameField;

	@JsonProperty(value ="Surname")
	private String surnameField;

	@JsonProperty(value ="Email")
	private String emailField;

	@JsonProperty(value ="Telephone")
	private String telephoneField;

	@JsonProperty(value ="Message")
	private String messageField;
	

	@JsonProperty(value ="ErrorTelephone")
	private String errorTelephoneField;

	@JsonProperty(value ="ErrorEmail")
	private String errorEmailMailField;

	
}
