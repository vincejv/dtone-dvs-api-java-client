package com.dtone.dvs.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
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
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(callSuper = true)
public class TransactionRequest extends ApiRequest {

	@JsonProperty(value = "external_id")
	private String externalId;

	@JsonProperty(value = "product_id")
	private Long productId;

	@JsonProperty(value = "calculation_mode")
	private CalculationMode calculationMode;

	@JsonProperty(value = "source")
	private Source source;

	@JsonProperty(value = "destination")
	private Source destination;

	@JsonProperty(value = "auto_confirm")
	private Boolean autoConfirm;

	@JsonProperty(value = "sender")
	private Party sender;

	@JsonProperty(value = "beneficiary")
	private Party beneficiary;

	@JsonProperty(value = "debit_party_identifier")
	private PartyIdentifier debitPartyIdentifier;

	@JsonProperty(value = "credit_party_identifier")
	private PartyIdentifier creditPartyIdentifier;

	@JsonProperty(value = "callback_url")
	private String callbackUrl;
}
