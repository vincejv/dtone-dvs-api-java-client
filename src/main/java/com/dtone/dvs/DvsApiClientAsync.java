package com.dtone.dvs;

import java.util.List;
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
import com.dtone.dvs.helper.DvsApiClientHelperAsync;

public class DvsApiClientAsync {

	private DvsApiClientHelperAsync dvsApiClientHelper;

	public DvsApiClientAsync(String baseUrl, String apiKey, String apiSecret) {
		this.dvsApiClientHelper = new DvsApiClientHelperAsync(baseUrl, apiKey, apiSecret);
	}

	public DvsApiClientAsync(DvsApiClientHelperAsync dvsClientHelper) {
		this.dvsApiClientHelper = dvsClientHelper;
	}
	
	// Services - Begin

	/**
	 * Get services
	 *
	 * @return paginated list of services
	 */
	public CompletableFuture<PageAsync<CompletableFuture<ApiResponse<List<Service>>>>> getServices() {
		return this.dvsApiClientHelper.getAllServices();
	}


	/**
	 * Get services by page number and records per page
	 *
	 * @param pageNumber the page number the page number
	 * @param recordsPerPage the number of records per page the number of records per page
	 * @return list of services
	 */
	public CompletableFuture<ApiResponse<List<Service>>> getServices(int pageNumber, int recordsPerPage) {
		return this.dvsApiClientHelper.getServices(pageNumber, recordsPerPage);
	}

	/**
	 * Get services by id
	 *
	 * @param serviceId the service id
	 * @return service
	 */
	public CompletableFuture<ApiResponse<Service>> getService(Long serviceId) {
		return this.dvsApiClientHelper.getService(String.valueOf(serviceId));
	}

	// Services - End


	// Countries - Begin

	/**
	 * Get countries
	 *
	 * @return paginated list of countries
	 */
	public CompletableFuture<PageAsync<CompletableFuture<ApiResponse<List<Country>>>>> getCountries() {
		return this.dvsApiClientHelper.getAllCountries();
	}

	/**
	 * Get countries by page number and records per page
	 *
	 * @param pageNumber     the page number
	 * @param recordsPerPage the number of records per page
	 * @return
	 */
	public CompletableFuture<ApiResponse<List<Country>>> getCountries(int pageNumber, int recordsPerPage) {
		return this.dvsApiClientHelper.getCountries(pageNumber, recordsPerPage);
	}

	/**
	 * Get country by country ISO code
	 *
	 * @param countryIsoCode the country ISO code
	 * @return country
	 */
	public CompletableFuture<ApiResponse<Country>> getCountry(String countryIsoCode) {
		return this.dvsApiClientHelper.getCountry(countryIsoCode);
	}

	// Countries - End

	// Operators - Begin

	/**
	 * Get operators
	 *
	 * @return paginated list of operators
	 */
	public CompletableFuture<PageAsync<CompletableFuture<ApiResponse<List<Operator>>>>> getOperators() {
		return this.dvsApiClientHelper.getAllOperators();
	}

	/**
	 * Get operators by page number and records per page
	 *
	 * @param pageNumber     the page number
	 * @param recordsPerPage the number of records per page
	 * @return list of operators
	 */
	public CompletableFuture<ApiResponse<List<Operator>>> getOperators(int pageNumber, int recordsPerPage) {
		return this.dvsApiClientHelper.getOperators(pageNumber, recordsPerPage);
	}

	/**
	 * Get operators by country ISO code
	 *
	 * @param countryIsoCode
	 * @return list of operators
	 */
	public CompletableFuture<ApiResponse<List<Operator>>> getOperators(String countryIsoCode) {
		return this.dvsApiClientHelper.getOperators(countryIsoCode, 0, 0);
	}

	/**
	 * Get operators by country ISO code, page number and records per page
	 *
	 * @param countryIsoCode the country ISO code
	 * @param pageNumber     the page number
	 * @param recordsPerPage the number of records per page
	 * @return list of operators
	 */
	public CompletableFuture<ApiResponse<List<Operator>>> getOperators(String countryIsoCode, int pageNumber, int recordsPerPage) {
		return this.dvsApiClientHelper.getOperators(countryIsoCode, pageNumber, recordsPerPage);
	}

	/**
	 * Get operator by id
	 *
	 * @param operatorId the operator id
	 * @return operator
	 */
	public CompletableFuture<ApiResponse<Operator>> getOperator(Long operatorId) {
		return this.dvsApiClientHelper.getOperator(operatorId);
	}

	/**
	 * Get list of operators by mobile number
	 *
	 * @param mobileNumber the mobile number
	 * @return list of operators
	 */
	public CompletableFuture<ApiResponse<List<Operator>>> lookupOperators(String mobileNumber) {
		return this.dvsApiClientHelper.lookupOperators(mobileNumber, 0, 0);
	}

	/**
   * Get list of operators by mobile number, page number and records per page
   *
   * @param mobileNumber
   * @param pageNumber     the page number
   * @param recordsPerPage the number of records per page
   * @return list of operators
   */
  public CompletableFuture<ApiResponse<List<Operator>>> lookupOperators(String mobileNumber, int pageNumber, int recordsPerPage) {
    return this.dvsApiClientHelper.lookupOperators(mobileNumber, pageNumber, recordsPerPage);
  }

  /**
   * Get list of operators by mobile number, page number and records per page
   * (POST)
   *
   * @param lookupOperatorRequest {@link LookupOperatorRequest} object
   * @return list of operators
   */
  public CompletableFuture<ApiResponse<List<Operator>>> lookupOperators(LookupOperatorRequest lookupOperatorRequest) {
    return this.dvsApiClientHelper.lookupOperators(lookupOperatorRequest);
  }

  // Operators - End

  // Benefit Types - Begin

  /**
   * Get benefit types
   *
   * @return paginated list of benefit types
   */
	public CompletableFuture<PageAsync<CompletableFuture<ApiResponse<List<BenefitType>>>>> getBenefitTypes() {
		return this.dvsApiClientHelper.getAllBenefitTypes();
	}

	/**
	 * Get benefit types by page number and records per page
	 *
	 * @param pageNumber     the page number
	 * @param recordsPerPage the number of records per page
	 * @return list of benefit types
	 */
	public CompletableFuture<ApiResponse<List<BenefitType>>> getBenefitTypes(int pageNumber, int recordsPerPage) {
		return this.dvsApiClientHelper.getBenefitTypes(pageNumber, recordsPerPage);
	}

	// Benefit Types - End

	// Promotions - Begin

	/**
	 * x
	 * Get promotions
	 *
	 * @return paginated list of promotions
	 */
	public CompletableFuture<PageAsync<CompletableFuture<ApiResponse<List<Promotion>>>>> getPromotions() {
		return this.dvsApiClientHelper.getAllPromotions();
	}

	/**
	 * Get promotions by page number and records per page
	 *
	 * @param pageNumber     the page number
	 * @param recordsPerPage the number of records per page
	 * @return list of promotions
	 */
	public CompletableFuture<ApiResponse<List<Promotion>>> getPromotions(int pageNumber, int recordsPerPage) {
		return this.dvsApiClientHelper.getPromotions(pageNumber, recordsPerPage);
	}

	/**
	 * Get promotions by filters
	 *
	 * @param promotionFilter the promotionFilter instance
	 * @return list of promotions
	 */
	public CompletableFuture<ApiResponse<List<Promotion>>> getPromotions(PromotionFilter promotionFilter) {
		return this.dvsApiClientHelper.getPromotions(promotionFilter, 0, 0);
	}

	/**
	 * Get promotions by filters, page number and records per page
	 *
	 * @param promotionFilter the promotionFilter instance
	 * @param pageNumber      he page number
	 * @param recordsPerPage  the number of records per page
	 * @return list of promotions
	 */
	public CompletableFuture<ApiResponse<List<Promotion>>> getPromotions(PromotionFilter promotionFilter,
																																			 int pageNumber, int recordsPerPage) {
		return this.dvsApiClientHelper.getPromotions(promotionFilter, pageNumber, recordsPerPage);
	}

	/**
	 * Get promotion by id
	 *
	 * @param promotionId the promotion id
	 * @return promotion
	 */
	public CompletableFuture<ApiResponse<Promotion>> getPromotion(Long promotionId) {
		return this.dvsApiClientHelper.getPromotion(promotionId);
	}

	// Promotions - End


	/**
	 * Get products
	 *
	 * @return paginated list of products
	 */
	public CompletableFuture<PageAsync<CompletableFuture<ApiResponse<List<Product>>>>> getProducts() {
		return this.dvsApiClientHelper.getAllProducts();
	}

	/**
	 * Get products by page number and records per page
	 *
	 * @param pageNumber     the page number
	 * @param recordsPerPage the number of records per page
	 * @return list of products
	 */
	public CompletableFuture<ApiResponse<List<Product>>> getProducts(int pageNumber, int recordsPerPage) {
		return this.dvsApiClientHelper.getProducts(new ProductFilter(), pageNumber, recordsPerPage);
	}

	/**
	 * Get products by filters
	 *
	 * @param productFilter  the product filter object
	 * @return list of products
	 */
	public CompletableFuture<ApiResponse<List<Product>>> getProducts(ProductFilter productFilter) {
		return this.dvsApiClientHelper.getProducts(productFilter, 0, 0);
	}

	/**
	 * Get products by filters, page number and records per page
	 *
	 * @param productFilter  the product filter object
	 * @param recordsPerPage the number of records per page
	 * @return list of products
	 */
	public CompletableFuture<ApiResponse<List<Product>>> getProducts(ProductFilter productFilter, int pageNumber, int recordsPerPage) {
		return this.dvsApiClientHelper.getProducts(productFilter, pageNumber, recordsPerPage);
	}

	/**
	 * Get product by id
	 *
	 * @param productId the product id
	 * @return product
	 */
	public CompletableFuture<ApiResponse<Product>> getProduct(Long productId) {
		return this.dvsApiClientHelper.getProduct(productId);
	}

	// Products - End
	
	// Transactions - Begin

  /**
   * Create a new transaction
   *
   * @param transactionRequest the transaction request
   * @return transaction
   */
  public CompletableFuture<ApiResponse<Transaction>> createTransaction(TransactionRequest transactionRequest) {
    return this.dvsApiClientHelper.postTransaction(transactionRequest);
  }

  /**
   * Get transactions
   *
   * @return paginated list of transactions
   */
  public CompletableFuture<PageAsync<CompletableFuture<ApiResponse<List<Transaction>>>>> getTransactions() {
    return this.dvsApiClientHelper.getAllTransactions();
  }

  /**
   * Get transactions by page number and records per page
   *
   * @param pageNumber     the page number
   * @param recordsPerPage the number of records per page
   * @return list of transactions
   */
  public CompletableFuture<ApiResponse<List<Transaction>>> getTransactions(int pageNumber, int recordsPerPage) {
    return this.dvsApiClientHelper.getTransactions(new TransactionFilter(), pageNumber, recordsPerPage);
  }


  /**
   * Get transaction by id
   *
   * @param transactionId the transaction id
   * @return transaction
   */
  public CompletableFuture<ApiResponse<Transaction>> getTransaction(Long transactionId) {
    return this.dvsApiClientHelper.getTransaction(transactionId);
  }

  /**
   * Get transactions by external id
   * <p>
   * transactionFilter the TransactionFilter instance
   *
   * @return list of transactions
   */
  public CompletableFuture<ApiResponse<List<Transaction>>> getTransactions(TransactionFilter transactionFilter) {
    return this.dvsApiClientHelper.getTransactions(transactionFilter, 0, 0);
  }

  /**
   * Get transactions by external id, page number and records per page
   * <p>
   * transactionFilter the TransactionFilter instance
   *
   * @param transactionFilter the TransactionFilter instance
   * @param pageNumber        the current page number
   * @param recordsPerPage    the number of records per page
   * @return list of transactions
   */
  public CompletableFuture<ApiResponse<List<Transaction>>> getTransactions(TransactionFilter transactionFilter, int pageNumber, int recordsPerPage) {
    return this.dvsApiClientHelper.getTransactions(transactionFilter, pageNumber, recordsPerPage);
  }

  /**
   * Confirm a transaction
   *
   * @param transactionId the transaction id
   * @return transaction
   */
  public CompletableFuture<ApiResponse<Transaction>> confirmTransaction(Long transactionId) {
    return this.dvsApiClientHelper.confirmTransaction(transactionId);
  }

  /**
   * Cancel a transaction
   *
   * @param transactionId the transaction id
   * @return transaction
   */
  public CompletableFuture<ApiResponse<Transaction>> cancelTransaction(Long transactionId) {
    return this.dvsApiClientHelper.cancelTransaction(transactionId);
	}

	// Transactions - End

	// Balances - Begin

	/**
	 * Get balances
	 *
	 * @return list of balances
	 */
	public CompletableFuture<PageAsync<CompletableFuture<ApiResponse<List<Balance>>>>> getBalances() {
		return this.dvsApiClientHelper.getAllBalances();
	}

	/**
	 * Get balances by page number and records per page
	 *
	 * @param pageNumber     the page number
	 * @param recordsPerPage the number of records per page
	 * @return list of balances
	 */
	public CompletableFuture<ApiResponse<List<Balance>>> getBalances(int pageNumber, int recordsPerPage) {
		return this.dvsApiClientHelper.getBalances(pageNumber, recordsPerPage);
	}

	/**
	 * Get balances by unit and unit type
	 *
	 * @return list of balances
	 */
	public CompletableFuture<ApiResponse<List<Balance>>> getBalances(BalanceFilter balanceFilter) {
		return this.dvsApiClientHelper.getBalances(balanceFilter);
	}


	// Balances - End
	
}
