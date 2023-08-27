package com.dtone.dvs.dto;

import java.math.BigDecimal;

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
public class Balance {
	@JsonProperty(value = "id")
	private String id;
	
	@JsonProperty(value = "unit_type")
	private UnitTypes unitType;
	
	@JsonProperty(value = "unit")
	private String unit;
	
	@JsonProperty(value = "available")
	private BigDecimal available;
	
	@JsonProperty(value = "holding")
	private BigDecimal holding;

  @JsonProperty(value = "credit_limit")
  private Double creditLimit;

}
