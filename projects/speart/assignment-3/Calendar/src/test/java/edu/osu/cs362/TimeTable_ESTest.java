/*
 * This file was automatically generated by EvoSuite
 * Thu May 11 09:22:37 GMT 2017
 */

package edu.osu.cs362;

import org.junit.Test;
import static org.junit.Assert.*;

import edu.osu.cs362.Appt;
import edu.osu.cs362.CalDay;
import edu.osu.cs362.TimeTable;
//import java.time.ZonedDateTime;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.junit.runner.RunWith;

public class TimeTable_ESTest {

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
      Appt appt0 = new Appt(0, 0, 0, 0, 0, "Y", "Y");
      linkedList0.add(appt0);
      Appt appt1 = new Appt(0, 0, 0, 5, 0, "Y", "Y");
      appt1.setStartDay(5);
      linkedList0.offerLast(appt1);
      TimeTable timeTable0 = new TimeTable();
      timeTable0.deleteAppt(linkedList0, appt1);
      assertEquals(1, linkedList0.size());
  }

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
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
  public void test02()  throws Throwable  {
      TimeTable timeTable0 = new TimeTable();
      //ZonedDateTime zonedDateTime0 = ZonedDateTime.now();
      GregorianCalendar mockGregorianCalendar0 = (GregorianCalendar) new GregorianCalendar(2020, 5, 15, 15, 15, 15);
      LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
      GregorianCalendar mockGregorianCalendar1 = new GregorianCalendar(3935, 3935, (-1));
      mockGregorianCalendar1.setLenient(false);
      // Undeclared exception!
      try { 
        timeTable0.getApptRange(linkedList0, mockGregorianCalendar1, mockGregorianCalendar0);
        fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // MONTH
         //
         //assertThrownBy("java.util.GregorianCalendar", e);
      }
  }

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      TimeTable timeTable0 = new TimeTable();
      LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
      linkedList0.add((Appt) null);
      Appt appt0 = new Appt(0, 0, 1, 1, 0, ", ", ", ");
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
  public void test04()  throws Throwable  {
      LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
      Appt appt0 = new Appt(0, 0, 0, 0, 0, "Y", "Y");
      linkedList0.add(appt0);
      Appt appt1 = new Appt(0, 0, 0, 5, 0, "Y", "Y");
      appt1.setStartDay(5);
      TimeTable timeTable0 = new TimeTable();
      timeTable0.deleteAppt(linkedList0, appt1);
      assertEquals(1, linkedList0.size());
  }

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      TimeTable timeTable0 = new TimeTable();
      LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
      Appt appt0 = new Appt(5, 0, 5, 5, 0, "Second date specified is not before he first date specified.", "Second date specified is not before he first date specified.");
      linkedList0.addFirst(appt0);
      timeTable0.deleteAppt(linkedList0, appt0);
      assertEquals(0, linkedList0.size());
  }

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
      Appt appt0 = new Appt(0, 0, 0, 0, 0, "Y", "Y");
      TimeTable timeTable0 = new TimeTable();
      LinkedList<Appt> linkedList1 = timeTable0.deleteAppt(linkedList0, appt0);
      assertNull(linkedList1);
  }

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      TimeTable timeTable0 = new TimeTable();
      GregorianCalendar GregorianCalendar0 = new GregorianCalendar();
      CalDay calDay0 = new CalDay((GregorianCalendar) GregorianCalendar0);
      LinkedList<Appt> linkedList0 = calDay0.getAppts();
      LinkedList<Appt> linkedList1 = timeTable0.deleteAppt(linkedList0, (Appt) null);
      assertNull(linkedList1);
  }

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      TimeTable timeTable0 = new TimeTable();
      Appt appt0 = new Appt(5, 0, 5, 5, 4421, "Second date specified is not before the first date specified.", "VUq_4YE*=M;]si");
      LinkedList<Appt> linkedList0 = timeTable0.deleteAppt((LinkedList<Appt>) null, appt0);
      assertNull(linkedList0);
  }

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      TimeTable timeTable0 = new TimeTable();
      GregorianCalendar GregorianCalendar0 = new GregorianCalendar();
      CalDay calDay0 = new CalDay((GregorianCalendar) GregorianCalendar0);
      LinkedList<Appt> linkedList0 = calDay0.getAppts();
      Appt appt0 = new Appt(2033, 2033, (-2), 2033, (-2), "Y6>f;\"4?[\"uk", "Y6>f;\"4?[\"uk");
      linkedList0.add(appt0);
      GregorianCalendar mockGregorianCalendar1 = new GregorianCalendar(2033, 2033, (-2));
      timeTable0.getApptRange(linkedList0, mockGregorianCalendar1, GregorianCalendar0);
      assertEquals("org.evosuite.runtime.mock.java.util.MockGregorianCalendar[time=1392409281320,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"GMT\",offset=0,dstSavings=0,useDaylight=false,transitions=0,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2014,MONTH=1,WEEK_OF_YEAR=7,WEEK_OF_MONTH=3,DAY_OF_MONTH=14,DAY_OF_YEAR=45,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=2,AM_PM=1,HOUR=8,HOUR_OF_DAY=20,MINUTE=21,SECOND=21,MILLISECOND=320,ZONE_OFFSET=0,DST_OFFSET=0]", GregorianCalendar0.toString());
      assertEquals("org.evosuite.runtime.mock.java.util.MockGregorianCalendar[time=?,areFieldsSet=false,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"GMT\",offset=0,dstSavings=0,useDaylight=false,transitions=0,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=?,YEAR=2033,MONTH=2033,WEEK_OF_YEAR=?,WEEK_OF_MONTH=?,DAY_OF_MONTH=-2,DAY_OF_YEAR=?,DAY_OF_WEEK=?,DAY_OF_WEEK_IN_MONTH=?,AM_PM=0,HOUR=0,HOUR_OF_DAY=0,MINUTE=0,SECOND=0,MILLISECOND=?,ZONE_OFFSET=?,DST_OFFSET=?]", mockGregorianCalendar1.toString());
  }

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      TimeTable timeTable0 = new TimeTable();
      //ZonedDateTime zonedDateTime0 = ZonedDateTime.now();
      GregorianCalendar mockGregorianCalendar0 = (GregorianCalendar) new GregorianCalendar(2020, 5, 15, 15, 15, 15);
      LinkedList<Appt> linkedList0 = new LinkedList<Appt>();
      Appt appt0 = new Appt(2, 2, 2, 2, 2, "1697-02-01T00:00:00Z", "1697-02-01T00:00:00Z");
      linkedList0.add(appt0);
      GregorianCalendar mockGregorianCalendar1 = new GregorianCalendar(3935, 3935, 2);
      timeTable0.getApptRange(linkedList0, mockGregorianCalendar1, mockGregorianCalendar0);
      assertEquals("org.evosuite.runtime.mock.java.util.MockGregorianCalendar[time=1392409281320,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"GMT\",offset=0,dstSavings=0,useDaylight=false,transitions=0,lastRule=null],firstDayOfWeek=2,minimalDaysInFirstWeek=4,ERA=1,YEAR=2014,MONTH=1,WEEK_OF_YEAR=7,WEEK_OF_MONTH=2,DAY_OF_MONTH=14,DAY_OF_YEAR=45,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=2,AM_PM=1,HOUR=8,HOUR_OF_DAY=20,MINUTE=21,SECOND=21,MILLISECOND=320,ZONE_OFFSET=0,DST_OFFSET=0]", mockGregorianCalendar0.toString());
      assertEquals("org.evosuite.runtime.mock.java.util.MockGregorianCalendar[time=?,areFieldsSet=false,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id=\"GMT\",offset=0,dstSavings=0,useDaylight=false,transitions=0,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=?,YEAR=3935,MONTH=3935,WEEK_OF_YEAR=?,WEEK_OF_MONTH=?,DAY_OF_MONTH=2,DAY_OF_YEAR=?,DAY_OF_WEEK=?,DAY_OF_WEEK_IN_MONTH=?,AM_PM=0,HOUR=0,HOUR_OF_DAY=0,MINUTE=0,SECOND=0,MILLISECOND=?,ZONE_OFFSET=?,DST_OFFSET=?]", mockGregorianCalendar1.toString());
  }

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      TimeTable timeTable0 = new TimeTable();
      GregorianCalendar mockGregorianCalendar0 = new GregorianCalendar();
      CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
      LinkedList<Appt> linkedList0 = calDay0.getAppts();
      // Undeclared exception!
      try { 
        timeTable0.getApptRange(linkedList0, mockGregorianCalendar0, mockGregorianCalendar0);
        //fail("Expecting exception: IllegalArgumentException");
      
      } catch(IllegalArgumentException e) {
         //
         // Second date specified is not before the first date specified.
         //
         //assertThrownBy("edu.osu.cs362.TimeTable", e);
      }
  }

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      TimeTable timeTable0 = new TimeTable();
      GregorianCalendar mockGregorianCalendar0 = new GregorianCalendar(0, 0, 0, 0, 0);
      CalDay calDay0 = new CalDay((GregorianCalendar) mockGregorianCalendar0);
      GregorianCalendar mockGregorianCalendar1 = new GregorianCalendar(1473, 1473, 0);
      // Undeclared exception!
      //try {
        timeTable0.getApptRange((LinkedList<Appt>) null, mockGregorianCalendar0, mockGregorianCalendar1);
        //fail("Expecting exception: TooManyResourcesException");
      
      //} catch(TooManyResourcesException e) {
         //
         // Loop has been executed more times than the allowed 10000
         //
         //assertThrownBy("org.evosuite.runtime.LoopCounter", e);
      //}
  }
}
