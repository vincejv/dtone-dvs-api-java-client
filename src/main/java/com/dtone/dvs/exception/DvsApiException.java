package com.dtone.dvs.exception;

import java.io.Serial;

public class DvsApiException extends Exception {

  @Serial
  private static final long serialVersionUID = -2001848026123329213L;

  public DvsApiException(Throwable cause) {
    super(cause);
  }

}
