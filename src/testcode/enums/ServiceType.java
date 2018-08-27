package testcode.enums;

/**
 * Enumerated type for all File column name
 */
public enum ServiceType {
  DERMATOLOGY("Dermatology"),
  DERMATOLOGY_NEW_PATIENT("Dermatology (New Patient)"),
  GENERAL_MEDICINE("General Medicine"),
  GENERAL_MEDICINE_NEW_PATIENT("General Medicine (New Patient)"),
  GYNECOLOGY("Gynecology"),
  GYNECOLOGY_NEW_PATIENT("Gynecology (New Patient)"),
  INFECTIOUS_DISEASE("Infectious Disease"),
  INFECTIOUS_DISEASE_NEW_PATIENT("Infectious Disease (New Patient)"),
  MENTAL_HEALTH("Mental Health"),
  MENTAL_HEALTH_NEW_PATIENT("Mental Health (New Patient)");


  private final String value;

  ServiceType(String text) {
    this.value = text;
  }

  public String getStringValue() {
    return this.value;
  }
}