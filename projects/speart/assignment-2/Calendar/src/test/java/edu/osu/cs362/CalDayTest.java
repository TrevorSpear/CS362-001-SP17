package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.GregorianCalendar;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
		CalDay calDay = new CalDay();
		assertFalse(calDay.isValid());
	 }

	@Test
	public void test02()  throws Throwable {
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

		GregorianCalendar cal = new GregorianCalendar();
		cal.set(2000, 3, 10, 10, 10 , 10);

		CalDay calDay = new CalDay(cal);
		CalDay callDay = new CalDay();
		callDay.iterator();
		callDay.toString();
		//calDay.addAppt(null);
		calDay.addAppt(appt);
		calDay.toString();
		
		assertEquals( 1, calDay.getSizeAppts());
		calDay.iterator();
	}
}
