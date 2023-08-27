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
public class Promotion {

	@JsonProperty(value = "id")
	private Long id;

	@JsonProperty(value = "title")
	private String title;
	
	@JsonProperty(value = "description")
	private String description;
	
	@JsonProperty(value = "terms")
	private String terms;
	
	@JsonProperty(value = "start_date")
	private String startDate;
	
	@JsonProperty(value = "end_date")
	private String endDate;
	
	@JsonProperty(value = "operator")
	private Operator operator;
	
	@JsonProperty(value = "products")
	private List<Product> products;
}
