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
public class Rates {

	@JsonProperty(value = "base")
	private Double base;

	@JsonProperty(value = "wholesale")
	private Double wholesale;

	@JsonProperty(value = "retail", required = false)
	private Double retail;
}
