package testcode.enums;

/*
This enum is for the matching classificaion and comparison they need
 */

public enum MatchingClassification {
  MATCH("Match"),
  UNCERTAIN("Uncertain"),
  NO_MATCH("No Match"),
  GREATER_THAN("Greater Than"),
  GREATER_THAN_OR_EQUAL_TO_AND_LESS_THAN_OR_EQUAL_TO("Greater Than Or Equal To And Less Than Or Equal To"),
  LESS_THAN("Less Than");

  private final String value;

  MatchingClassification(String text) {
    this.value = text;
  }

  public static MatchingClassification fromString(String text) {
    for (MatchingClassification counter : MatchingClassification.values()) {
      if (counter.value.equalsIgnoreCase(text)) {
        return counter;
      }
    }
    throw new IllegalArgumentException("No constant with text " + text + " found");
  }

  public String getStringValue() {
    return this.value;
  }
}
