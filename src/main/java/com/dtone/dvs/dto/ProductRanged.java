package com.dtone.dvs.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(callSuper = true)
public class ProductRanged extends Product {

  @JsonProperty(value = "benefits")
  private List<BenefitRanged> benefits;

  @JsonProperty(value = "source")
  private SourceRanged source;

  @JsonProperty(value = "destination")
  private SourceRanged destination;

  @JsonProperty(value = "prices")
  private ProductPricesRanged prices;

}