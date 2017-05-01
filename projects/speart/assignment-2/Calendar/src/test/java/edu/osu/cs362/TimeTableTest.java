package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
		 int startHour = 13;
		 int startMinute = 30;
		 int startDay = 10;
		 int startMonth = 4;
		 int startYear = 2017;
		 String title = "Birthday Party";
		 String description = "This is my birthday party.";
		 //Construct a new Appointment object with the initial data
		 Appt appt = new Appt(startHour,
				 startMinute,
				 startDay,
				 startMonth,
				 startYear,
				 title,
				 description);

		 startHour = 15;
		 startMinute = 35;
		 startDay = 15;
		 startMonth = 9;
		 startYear = 2020;
		 title = "Birthday Party";
		 description = "This is my birthday party.";
		 //Construct a new Appointment object with the initial data
		 Appt apptS = new Appt(startHour,
				 startMinute,
				 startDay,
				 startMonth,
				 startYear,
				 title,
				 description);

		 GregorianCalendar cal = new GregorianCalendar();
		 cal.set(2000, 3, 10, 10, 10 , 15);

		 CalDay calDay = new CalDay(cal);
		 calDay.addAppt(appt);
		 calDay.addAppt(apptS);

		 GregorianCalendar gCal = new GregorianCalendar();
		 gCal.set(2000, 3, 11, 11, 11, 11);

		 GregorianCalendar goCal = new GregorianCalendar();
		 gCal.set(2020, 5, 15, 15, 15, 15);

		 TimeTable timeTable = new TimeTable();
		 timeTable.getApptRange(calDay.getAppts(), cal, gCal);
		 timeTable.getApptRange(calDay.getAppts(), cal, goCal);
		 //timeTable.getApptRange(calDay.getAppts(), gCal, cal);
		 timeTable.deleteAppt(calDay.getAppts(), appt);

		 startHour = 10;
		 startMinute = 10;
		 startDay = 40;
		 startMonth = 10;
		 startYear = 2020;
		 title = "Birthday Party";
		 description = "This is my birthday party.";
		 //Construct a new Appointment object with the initial data
		 Appt apptY = new Appt(startHour,
				 startMinute,
				 startDay,
				 startMonth,
				 startYear,
				 title,
				 description);
	
		
		assertEquals(null, timeTable.deleteAppt( calDay.getAppts(), apptY ) );
		 calDay.addAppt(apptY);

		 timeTable.getApptRange(calDay.getAppts(), cal, gCal);
		// timeTable.getApptRange(calDay.getAppts(), gCal, cal);
		
		assertEquals(null, timeTable.deleteAppt(null, null ) );
		assertEquals(null, timeTable.deleteAppt(calDay.getAppts(), null ) );
		
		startDay = 10;
		apptY = new Appt(startHour,
				 startMinute,
				 startDay,
				 startMonth,
				 startYear,
				 title,
				 description);
	
		
		assertEquals(null, timeTable.deleteAppt( calDay.getAppts(), apptY ) );
		 calDay.addAppt(apptY);
		
	 }

}
