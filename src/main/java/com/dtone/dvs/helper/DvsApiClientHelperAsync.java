package com.dtone.dvs.helper;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import com.dtone.dvs.dto.ApiResponse;
import com.dtone.dvs.dto.Balance;
import com.dtone.dvs.dto.BalanceFilter;
import com.dtone.dvs.dto.BenefitType;
import com.dtone.dvs.dto.Country;
import com.dtone.dvs.dto.LookupOperatorRequest;
import com.dtone.dvs.dto.Operator;
import com.dtone.dvs.dto.PageAsync;
import com.dtone.dvs.dto.Product;
import com.dtone.dvs.dto.ProductFilter;
import com.dtone.dvs.dto.Promotion;
import com.dtone.dvs.dto.PromotionFilter;
import com.dtone.dvs.dto.Service;
import com.dtone.dvs.dto.Transaction;
import com.dtone.dvs.dto.TransactionFilter;
import com.dtone.dvs.dto.TransactionRequest;
import com.dtone.dvs.service.ApiServiceAsync;
import com.dtone.dvs.util.Constants;
import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.commons.lang3.StringUtils;

public class DvsApiClientHelperAsync {

	private ApiServiceAsync apiService;

	private String url = null;

	public String getUrl() {
		return url;
	}

	public DvsApiClientHelperAsync(String url, String apiKey, String apiSecret) {
		this.url = url;
		apiService = new ApiServiceAsync(url, apiKey, apiSecret);
	}

	public DvsApiClientHelperAsync(ApiServiceAsync apiServiceParam, String url) {
		this.url = url;
		this.apiService = apiServiceParam;
	}

	// Services - Begin

	public CompletableFuture<PageAsync<CompletableFuture<ApiResponse<List<Service>>>>> getAllServices() {
		return apiService.httpGetPageable(Constants.SERVICES, getUrl(Constants.SERVICES),
				new ApiResponse<List<Service>>(), new TypeReference<List<Service>>() {
				});
	}

	public CompletableFuture<ApiResponse<List<Service>>> getServices(int page, int recordsPerPage) {
		return apiService.httpGet(getUrl(Constants.SERVICES, page, recordsPerPage), new ApiResponse<List<Service>>(),
				new TypeReference<List<Service>>() {
				});
	}

	public CompletableFuture<ApiResponse<Service>> getService(String serviceId) {
		return apiService.httpGet(getUrl(Constants.SERVICES, serviceId), new ApiResponse<Service>(),
				new TypeReference<Service>() {
				});
	}

	// Services - End

	// Countries - Begin

	public CompletableFuture<PageAsync<CompletableFuture<ApiResponse<List<Country>>>>> getAllCountries() {
		return apiService.httpGetPageable(Constants.COUNTRIES, getUrl(Constants.COUNTRIES),
				new ApiResponse<List<Country>>(), new TypeReference<List<Country>>() {
				});
	}

	public CompletableFuture<ApiResponse<List<Country>>> getCountries(int page, int recordsPerPage) {
		return apiService.httpGet(getUrl(Constants.COUNTRIES, page, recordsPerPage), new ApiResponse<List<Country>>(),
				new TypeReference<List<Country>>() {
				});
	}

	public CompletableFuture<ApiResponse<Country>> getCountry(String isoCode) {
		return apiService.httpGet(getUrl(Constants.COUNTRIES, isoCode), new ApiResponse<Country>(),
				new TypeReference<Country>() {
				});
	}

	// Countries - End

	// Operators - Begin

	public CompletableFuture<PageAsync<CompletableFuture<ApiResponse<List<Operator>>>>> getAllOperators() {
		return apiService.httpGetPageable(Constants.OPERATORS, getUrl(Constants.OPERATORS),
				new ApiResponse<List<Operator>>(), new TypeReference<List<Operator>>() {
				});
	}

	public CompletableFuture<ApiResponse<List<Operator>>> getOperators(int page, int recordsPerPage) {
		return apiService.httpGet(getUrl(Constants.OPERATORS, page, recordsPerPage), new ApiResponse<List<Operator>>(),
				new TypeReference<List<Operator>>() {
				});
	}

	public CompletableFuture<ApiResponse<List<Operator>>> getOperators(String countryIsoCode, int page, int recordsPerPage)
	{
		return apiService.httpGet(
				getUrl(Constants.OPERATORS, null, page, recordsPerPage,
						getQueryParamMap(Constants.COUNTRY_ISO_CODE, countryIsoCode)),
				new ApiResponse<List<Operator>>(), new TypeReference<List<Operator>>() {
				});
	}

	public CompletableFuture<ApiResponse<Operator>> getOperator(Long operatorId) {
		return apiService.httpGet(getUrl(Constants.OPERATORS, String.valueOf(operatorId)), new ApiResponse<Operator>(),
      new TypeReference<Operator>() {
      });
  }

  public CompletableFuture<ApiResponse<List<Operator>>> lookupOperators(String mobileNumber, int page, int recordsPerPage) {
    return apiService.httpGet(getUrl(Constants.OPERATOR_LOOKUP, mobileNumber, page, recordsPerPage, null),
      new ApiResponse<List<Operator>>(), new TypeReference<List<Operator>>() {
      });
  }

  public CompletableFuture<ApiResponse<List<Operator>>> lookupOperators(LookupOperatorRequest lookupOperatorRequest) {
    return apiService.httpPost(getUrl(Constants.OPERATOR_LOOKUP), new ApiResponse<List<Operator>>(),
      new TypeReference<List<Operator>>() {
      }, lookupOperatorRequest);
  }

  // Operators - End

  // Benefit Types - Begin

  public CompletableFuture<PageAsync<CompletableFuture<ApiResponse<List<BenefitType>>>>> getAllBenefitTypes() {
    return apiService.httpGetPageable(Constants.BENEFIT_TYPES, getUrl(Constants.BENEFIT_TYPES),
      new ApiResponse<List<BenefitType>>(), new TypeReference<List<BenefitType>>() {
      });
  }

	public CompletableFuture<ApiResponse<List<BenefitType>>> getBenefitTypes(int page, int recordsPerPage) {
		return apiService.httpGet(getUrl(Constants.BENEFIT_TYPES, page, recordsPerPage),
				new ApiResponse<List<BenefitType>>(), new TypeReference<List<BenefitType>>() {
				});
	}

	// Benefit Types - End

	// Promotions - Begin

	public CompletableFuture<PageAsync<CompletableFuture<ApiResponse<List<Promotion>>>>> getAllPromotions() {
		return apiService.httpGetPageable(Constants.PROMOTIONS, getUrl(Constants.PROMOTIONS),
				new ApiResponse<List<Promotion>>(), new TypeReference<List<Promotion>>() {
				});
	}

	public CompletableFuture<ApiResponse<List<Promotion>>> getPromotions(int page, int recordsPerPage) {
		return apiService.httpGet(getUrl(Constants.PROMOTIONS, page, recordsPerPage),
				new ApiResponse<List<Promotion>>(), new TypeReference<List<Promotion>>() {
				});
	}

	public CompletableFuture<ApiResponse<List<Promotion>>> getPromotions(PromotionFilter promotionFilter, int page,
																																			 int recordsPerPage) {
		return apiService.httpGet(
				getUrl(Constants.PROMOTIONS, null, page, recordsPerPage,
						promotionFilter.getQueryParameterMap()),
				new ApiResponse<List<Promotion>>(), new TypeReference<List<Promotion>>() {
				});
	}

	public CompletableFuture<ApiResponse<Promotion>> getPromotion(Long promotionId) {
		return apiService.httpGet(getUrl(Constants.PROMOTIONS, String.valueOf(promotionId)),
				new ApiResponse<Promotion>(), new TypeReference<Promotion>() {
				});
	}

  // Promotions - End

  // Products - Begin

  public CompletableFuture<PageAsync<CompletableFuture<ApiResponse<List<Product>>>>> getAllProducts() {
    return apiService.httpGetPageable(Constants.PRODUCTS, getUrl(Constants.PRODUCTS),
      new ApiResponse<List<Product>>(), new TypeReference<List<Product>>() {
      });
  }

  public CompletableFuture<PageAsync<CompletableFuture<ApiResponse<List<Product>>>>> getProducts(int page, int recordsPerPage) {
    return apiService.httpGetPageable(Constants.PRODUCTS,
      getUrl(Constants.PRODUCTS, null, page, recordsPerPage, null), new ApiResponse<List<Product>>(),
      new TypeReference<List<Product>>() {
      });
  }

  public CompletableFuture<ApiResponse<List<Product>>> getProducts(ProductFilter productFilter, int page, int recordsPerPage) {
    return apiService.httpGet(getUrl(Constants.PRODUCTS, null, page, recordsPerPage, productFilter.getQueryParameterMap()), new ApiResponse<List<Product>>(),
      new TypeReference<List<Product>>() {
      });
  }

  public CompletableFuture<ApiResponse<Product>> getProduct(Long productId) {
    return apiService.httpGet(getUrl(Constants.PRODUCTS, String.valueOf(productId)), new ApiResponse<Product>(),
      new TypeReference<Product>() {
      });
  }

  // Products - End

  // Transactions - Begin

  public CompletableFuture<ApiResponse<Transaction>> postTransaction(TransactionRequest transactionRequest) {
    if (StringUtils.isEmpty(transactionRequest.getExternalId())) {
      transactionRequest
        .setExternalId(String.valueOf(Calendar.getInstance().getTimeInMillis()) + UUID.randomUUID());
    }

    return apiService.httpPost(getUrl(Constants.TRANSACTION_ASYNC), new ApiResponse<Transaction>(),
      new TypeReference<Transaction>() {
      }, transactionRequest);
  }

  public CompletableFuture<PageAsync<CompletableFuture<ApiResponse<List<Transaction>>>>> getAllTransactions() {
    return apiService.httpGetPageable(Constants.TRANSACTIONS, getUrl(Constants.TRANSACTIONS),
      new ApiResponse<List<Transaction>>(), new TypeReference<List<Transaction>>() {
      });
  }


  public CompletableFuture<ApiResponse<Transaction>> getTransaction(Long transactionId) {
    return apiService.httpGet(getUrl(Constants.TRANSACTIONS, String.valueOf(transactionId)),
      new ApiResponse<Transaction>(), new TypeReference<Transaction>() {
      });
  }

  public CompletableFuture<ApiResponse<List<Transaction>>> getTransactions(TransactionFilter transactionFilter, int page,
                                                                           int recordsPerPage) {
    return apiService.httpGet(
      getUrl(Constants.TRANSACTIONS, null, page, recordsPerPage, transactionFilter.getQueryParameterMap()),
      new ApiResponse<List<Transaction>>(), new TypeReference<List<Transaction>>() {
      });
  }

  public CompletableFuture<ApiResponse<Transaction>> confirmTransaction(Long transactionId) {
    return apiService.httpPost(getUrl(Constants.CONFIRM_TRANSACTION_ASYNC, String.valueOf(transactionId)),
      new ApiResponse<Transaction>(), new TypeReference<Transaction>() {
      }, null);
  }

  public CompletableFuture<ApiResponse<Transaction>> cancelTransaction(Long transactionId) {
    return apiService.httpPost(getUrl(Constants.CANCEL_TRANSACTION, String.valueOf(transactionId)),
      new ApiResponse<Transaction>(), new TypeReference<Transaction>() {
      }, null);
  }

  // Transactions - End

  // Balances - Begin

	public CompletableFuture<PageAsync<CompletableFuture<ApiResponse<List<Balance>>>>> getAllBalances() {
		return apiService.httpGetPageable(Constants.BALANCES, getUrl(Constants.BALANCES),
				new ApiResponse<List<Balance>>(), new TypeReference<List<Balance>>() {
				});
	}

	public CompletableFuture<ApiResponse<List<Balance>>> getBalances(int page, int recordsPerPage) {
		return apiService.httpGet(getUrl(Constants.BALANCES, page, recordsPerPage), new ApiResponse<List<Balance>>(),
				new TypeReference<List<Balance>>() {
				});
	}

	public CompletableFuture<ApiResponse<List<Balance>>> getBalances(BalanceFilter balanceFilter) {
		return apiService.httpGet(getUrl(Constants.BALANCES, null, 0, 0, balanceFilter.getQueryParameterMap()), new ApiResponse<List<Balance>>(),
				new TypeReference<List<Balance>>() {
				});
	}

  // Balances - END

	public String getUrl(String uri) {
		return getUrl(uri, null, 0, 0, null);
	}

	public String getUrl(String uri, String pathParam) {
		return getUrl(uri, pathParam, 0, 0, null);
	}

	private String getUrl(String uri, int page, int recordsPerPage) {
		return getUrl(uri, null, page, recordsPerPage, null);
	}

	/**
	 * Method to prepare query parameter map
	 *
	 * @param queryParams the query parameters array
	 * @return query parameter map
	 */
	public Map<String, String> getQueryParamMap(String... queryParams) {

		Map<String, String> queryParamMap = new HashMap<>();
		String key = null;
		String value = null;

		if (queryParams.length > 0) {
			for (int i = 0; i < queryParams.length; i++) {
				if (i % 2 == 0) {
					key = queryParams[i];
				} else {
					value = queryParams[i];
					queryParamMap.put(key, value);
				}
			}
		}

		return queryParamMap;

	}

  /**
   * Method to prepare final URL
   *
   * @param uri            the base URL
   * @param pathParam      the path param
   * @param pageNumber     the page number
   * @param recordsPerPage the records per page
   * @param queryParams    the query parameters
   * @return the final URL
   */
	private String getUrl(String uri, String pathParam, int pageNumber, int recordsPerPage,
			Map<String, String> queryParams) {
		StringBuilder sb = new StringBuilder(this.getUrl());

		appendUri(uri, pathParam, sb);

		appendQueryParameters(queryParams, sb);

		appendPageNUmber(pageNumber, sb);

		appendRecordsPerPage(recordsPerPage, sb);

		return sb.toString();
	}

	private void appendRecordsPerPage(int recordsPerPage, StringBuilder sb) {
		if (recordsPerPage > 0) {
			if (sb.toString().contains(Constants.QUESTION_MARK)) {
				sb.append(Constants.AMPERSAND);
			}
			sb.append(Constants.PER_PAGE);
			sb.append(Constants.EQUAL);
			sb.append(recordsPerPage);
		}
	}

	private void appendPageNUmber(int pageNUmber, StringBuilder sb) {
		if (pageNUmber > 0) {
			if (sb.toString().contains(Constants.QUESTION_MARK)) {
				sb.append(Constants.AMPERSAND);
			} else {
				sb.append(Constants.QUESTION_MARK);
			}
			sb.append(Constants.PAGE);
			sb.append(Constants.EQUAL);
			sb.append(pageNUmber);
		}
	}

	private void appendQueryParameters(Map<String, String> queryParams, StringBuilder sb) {
		if (null != queryParams && !queryParams.isEmpty()) {
			for (Map.Entry<String, String> queryParam : queryParams.entrySet()) {
				if (sb.toString().contains(Constants.QUESTION_MARK)) {
					sb.append(Constants.AMPERSAND);
				} else {
					sb.append(Constants.QUESTION_MARK);
				}
				if (null != queryParam.getValue()) {
					sb.append(queryParam.getKey());
					sb.append(Constants.EQUAL);
					sb.append(queryParam.getValue());
				}
			}
		}
	}

	private void appendUri(String uri, String pathParam, StringBuilder sb) {
		if (null != pathParam) {
			if (uri.contains(Constants.PATH_PARAM_PLACEHOLDER)) {
				sb.append(uri.replace(Constants.PATH_PARAM_PLACEHOLDER, pathParam));
			} else {
				sb.append(uri);
				sb.append(Constants.SLASH);
				sb.append(pathParam);
			}
		} else {
			sb.append(uri);
		}
	}

}
