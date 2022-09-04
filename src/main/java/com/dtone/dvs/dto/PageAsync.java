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

	public boolean hasNext() {
		return totalPages > currentPage;
	}

	public boolean hasPrevious() {
		return currentPage > 1;
	}

	public T next() {
		setCurrentPage(getCurrentPage() + 1);
		return getApiResponse();
	}
	
	public T previous() {
		setCurrentPage(getCurrentPage() - 1);
		return getApiResponse();
	}
	
	public T last() {
		setCurrentPage(getTotalPages());
		return getApiResponse();
	}

	private T getApiResponse() {
		T t = null;

		switch (this.apiOperation) {
		case Constants.PRODUCTS:
			t = (T) dvsClient.getProducts(getCurrentPage(), getRecordsPerPage());
			break;
		case Constants.SERVICES:
			t = (T) dvsClient.getServices(getCurrentPage(), getRecordsPerPage());
			break;
		case Constants.OPERATORS:
			t = (T) dvsClient.getOperators(getCurrentPage(), getRecordsPerPage());
			break;
		case Constants.PROMOTIONS:
			t = (T) dvsClient.getPromotions(getCurrentPage(), getRecordsPerPage());
			break;
		case Constants.BENEFIT_TYPES:
			t = (T) dvsClient.getBenefitTypes(getCurrentPage(), getRecordsPerPage());
			break;
		case Constants.BALANCES:
			t = (T) dvsClient.getBalances(getCurrentPage(), getRecordsPerPage());
			break;
		case Constants.COUNTRIES:
			t = (T) dvsClient.getCountries(getCurrentPage(), getRecordsPerPage());
			break;
		default:

		}

		return t;
	}

	public T first() {
		if(getCurrentPage() <= 1) {
			return first;
		} else {
			setCurrentPage(1);
			return getApiResponse();
		}
	}
}
