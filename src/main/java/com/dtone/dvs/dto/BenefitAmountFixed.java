package com.dtone.dvs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BenefitAmountFixed extends Benefit {

  @JsonProperty(value = "base")
  private Double base;

  @JsonProperty(value = "promotion_bonus")
  private Double promotionBonus;

  @JsonProperty(value = "total_excluding_tax")
  private Double totalExcludingTax;

  @JsonProperty(value = "total_including_tax")
  private Double totalIncludingTax;

}
