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
public class BenefitAmountRanged {

  @JsonProperty(value = "base")
  private AmountRanged base;

  @JsonProperty(value = "promotion_bonus")
  private AmountRanged promotionBonus;

  @JsonProperty(value = "total_excluding_tax")
  private AmountRanged totalExcludingTax;

  @JsonProperty(value = "total_including_tax")
  private AmountRanged totalIncludingTax;

}
