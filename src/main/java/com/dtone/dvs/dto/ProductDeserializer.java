package com.dtone.dvs.dto;

import java.io.IOException;
import java.io.Serial;
import java.util.List;

import com.dtone.dvs.util.ProductUtils;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class ProductDeserializer extends StdDeserializer<Product> {

  @Serial
  private static final long serialVersionUID = -3199468069238214488L;
  private static final ObjectMapper mapper = new ObjectMapper();

  public ProductDeserializer() {
    this(null);
  }

  public ProductDeserializer(Class<?> vc) {
    super(vc);
  }

  @Override
  public Product deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
    JsonNode node = jp.getCodec().readTree(jp);
    String type = node.get("type").asText();

    if (null != type && ProductUtils.isFixedType(type)) {
      ProductFixed productFixed = new ProductFixed();

      List<BenefitFixed> benefitsFixedList = mapper.convertValue(node.get("benefits"),
        new TypeReference<List<BenefitFixed>>() {
        });
      productFixed.setBenefits(benefitsFixedList);
      productFixed.setType(type);

      ProductPricesFixed pricesFixed = mapper.convertValue(node.get("prices"),
        new TypeReference<ProductPricesFixed>() {
        });
      productFixed.setPrices(pricesFixed);

      SourceFixed sourceFixed = mapper.convertValue(node.get("source"), new TypeReference<SourceFixed>() {
      });
      productFixed.setSource(sourceFixed);

      SourceFixed destinationFixed = mapper.convertValue(node.get("destination"),
        new TypeReference<SourceFixed>() {
        });
      productFixed.setSource(destinationFixed);

      setCommonProperties(node, productFixed);

      return productFixed;
    } else {
      ProductRanged productRanged = new ProductRanged();

      List<BenefitRanged> benefitsRangedList = mapper.convertValue(node.get("benefits"),
        new TypeReference<List<BenefitRanged>>() {
        });
      productRanged.setBenefits(benefitsRangedList);
      productRanged.setType(type);

      ProductPricesRanged pricesRanged = mapper.convertValue(node.get("prices"),
        new TypeReference<ProductPricesRanged>() {
        });
      productRanged.setPrices(pricesRanged);

      SourceRanged sourceRanged = mapper.convertValue(node.get("source"), new TypeReference<SourceRanged>() {
      });
      productRanged.setSource(sourceRanged);

      SourceRanged destinationRanged = mapper.convertValue(node.get("destination"),
        new TypeReference<SourceRanged>() {
        });
      productRanged.setSource(destinationRanged);

      setCommonProperties(node, productRanged);

      return productRanged;
    }

  }

  private void setCommonProperties(JsonNode node, Product product) {
    Long id = node.get("id").asLong();
    String name = node.get("name").asText();
    String type = node.get("type").asText();
    String description = node.get("description").asText();
    Service service = mapper.convertValue(node.get("service"), new TypeReference<Service>() {
    });
    Operator operator = mapper.convertValue(node.get("operator"), new TypeReference<Operator>() {
    });

    List<Region> regions = mapper.convertValue(node.get("regions"), new TypeReference<List<Region>>() {
    });

    List<List<String>> requiredDebitPartyIdentifierFields = mapper.convertValue(
      node.get("required_debit_party_identifier_fields"), new TypeReference<List<List<String>>>() {
      });

    List<List<String>> requiredCreditPartyIdentifierFields = mapper.convertValue(
      node.get("required_credit_party_identifier_fields"), new TypeReference<List<List<String>>>() {
      });

    List<List<String>> requiredSenderFields = mapper.convertValue(node.get("required_sender_fields"),
      new TypeReference<List<List<String>>>() {
      });

    List<List<String>> requiredBeneficiaryFields = mapper.convertValue(node.get("required_beneficiary_fields"),
      new TypeReference<List<List<String>>>() {
      });

    List<List<String>> requiredStatementIdentifierFields = mapper.convertValue(
      node.get("required_statement_identifier_fields"), new TypeReference<List<List<String>>>() {
      });

    List<String> availabilityZones = mapper.convertValue(node.get("availability_zones"),
      new TypeReference<List<String>>() {
      });

    Rates rates = mapper.convertValue(node.get("rates"), new TypeReference<Rates>() {
    });

    List<Promotion> promotions = mapper.convertValue(node.get("promotions"), new TypeReference<List<Promotion>>() {
    });

    Validity validity = mapper.convertValue(node.get("validity"), new TypeReference<Validity>() {
    });

    PinInfo pin = mapper.convertValue(node.get("pin"), new TypeReference<PinInfo>() {
    });

    product.setId(id);
    product.setName(name);
    product.setType(type);
    product.setDescription(description);
    product.setService(service);
    product.setOperator(operator);
    product.setRegions(regions);
    product.setRequiredDebitPartyIdentifierFields(requiredDebitPartyIdentifierFields);
    product.setRequiredCreditPartyIdentifierFields(requiredCreditPartyIdentifierFields);
    product.setRequiredSenderFields(requiredSenderFields);
    product.setRequiredBeneficiaryFields(requiredBeneficiaryFields);
    product.setRequiredStatementIdentifierFields(requiredStatementIdentifierFields);
    product.setAvailabilityZones(availabilityZones);
    product.setRates(rates);
    product.setPromotions(promotions);
    product.setValidity(validity);
    product.setPin(pin);
  }
}