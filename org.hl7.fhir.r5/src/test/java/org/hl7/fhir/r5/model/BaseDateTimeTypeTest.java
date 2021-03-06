package org.hl7.fhir.r5.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class BaseDateTimeTypeTest {

    /**
     * <ul>
     *     <li>true if the given datetimes represent the exact same instant with the same precision (irrespective of the timezone)</li>
     *     <li>true if the given datetimes represent the exact same instant but one includes milliseconds of <code>.[0]+</code> while the other includes only SECONDS precision (irrespecitve of the timezone)</li>
     *     <li>true if the given datetimes represent the exact same year/year-month/year-month-date (if both operands have the same precision)</li>
     *     <li>false if the given datetimes have the same precision but do not represent the same instant (irrespective of timezone)</li>
     *     <li>null otherwise (since these datetimes are not comparable)</li>
     * </ul>
     */
    @Test
    public void equalsUsingFhirPathRulesInSpec() {
      
      // from the spec
      assertTrue( compareDateTimes("2012", "2012"));
      assertFalse(compareDateTimes("2012", "2013"));
      assertNull( compareDateTimes("2012-01", "2012"));
      assertNull( compareDateTimes("2012-01-01", "2012-01-01T00:00:00"));
      assertTrue( compareDateTimes("2012-01-01T10:30:00", "2012-01-01T10:30:00"));
      assertFalse(compareDateTimes("2012-01-01T10:30:00", "2012-01-01T10:31:00"));
      assertTrue( compareDateTimes("2012-01-01T10:30:31.0", "2012-01-01T10:30:31"));
      assertFalse(compareDateTimes("2012-01-01T10:30:31.1", "2012-01-01T10:30:31"));
      assertFalse(compareDateTimes("2017-11-05T01:30:00.0-04:00", "2017-11-05T01:15:00.0-05:00"));
      assertTrue(compareDateTimes("2017-11-05T01:30:00.0-04:00", "2017-11-05T00:30:00.0-05:00"));
    }
    
    @Test
    public void equalsUsingFhirPathRulesOther() {
        // Exact same - Same timezone
        assertTrue( compareDateTimes("2001-01-02T11:22:33.444Z", "2001-01-02T11:22:33.444Z"));
        // Exact same - Different timezone
        assertTrue( compareDateTimes("2001-01-02T11:22:33.444-03:00", "2001-01-02T10:22:33.444-04:00"));
        // Exact same - Dates
        assertTrue( compareDateTimes("2001", "2001"));
        assertTrue( compareDateTimes("2001-01", "2001-01"));
        assertTrue( compareDateTimes("2001-01-02", "2001-01-02"));
        // Same precision but different values - Dates
        assertFalse(compareDateTimes("2001", "2002"));
        assertFalse(compareDateTimes("2001-01", "2001-02"));
        assertFalse(compareDateTimes("2001-01-02", "2001-01-03"));
        // Different instant - Same timezone
        assertFalse(compareDateTimes("2001-01-02T11:22:33.444Z", "2001-01-02T11:22:33.445Z"));
        assertFalse(compareDateTimes("2001-01-02T11:22:33.445Z", "2001-01-02T11:22:33.444Z"));

        // FHIRPath tests:
        assertNull( compareDateTimes("1974-12-25", "1974-12-25T12:34:00+10:00"));
        assertNull( compareDateTimes("1974-12-25T12:34:00+10:00", "1974-12-25"));
        assertFalse(compareDateTimes("1974-12-25", "1974-12-23T12:34:00+10:00")); // false because they can't be the same date irrespective of precision
        assertFalse(compareDateTimes("1974-12-23T12:34:00+10:00", "1974-12-25"));
        assertNull( compareDateTimes("1974-12-25", "1974-12-25T12:34:00Z"));
        assertNull( compareDateTimes("1974-12-25T12:34:00Z", "1974-12-25"));
        assertFalse(compareDateTimes("2012-04-15", "2012-04-16"));
        assertFalse(compareDateTimes("2012-04-16", "2012-04-15"));
        assertFalse(compareDateTimes("2012-04-15T15:00:00", "2012-04-15T10:00:00"));
        assertFalse(compareDateTimes("2012-04-15T10:00:00", "2012-04-15T15:00:00"));
        assertFalse(compareDateTimes("2017-11-05T01:30:00.0-04:00", "2017-11-05T01:15:00.0-05:00"));
        assertFalse(compareDateTimes("2017-11-05T01:15:00.0-05:00", "2017-11-05T01:30:00.0-04:00"));
        assertNull(compareDateTimes("1974-12-25", "1974-12-25T12:34:00"));
        assertNull(compareDateTimes("1974-12-25T12:34:00", "1974-12-25"));
        assertNull(compareDateTimes("2012-04-15T10:00:00", "2012-04-15"));
        assertFalse(compareDateTimes("2012-04-15T15:00:00Z", "2012-04-15T10:00:00"));
        assertFalse(compareDateTimes("2012-04-15T10:00:00", "2012-04-15T15:00:00Z"));
        assertTrue(compareDateTimes("1974-12-25", "1974-12-25"));
        assertTrue(compareDateTimes("2012-04-15", "2012-04-15"));
        assertTrue(compareDateTimes("2012-04-15T15:00:00+02:00", "2012-04-15T16:00:00+03:00"));
        assertTrue(compareDateTimes("2012-04-15T16:00:00+03:00", "2012-04-15T15:00:00+02:00"));
        assertTrue(compareDateTimes("2017-11-05T01:30:00.0-04:00", "2017-11-05T00:30:00.0-05:00"));
        assertTrue(compareDateTimes("2017-11-05T00:30:00.0-05:00", "2017-11-05T01:30:00.0-04:00"));

        assertFalse(compareDateTimes("2016-12-02T13:00:00Z", "2016-11-02T10:00:00")); // no timezone, but cannot be the same time
        assertFalse(compareDateTimes("2016-12-02T13:00:00Z", "2016-12-02T10:00:00")); // no timezone, might be the same time
    }

    @Test
    public void testToHumanDisplayForDateOnlyPrecisions() {
      assertEquals("2019-01-02", new DateTimeType("2019-01-02").toHumanDisplay());
      assertEquals("2019-01", new DateTimeType("2019-01").toHumanDisplay());
      assertEquals("2019", new DateTimeType("2019").toHumanDisplay());
    }

  @Test
  public void testToHumanDisplayLocalTimezoneForDateOnlyPrecisions() {
    assertEquals("2019-01-02", new DateTimeType("2019-01-02").toHumanDisplayLocalTimezone());
    assertEquals("2019-01", new DateTimeType("2019-01").toHumanDisplayLocalTimezone());
    assertEquals("2019", new DateTimeType("2019").toHumanDisplayLocalTimezone());
  }


    private Boolean compareDateTimes(String theLeft, String theRight) {
      System.out.println("Compare "+theLeft+" to "+theRight);
      DateTimeType leftDt = new DateTimeType(theLeft);
      DateTimeType rightDt = new DateTimeType(theRight);
      return leftDt.equalsUsingFhirPathRules(rightDt);
    }

}