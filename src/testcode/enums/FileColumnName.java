package testcode.enums;

import java.util.stream.Stream;

/**
 * Enumerated type for all File column name
 */
public enum FileColumnName {
  //ENTITY_TYPE_GENDER("\"Entity Type/Gender*\""),
  ENTITY_TYPE_GENDER("Entity Type/Gender*"),
  LOCATION_COUNTRY_NATIONALITY3("Location/Country/Nationality3"),
  POSITION("Position"),
  REFERENCE("Reference"),
  LOCATION_COUNTRY_NATIONALITY2("Location/Country/Nationality2"),
  NAME1("Name*"),
  LOCATION_COUNTRY_NATIONALITY1("Location/Country/Nationality1"),
  IS_PEP("Is PEP (Y/N)"),
  NAME3("Name3"),
  NAME4("Name4"),
  DATE_OF_BIRTH("Date of Birth"),
  UNIVERSAL_ID("Universal ID"),
  NAME2("Name2"),
  LINKED_TO("linkedTo"),
  LAST_NAME("lastName"),
  DECEASED("deceased"),
  ALIASES("aliases"),
  DEFAULT_CATEGORY("defaultCategory"),
  KEYWORDS("keywords"),
  DEFAULT_ID_NUMBER("defaultIdNumber"),
  REGULATORY("regulatory"),
  SUB_CATEGORIES("subCategories"),
  RECORD_ID("recordId"),
  UUID("uid"),
  COMPANIES("companies"),
  ALTERNATE_SPELLINGS("alternateSpellings"),
  INACTIVE("inactive"),
  PROFILE_TYPE("profileType"),
  CATEGORIES("categories"),
  DEFAULT_PROFILE_AGE("defaultProfileAge"),
  PLACE_OF_BIRTH("placeOfBirth"),
  FURTHER_INFORMATION ("furtherInformation"),
  CITIZENSHIP("citizenship"),
  EXTERNAL_SOURCES("externalSources"),
  POSITIONS("positions"),
  ENTITY_ID("entityId"),
  PASSPORTS("passports"),
  ENTERED("entered"),
  MATCH_CLASSIFICATION("matchClassification"),
  ID_NUMBERS("idNumbers"),
  UNIVERSAL_IDS("universalIds"),
  DEFAULT_AGE_DATE("defaultAgeDate"),
  FIRST_NAME("firstName"),
  MATCH_SCORE("matchScore"),
  LOW_QUALITY_ALIASES("lowQualityAliases"),
  DOB("dob"),
  LOCATIONS("locations"),
  UPDATED("updated"),
  REMARK("remarks"),
  ERRORS("Errors");

  private final String value;

  FileColumnName(String text) {
    this.value = text;
  }

  public String getStringValue() {
    return this.value;
  }

  public static Stream<FileColumnName> stream() {
    return Stream.of(FileColumnName.values());
  }

}