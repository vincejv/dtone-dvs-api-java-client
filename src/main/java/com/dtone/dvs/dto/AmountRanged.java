package com.dtone.dvs.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class AmountRanged {

  @JsonProperty(value = "min")
  private Double min;

  @JsonProperty(value = "max")
  private Double max;

  @JsonProperty(value = "increment", required = false)
  private Double increment;

}