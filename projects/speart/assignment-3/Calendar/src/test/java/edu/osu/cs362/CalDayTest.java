package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
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

		cal.set(2000, 13, 10, 10, 10 , 10);
		CalDay callItDay = new CalDay(cal);
		CalDay callDay = new CalDay();

		assertNotEquals(null, calDay.getAppts());
		assertNotEquals(null, calDay.getDay());
		assertNotEquals(null, calDay.getMonth());
		assertNotEquals(null, calDay.getYear());
		assertNotEquals(null, calDay.isValid());

		assertNotEquals(null, callItDay.iterator());
		assertNotEquals(null, callItDay.toString());

		assertEquals(null, callDay.iterator());
		assertNotEquals(null, callDay.toString());

		calDay.addAppt(appt);
		assertNotEquals(null, calDay.toString());
		
		assertEquals( 1, calDay.getSizeAppts());
		assertNotEquals(null, calDay.iterator());
	}

	@Test(timeout = 4000)
	public void test03()  throws Throwable  {
		CalDay calDay0 = new CalDay();
		calDay0.isValid();

		GregorianCalendar GregorianCalendar0 = new GregorianCalendar();
		calDay0 = new CalDay(GregorianCalendar0);
		calDay0.getYear();

		calDay0 = new CalDay();
		calDay0.year = (-211);
		calDay0.getYear();

		calDay0 = new CalDay();
		calDay0.getMonth();

		GregorianCalendar0 = new GregorianCalendar(0, 0, 0);
		calDay0 = new CalDay(GregorianCalendar0);
		calDay0.month = 0;
		calDay0.month = (-573);
		calDay0.getMonth();

		GregorianCalendar0 = new GregorianCalendar(100, 1068, 1068, 1068, (-355), 72);
		calDay0 = new CalDay(GregorianCalendar0);
		calDay0.getDay();

		calDay0 = new CalDay();
		calDay0.day = (-133);
		calDay0.getDay();

		calDay0 = new CalDay();
		calDay0.getAppts();

		Locale locale0 = Locale.TRADITIONAL_CHINESE;
		GregorianCalendar0 = new GregorianCalendar(locale0);
		calDay0 = new CalDay(GregorianCalendar0);
		Appt appt0 = new Appt(2, 1, 1, 1, 0, "test", "Testing");
		calDay0.addAppt(appt0);
		calDay0.getSizeAppts();
		calDay0.addAppt(appt0);
		calDay0.getAppts();


		calDay0 = new CalDay();
		calDay0.valid = true;
		calDay0 = new CalDay();
		calDay0 = null;

		GregorianCalendar0 = new GregorianCalendar(2000, 1, 1, 1, 1);
		calDay0 = null;
		calDay0 = new CalDay(GregorianCalendar0);

		calDay0 = new CalDay();
		calDay0.getYear();

		calDay0 = new CalDay();
		calDay0.getDay();

		GregorianCalendar0 = new GregorianCalendar(0, 0, 0);
		calDay0 = new CalDay(GregorianCalendar0);
		calDay0.getMonth();
		calDay0.getAppts();
		calDay0.isValid();

		GregorianCalendar0 = new GregorianCalendar(0, (-1837), (-1837), 0, 0);
		calDay0 = new CalDay(GregorianCalendar0);
		LinkedList<Appt> linkedList0 = calDay0.appts;
		appt0 = new Appt(0, (-27), 1, 2, (-1837), "test", "");
		linkedList0.add(appt0);
		String string0 = calDay0.toString();
		assertEquals("\t --- 10/19/160 --- \n --- -------- Appointments ------------ --- \nnull \n", string0);

		calDay0 = new CalDay();
		string0 = calDay0.toString();
		assertEquals("", string0);

		calDay0 = new CalDay();
		Iterator<?> iterator0 = calDay0.iterator();
		assertNull(iterator0);

		calDay0 = new CalDay();
		linkedList0 = new LinkedList<Appt>();
		calDay0.appts = linkedList0;
		appt0 = new Appt(1, 17, 1375, 17, 1, "The stuff to life", "Is at your doorstep");
		linkedList0.add(appt0);
		Appt appt1 = new Appt(0, 0, 17, 1, 0, "a ", "a");
		calDay0.addAppt(appt1);
		calDay0.addAppt(appt1);
		assertEquals(3, calDay0.getSizeAppts());

		calDay0 = new CalDay();
		linkedList0 = new LinkedList<Appt>();
		calDay0.appts = linkedList0;
		appt0 = new Appt((-3659), (-1), 5, 57, 3630, "b ", "b");
		linkedList0.add(appt0);
		appt1 = new Appt(0, 0, 1, 1, 44, "c ", "c");
		calDay0.addAppt(appt1);
		assertEquals(2, calDay0.getSizeAppts());

		GregorianCalendar0 = new GregorianCalendar(100, 1068, 1068, 1068, (-355), 72);
		calDay0 = new CalDay(GregorianCalendar0);
		appt0 = new Appt(72, (-355), 72, (-355), 100, "or is it at your backdoor", "One must look to find their own life or be stuck with what they have ");
		calDay0.addAppt(appt0);
		assertTrue(calDay0.isValid());
		assertEquals(192, calDay0.getYear());
		assertEquals(0, calDay0.getMonth());
		assertEquals(17, calDay0.getDay());
		assertEquals(0, calDay0.getSizeAppts());

		GregorianCalendar0 = new GregorianCalendar(0, (-1837), (-1837), 0, 0);
		calDay0 = new CalDay(GregorianCalendar0);
		calDay0.getSizeAppts();
		assertEquals(19, calDay0.getDay());
		assertEquals(160, calDay0.getYear());
		assertEquals(10, calDay0.getMonth());
		assertTrue(calDay0.isValid());

		GregorianCalendar0 = new GregorianCalendar(0, (-1837), (-1837), 0, 0);
		calDay0 = new CalDay(GregorianCalendar0);
		iterator0 = calDay0.iterator();
		assertNotNull(iterator0);
		assertEquals(160, calDay0.getYear());
		assertEquals(19, calDay0.getDay());
		assertEquals(10, calDay0.getMonth());
	}
}