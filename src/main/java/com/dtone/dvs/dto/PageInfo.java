package com.dtone.dvs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PageInfo {
  private int totalPages;
  private int totalRecords;
  private int currentPage;
  private int recordsPerPage;
  private int nextPage;
  private int previousPage;
}