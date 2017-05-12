/*
 * This file was automatically generated by EvoSuite
 * Thu May 11 23:33:30 GMT 2017
 */

package edu.osu.cs362;

import org.junit.Test;
import static org.junit.Assert.*;
import edu.osu.cs362.Appt;
import edu.osu.cs362.CalDay;
import edu.osu.cs362.TimeTable;
import java.time.Clock;
import java.time.Duration;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Locale;
import java.util.TimeZone;
import org.junit.runner.RunWith;
import sun.util.calendar.ZoneInfo;

public class TimeTable_ESTest {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      TimeTable timeTable0 = new TimeTable();
      LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
      Appt appt0 = new Appt(1, 1, 1, 1, 1, "", "");
      linkedList0.add(appt0);
      linkedList0.add(appt0);
      timeTable0.deleteAppt(linkedList0, appt0);
      assertEquals(1, linkedList0.size());
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      TimeTable timeTable0 = new TimeTable();
      GregorianCalendar mockGregorianCalendar0 = new GregorianCalendar(3544, 3544, 3544);
      GregorianCalendar mockGregorianCalendar1 = new GregorianCalendar();
      // Undeclared exception!
      //try {
//        timeTable0.getApptRange((LinkedList<Appt>) null, mockGregorianCalendar0, mockGregorianCalendar1);
//        fail("Expecting exception: TooManyResourcesException");
      
      //} catch(TooManyResourcesException e) {
         //
         // Loop has been executed more times than the allowed 10000
         //
         //assertThrownBy("org.evosuite.runtime.LoopCounter", e);
      //}
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      TimeTable timeTable0 = new TimeTable();
      LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
      // Undeclared exception!
      try { 
        timeTable0.getApptRange(linkedList0, (GregorianCalendar) null, (GregorianCalendar) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         //assertThrownBy("edu.osu.cs362.TimeTable", e);
      }
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      TimeTable timeTable0 = new TimeTable();
      LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
      GregorianCalendar mockGregorianCalendar0 = new GregorianCalendar(4496, 840, 840, 5, 84, 84);
      mockGregorianCalendar0.setLenient(false);
      Locale locale0 = new Locale("D48+", "D48+", "D48+");
      GregorianCalendar mockGregorianCalendar1 = new GregorianCalendar(locale0);
      // Undeclared exception!
      try { 
        timeTable0.getApptRange(linkedList0, mockGregorianCalendar0, mockGregorianCalendar1);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // MONTH
         //
         //assertThrownBy("java.util.GregorianCalendar", e);
      }
  }

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      TimeTable timeTable0 = new TimeTable();
      LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
      linkedList0.add((Appt) null);
      Appt appt0 = new Appt(1, 1, 1, 1, 1, "", "1903-07-01T00:00:00Z");
      // Undeclared exception!
      try { 
        timeTable0.deleteAppt(linkedList0, appt0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         //assertThrownBy("edu.osu.cs362.TimeTable", e);
      }
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      TimeTable timeTable0 = new TimeTable();
      LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
      Appt appt0 = new Appt(1, 1, 1, 1, 1, "", "");
      linkedList0.add(appt0);
      Appt appt1 = new Appt(1, 1, 1, 1, 1, "", "");
      timeTable0.deleteAppt(linkedList0, appt1);
      assertEquals(1, linkedList0.size());
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      TimeTable timeTable0 = new TimeTable();
      LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
      Appt appt0 = new Appt(1, 1, 1, 1, 1, "", "");
      linkedList0.add(appt0);
      timeTable0.deleteAppt(linkedList0, appt0);
      assertEquals(0, linkedList0.size());
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      TimeTable timeTable0 = new TimeTable();
      LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
      Appt appt0 = new Appt(2505, 2505, 2505, 2505, 2505, "", "");
      LinkedList<Appt> linkedList1 = timeTable0.deleteAppt(linkedList0, appt0);
      assertNull(linkedList1);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      TimeTable timeTable0 = new TimeTable();
      LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
      LinkedList<Appt> linkedList1 = timeTable0.deleteAppt(linkedList0, (Appt) null);
      assertNull(linkedList1);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      TimeTable timeTable0 = new TimeTable();
      Appt appt0 = new Appt(1, 1, 1, 1, 1, "", "");
      LinkedList<Appt> linkedList0 = timeTable0.deleteAppt((LinkedList<Appt>) null, appt0);
      assertNull(linkedList0);
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      TimeTable timeTable0 = new TimeTable();
      LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
      Appt appt0 = new Appt(1, 1, 1, 1, 1, "", "");
      linkedList0.add(appt0);
      Clock clock0 = Clock.systemUTC();
      ChronoUnit chronoUnit0 = ChronoUnit.MINUTES;
      Duration duration0 = chronoUnit0.getDuration();
      Clock clock1 = Clock.tick(clock0, duration0);
      ZonedDateTime zonedDateTime0 = ZonedDateTime.now(clock1);
      GregorianCalendar mockGregorianCalendar0 = (GregorianCalendar)GregorianCalendar.from(zonedDateTime0);
      ZoneOffset zoneOffset0 = ZoneOffset.MAX;
      ZoneInfo zoneInfo0 = (ZoneInfo)TimeZone.getTimeZone((ZoneId) zoneOffset0);
      GregorianCalendar mockGregorianCalendar1 = new GregorianCalendar((TimeZone) zoneInfo0);
      LinkedList<CalDay> linkedList1 = timeTable0.getApptRange(linkedList0, mockGregorianCalendar0, mockGregorianCalendar1);
      assertEquals(1, linkedList1.size());
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      TimeTable timeTable0 = new TimeTable();
      LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
      Appt appt0 = new Appt(2505, 2505, 2505, 2505, 2505, "", "");
      linkedList0.add(appt0);
      GregorianCalendar mockGregorianCalendar0 = new GregorianCalendar(2505, 2505, 2505, 2505, 2505);
      Locale locale0 = Locale.TRADITIONAL_CHINESE;
      GregorianCalendar mockGregorianCalendar1 = new GregorianCalendar(locale0);
      LinkedList<CalDay> linkedList1 = timeTable0.getApptRange(linkedList0, mockGregorianCalendar1, mockGregorianCalendar0);
      //assertEquals("org.evosuite.runtime.mock.java.util.MockGregorianCalendar[time=?,areFieldsSet=false,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"GMT\",offset=0,dstSavings=0,useDaylight=false,transitions=0,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=?,YEAR=2505,MONTH=2505,WEEK_OF_YEAR=?,WEEK_OF_MONTH=?,DAY_OF_MONTH=2505,DAY_OF_YEAR=?,DAY_OF_WEEK=?,DAY_OF_WEEK_IN_MONTH=?,AM_PM=0,HOUR=2505,HOUR_OF_DAY=2505,MINUTE=2505,SECOND=0,MILLISECOND=?,ZONE_OFFSET=?,DST_OFFSET=?]", mockGregorianCalendar0.toString());
      //assertEquals("org.evosuite.runtime.mock.java.util.MockGregorianCalendar[time=1392409281320,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"GMT\",offset=0,dstSavings=0,useDaylight=false,transitions=0,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2014,MONTH=1,WEEK_OF_YEAR=7,WEEK_OF_MONTH=3,DAY_OF_MONTH=14,DAY_OF_YEAR=45,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=2,AM_PM=1,HOUR=8,HOUR_OF_DAY=20,MINUTE=21,SECOND=21,MILLISECOND=320,ZONE_OFFSET=0,DST_OFFSET=0]", mockGregorianCalendar1.toString());
      //assertEquals(1, linkedList1.size());
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      TimeTable timeTable0 = new TimeTable();
      LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
      GregorianCalendar mockGregorianCalendar0 = new GregorianCalendar();
      // Undeclared exception!
      try { 
        timeTable0.getApptRange(linkedList0, mockGregorianCalendar0, mockGregorianCalendar0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Second date specified is not before the first date specified.
         //
         //assertThrownBy("edu.osu.cs362.TimeTable", e);
      }
  }
}
