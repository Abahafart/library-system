package com.mistborn.library.system.domain.exception;

public class ServerException extends RuntimeException {

  public ServerException(String message, Throwable cause) {
    super(message, cause);
  }

  public ServerException(Throwable cause) {
    super(cause);
  }

  public ServerException(String message) {
    super(message);
  }
}
