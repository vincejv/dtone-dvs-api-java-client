package com.dtone.dvs.dto;

import java.util.List;

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
public class PinInfo {

  @JsonProperty(value = "usage_info")
  private List<String> usageInfo;

  @JsonProperty(value = "validity")
  private Validity validity;

  @JsonProperty(value = "terms")
  private String terms;

}