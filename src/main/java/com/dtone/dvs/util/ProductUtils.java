package com.dtone.dvs.util;

import java.util.Arrays;
import java.util.List;

import com.dtone.dvs.dto.ProductType;

public class ProductUtils {

  private static final List<String> fixedProductTypes = Arrays.asList(ProductType.FIXED_VALUE_RECHARGE.toString(),
    ProductType.FIXED_VALUE_PIN_PURCHASE.toString());

  private static final List<String> rangedProductTypes = Arrays.asList(ProductType.RANGED_VALUE_RECHARGE.toString(),
    ProductType.RANGED_VALUE_PIN_PURCHASE.toString(), ProductType.RANGED_VALUE_PAYMENT.toString());

  public static Boolean isFixedType(String productType) {
    return fixedProductTypes.contains(productType);
  }

  public static Boolean isRangedType(String productType) {
    return rangedProductTypes.contains(productType);

  }

  public List<String> getFixedTypes() {
    return fixedProductTypes;
  }

  public List<String> getRangedTypes() {
    return rangedProductTypes;
  }

}