package com.dtone.dvs.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse<T> {
	private boolean success;
  private int code;
  private List<ApiError> errors;
  private T result;

	private int totalPages;
	private int totalRecords;
	private int currentPage;
	private int recordsPerPage;
	private int nextPage;
	private int previousPage;

  public ApiResponse(boolean success, Integer code, List<ApiError> errors) {
    this.success = success;
    this.code = code;
    this.errors = errors;
  }

  public List<ApiError> getErrors() {
    if (null == errors) {
      errors = new ArrayList<>();
    }
    return errors;
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
