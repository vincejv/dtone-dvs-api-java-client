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
public class PartyIdentifier {

  @JsonProperty(value = "mobile_number")
  private String mobileNumber;

  @JsonProperty(value = "account_number")
  private String accountNumber;

  @JsonProperty(value = "account_qualifier")
  private String accountQualifier;

  public PartyIdentifier(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public PartyIdentifier(String mobileNumber, String accountNumber) {
    this.mobileNumber = mobileNumber;
    this.accountNumber = accountNumber;
  }

}
