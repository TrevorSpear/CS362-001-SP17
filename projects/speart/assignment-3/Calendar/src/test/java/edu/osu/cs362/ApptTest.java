package edu.osu.cs362;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;
import static org.junit.Assert.*;

public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=12;
		 int startMinute=30;
		 int startDay=10;
		 int startMonth=4;
		 int startYear=2017;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);

		 // assertions
		 assertTrue(appt.getValid());
		 assertEquals(12, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(10, appt.getStartDay());
		 assertEquals(04, appt.getStartMonth());
		 assertEquals(2017, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());
		 assertNotEquals(null, appt.toString());
	 }

	@Test
	public void test02()  throws Throwable  {
		int startHour=13;
		int startMinute=30;
		int startDay=10;
		int startMonth=4;
		int startYear=2017;
		String title="Birthday Party";
		String description="This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);

		Appt appts = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);

		// assertions
		assertNotEquals(null, appt.toString());
		assertTrue(appt.getValid());

		appt.setStartMonth(50);
		assertFalse(appt.getValid());

		appt.setStartMonth(-1);
		assertFalse(appt.getValid());

		appt.setStartDay(50);
		assertFalse(appt.getValid());

		appt.setStartDay(-1);
		assertFalse(appt.getValid());

		appt.setStartMinute(100);
		assertFalse(appt.getValid());

		appt.setStartMinute(-1);
		assertFalse(appt.getValid());

		appt.setStartHour(50);
		assertFalse(appt.getValid());

		appt.setStartHour(-1);
		assertFalse(appt.getValid());

		appt.setStartYear(2019);
		assertEquals(null, appt.toString());


		//Under
		appts.setStartMonth(-1);
		assertFalse(appts.getValid());

		appts.setStartDay(-1);
		assertFalse(appts.getValid());

		appts.setStartMinute(-1);
		assertFalse(appts.getValid());

		appts.setStartHour(-1);
		assertFalse(appts.getValid());

		appts.setStartYear(-1);
		assertEquals(null, appt.toString());
		assertEquals(null, appts.toString());

	}


	
}
