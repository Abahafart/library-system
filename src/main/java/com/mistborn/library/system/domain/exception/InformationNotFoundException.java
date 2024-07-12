package com.mistborn.library.system.domain.exception;

public class InformationNotFoundException extends RuntimeException {

  public InformationNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }

  public InformationNotFoundException(String message) {
    super(message);
  }
}
