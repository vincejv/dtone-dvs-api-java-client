package com.dtone.dvs.dto;

import com.dtone.dvs.DvsApiClientAsync;
import com.dtone.dvs.util.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("unchecked")
@Data
@AllArgsConstructor
@EqualsAndHashCode
public class PageAsync<T> {

	private final DvsApiClientAsync dvsClient;
	private T first;
	private String apiOperation;

	private int totalPages;
	private int totalRecords;
	private int currentPage;
  private int recordsPerPage;
  private int nextPage;
  private int previousPage;

  public PageAsync(String apiOperation, String url, String apiKey, String apiSecret, T apiResponse) {
    this.apiOperation = apiOperation;
    this.dvsClient = new DvsApiClientAsync(url, apiKey, apiSecret);
    this.first = apiResponse;
  }

  public PageAsync(String apiOperation, int totalPages, int totalRecords, int currentPage, int recordsPerPage,
                   int nextPage, int previousPage) {
    this.dvsClient = null;
    this.apiOperation = apiOperation;
    this.totalPages = totalPages;
    this.totalRecords = totalRecords;
    this.currentPage = currentPage;
    this.recordsPerPage = recordsPerPage;
    this.nextPage = nextPage;
    this.previousPage = previousPage;
  }

  /**
   * Has next page
   *
   * @return if next page is available
   */
  public boolean hasNext() {
    return totalPages > currentPage;
  }

  /**
   * Has previous page
   *
   * @return if previous page is available
   */
  public boolean hasPrevious() {
    return currentPage > 1;
  }

  /**
   * Has next page
   *
   * @return if next page is available
   */
  public T next() {
    setCurrentPage(getCurrentPage() + 1);
    return getApiResponse();
  }

  /**
   * Get previous page
   *
   * @return the previous page
   */
  public T previous() {
    setCurrentPage(getCurrentPage() - 1);
    return getApiResponse();
  }

  /**
   * Get last page
   *
   * @return the last page
   */
  public T last() {
    setCurrentPage(getTotalPages());
    return getApiResponse();
  }

  private T getApiResponse() {
    T t;

    t = switch (this.apiOperation) {
      case Constants.PRODUCTS -> (T) dvsClient.getProducts(getCurrentPage(), getRecordsPerPage());
      case Constants.SERVICES -> (T) dvsClient.getServices(getCurrentPage(), getRecordsPerPage());
      case Constants.OPERATORS -> (T) dvsClient.getOperators(getCurrentPage(), getRecordsPerPage());
      case Constants.PROMOTIONS -> (T) dvsClient.getPromotions(getCurrentPage(), getRecordsPerPage());
      case Constants.BENEFIT_TYPES -> (T) dvsClient.getBenefitTypes(getCurrentPage(), getRecordsPerPage());
      case Constants.BALANCES -> (T) dvsClient.getBalances(getCurrentPage(), getRecordsPerPage());
      case Constants.COUNTRIES -> (T) dvsClient.getCountries(getCurrentPage(), getRecordsPerPage());
      default -> null;
    };

    return t;
  }

  /**
   * Get first page
   *
   * @return the first page
   */
  public T first() {
    if (getCurrentPage() <= 1) {
      return first;
    } else {
      setCurrentPage(1);
      return getApiResponse();
    }
  }

  /**
   * Get page information
   *
   * @return the page information
   */
  public PageInfo getPageInfo() {
    return new PageInfo(totalPages, totalRecords, currentPage, recordsPerPage, nextPage, previousPage);
  }

}
