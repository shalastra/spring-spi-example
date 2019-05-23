package io.shalastra.springserviceproviderapi.exception;

public class ImplementedProviderNotFoundException extends RuntimeException {

  public ImplementedProviderNotFoundException() {
  }

  public ImplementedProviderNotFoundException(String message) {
    super(message);
  }
}
