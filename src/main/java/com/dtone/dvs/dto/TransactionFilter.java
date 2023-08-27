package com.dtone.dvs.dto;

import java.util.HashMap;
import java.util.Map;

import com.dtone.dvs.util.Constants;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class TransactionFilter {

  private String externalId;

  private String productType;

  private Long serviceId;

  private String countryIsoCode;

  private Long operatorId;

  private Long statusId;

  private String creditPartyMobileNumber;

  private String creditPartyAccountNumber;

  private String fromDate;

  private String toDate;

  public TransactionFilter(String externalId) {
    this.externalId = externalId;
  }

  public Map<String, String> getQueryParameterMap() {
    Map<String, String> queryParameterMap = new HashMap<>();

    if (null != externalId) {
      queryParameterMap.put(Constants.EXTERNAL_ID, externalId);
    }

    if (null != productType) {
      queryParameterMap.put(Constants.PRODUCT_TYPE, productType);
    }

    if (null != serviceId && serviceId > 0L) {
      queryParameterMap.put(Constants.SERVICE_ID, String.valueOf(serviceId));
    }

    if (null != countryIsoCode) {
      queryParameterMap.put(Constants.COUNTRY_ISO_CODE, countryIsoCode);
    }

    if (null != operatorId && operatorId > 0L) {
      queryParameterMap.put(Constants.OPERATOR_ID, String.valueOf(operatorId));
    }

    if (null != statusId && statusId > 0L) {
      queryParameterMap.put(Constants.STATUS_ID, String.valueOf(operatorId));
    }

    if (null != creditPartyMobileNumber) {
      queryParameterMap.put(Constants.CREDIT_PARTY_MOBILE_NUMBER, creditPartyMobileNumber);
    }

    if (null != creditPartyAccountNumber) {
      queryParameterMap.put(Constants.CREDIT_PARTY_ACCOUNT_NUMBER, creditPartyAccountNumber);
    }

    if (null != fromDate) {
      queryParameterMap.put(Constants.FROM_DATE, fromDate);
    }

    if (null != toDate) {
      queryParameterMap.put(Constants.TO_DATE, toDate);
    }

    if (queryParameterMap.isEmpty()) {
      return null;
    }
    return queryParameterMap;

  }
}
