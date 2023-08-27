package com.dtone.dvs.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Party {

	@JsonProperty(value = "last_name")
	private String lastName;

	@JsonProperty(value = "first_name")
	private String firstName;

	@JsonProperty(value = "middle_name")
	private String middleName;

  @JsonProperty(value = "nationality_country_iso_code")
  private String nationalityCountryIsoCode;

  @JsonProperty(value = "mobile_number")
  private String mobileNumber;

  @JsonProperty(value = "email")
  private String email;

  @JsonProperty(value = "address_text")
  private String addressText;

  @JsonProperty(value = "address_city")
  private String addressCity;

  @JsonProperty(value = "address_country_iso_code")
  private String addressCountryIsoCode;

  @JsonProperty(value = "address_postal_code")
  private String addressPostalCode;

}
