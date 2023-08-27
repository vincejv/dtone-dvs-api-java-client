package com.dtone.dvs.dto;

import java.io.IOException;
import java.util.List;

import com.dtone.dvs.util.ProductUtils;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class TransactionDeserializer extends StdDeserializer<Transaction> {

  private static final long serialVersionUID = -6186626005507523730L;
  private static final ObjectMapper mapper = new ObjectMapper();

  public TransactionDeserializer() {
    this(null);
  }

  public TransactionDeserializer(Class<?> vc) {
    super(vc);
  }

  @Override
  public Transaction deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
    JsonNode node = jp.getCodec().readTree(jp);

    JsonNode productNode = node.get("product");

    if (null == productNode) {
      Transaction transaction = new Transaction();

      setCommonProperties(node, transaction);

      return transaction;
    }

    Product product = mapper.convertValue(productNode, new TypeReference<Product>() {
    });
    String productType = product.getType();

    if (null != productType && ProductUtils.isFixedType(productType)) {
      TransactionFixed transactionFixed = new TransactionFixed();
      JsonNode benefitsNode = node.get("benefits");
      if (null != benefitsNode) {
        List<BenefitFixed> benefitsFixedList = mapper.convertValue(benefitsNode,
          new TypeReference<List<BenefitFixed>>() {
          });
        transactionFixed.setBenefits(benefitsFixedList);
      }

      setCommonProperties(node, transactionFixed);

      return transactionFixed;
    } else if (null != productType && ProductUtils.isRangedType(productType)) {
      TransactionRanged transactionRanged = new TransactionRanged();

      JsonNode benefitsNode = node.get("benefits");
      if (null != benefitsNode) {
        List<BenefitRanged> benefitsRangedList = mapper.convertValue(benefitsNode,
          new TypeReference<List<BenefitRanged>>() {
          });
        transactionRanged.setBenefits(benefitsRangedList);
      }

      setCommonProperties(node, transactionRanged);

      return transactionRanged;
    } else {
      Transaction transaction = new Transaction();

      setCommonProperties(node, transaction);

      return transaction;
    }

  }

  private void setCommonProperties(JsonNode node, Transaction transaction) {
    String externalId = node.get("external_id").asText();
    transaction.setExternalId(externalId);

    JsonNode idNode = node.get("id");
    if (null != idNode) {
      Long id = idNode.asLong();
      transaction.setId(id);
    }

    JsonNode creationDateNode = node.get("creation_date");
    if (null != creationDateNode) {
      String creationDate = creationDateNode.asText();
      transaction.setCreationDate(creationDate);
    }

    JsonNode confirmationExpirationDateNode = node.get("confirmation_expiration_date");
    if (null != confirmationExpirationDateNode) {
      String confirmationExpirationDate = confirmationExpirationDateNode.asText();
      transaction.setConfirmationExpirationDate(confirmationExpirationDate);
    }

    JsonNode confirmationDateNode = node.get("confirmation_date");
    if (null != confirmationDateNode) {
      String confirmationDate = confirmationDateNode.asText();
      transaction.setConfirmationDate(confirmationDate);
    }

    JsonNode statusNode = node.get("status");
    if (null != statusNode) {
      Status status = mapper.convertValue(statusNode, new TypeReference<Status>() {
      });
      transaction.setStatus(status);
    }

    JsonNode operatorReferenceNode = node.get("operator_reference");
    if (null != operatorReferenceNode) {
      String operatorReference = operatorReferenceNode.asText();
      transaction.setOperatorReference(operatorReference);
    }

    JsonNode pinNode = node.get("pin");
    if (null != pinNode) {
      Pin pin = mapper.convertValue(pinNode, new TypeReference<Pin>() {
      });
      transaction.setPin(pin);
    }

    JsonNode productNode = node.get("product");
    if (null != productNode) {
      Product product = mapper.convertValue(productNode, new TypeReference<Product>() {
      });
      transaction.setProduct(product);
    }

    JsonNode pricesNode = node.get("prices");
    if (null != pricesNode) {

      Prices prices = mapper.convertValue(pricesNode, new TypeReference<Prices>() {
      });
      transaction.setPrices(prices);
    }

    JsonNode ratesNode = node.get("rates");
    if (null != ratesNode) {
      Rates rates = mapper.convertValue(ratesNode, new TypeReference<Rates>() {
      });
      transaction.setRates(rates);
    }

    JsonNode promotionsNode = node.get("promotions");
    if (null != promotionsNode) {
      List<Promotion> promotions = mapper.convertValue(promotionsNode, new TypeReference<List<Promotion>>() {
      });
      transaction.setPromotions(promotions);
    }

    JsonNode requestedValuesNode = node.get("requested_values");
    if (null != requestedValuesNode) {
      Values requestedValues = mapper.convertValue(requestedValuesNode, new TypeReference<Values>() {
      });
      transaction.setRequestedValues(requestedValues);
    }

    JsonNode adjustedValuesNode = node.get("adjusted_values");
    if (null != adjustedValuesNode) {
      Values adjustedValues = mapper.convertValue(adjustedValuesNode, new TypeReference<Values>() {
      });
      transaction.setAdjustedValues(adjustedValues);
    }

    JsonNode senderNode = node.get("sender");
    if (null != senderNode) {
      Party sender = mapper.convertValue(senderNode, new TypeReference<Party>() {
      });
      transaction.setSender(sender);
    }

    JsonNode beneficiaryNode = node.get("beneficiary");
    if (null != beneficiaryNode) {
      Party beneficiary = mapper.convertValue(beneficiaryNode, new TypeReference<Party>() {
      });
      transaction.setBeneficiary(beneficiary);
    }

    JsonNode debitPartyIdentifierNode = node.get("debit_party_identifier");
    if (null != debitPartyIdentifierNode) {
      PartyIdentifier debitPartyIdentifier = mapper.convertValue(debitPartyIdentifierNode,
        new TypeReference<PartyIdentifier>() {
        });
      transaction.setDebitPartyIdentifier(debitPartyIdentifier);
    }

    JsonNode creditPartyIdentifierNode = node.get("credit_party_identifier");
    if (null != creditPartyIdentifierNode) {
      PartyIdentifier creditPartyIdentifier = mapper.convertValue(creditPartyIdentifierNode,
        new TypeReference<PartyIdentifier>() {
        });
      transaction.setCreditPartyIdentifier(creditPartyIdentifier);
    }

    JsonNode statementIdentifierNode = node.get("statement_identifier");
    if (null != statementIdentifierNode) {
      StatementIdentifier statementIdentifier = mapper.convertValue(statementIdentifierNode,
        new TypeReference<StatementIdentifier>() {
        });
      transaction.setStatementIdentifier(statementIdentifier);
    }

    JsonNode callbackUrlNode = node.get("callback_url");
    if (null != callbackUrlNode) {
      String callbackUrl = callbackUrlNode.asText();
      transaction.setCallbackUrl(callbackUrl);
    }

  }

}