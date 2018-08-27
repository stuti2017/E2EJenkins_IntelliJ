package testcode.enums;

/**
 * Enumerated type for all DynamoDB Tables
 */
public enum DynamoDBTable {
  WCE_BATCH_INFO("204837-wc-enablement-batch-info");

  private final String value;

  DynamoDBTable(String text) {
    this.value = text;
  }

  public String getStringValue() {
    return this.value;
  }
}
