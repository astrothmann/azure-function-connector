package de.viadee.bpm.connectors.azure.serverless;

import java.util.Arrays;

public enum ApiOperationsEnum {
  INVOKE_FUNCTION_SYNC("invoke_sync"),
  GET_FUNCTION_LIST("get_list");

  private final String value;

  ApiOperationsEnum(String value) {
    this.value = value;
  }

  public static ApiOperationsEnum fromValue(String value) {
    return Arrays
        .stream(values())
        .filter(apiOperationsEnum -> apiOperationsEnum.value.equals(value))
        .findFirst()
        .orElseThrow(
            () -> new IllegalArgumentException("Unbekannter Wert: " + value)
        );
  }

}
