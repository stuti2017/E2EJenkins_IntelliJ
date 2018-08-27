package testcode.enums;

/**
 * Enumerated type for all DynamoDB columns
 */
public enum DynamoDBColumns {
  BATCH_NAME("batchName"),
  ID("id");

  private final String value;

  DynamoDBColumns(String text) {
    this.value = text;
  }

  public String getStringValue() {
    return this.value;
  }
}
