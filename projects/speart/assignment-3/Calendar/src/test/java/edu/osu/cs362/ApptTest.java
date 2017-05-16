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


	@Test
	public void test03()  throws Throwable  {
		Appt appt0 = new Appt(1, 1, 1, 1, 1, "Trial", "test");
		String string0 = appt0.toString();
		assertEquals("\t1/1/1 at 1:1am ,Trial, test\n", string0);
		assertNotNull(string0);
		assertEquals(1, appt0.getStartDay());
		appt0.setStartDay(25);
		assertEquals(25, appt0.getStartDay());
		assertEquals(1, appt0.getStartMinute());
		assertEquals("test", appt0.getDescription());
		assertEquals(1, appt0.getStartYear());
		assertEquals("Trial", appt0.getTitle());
		assertEquals(1, appt0.getStartHour());
		assertEquals(1, appt0.getStartMonth());
		appt0.setStartMinute(750);
		assertEquals(750, appt0.getStartMinute());

		appt0 = new Appt(0, 0, 0, 0, 0, (String) null, (String) null);
		string0 = appt0.getTitle();
		assertEquals(0, appt0.getStartMinute());
		assertEquals(0, appt0.getStartMonth());
		assertFalse(appt0.getValid());
		assertEquals(0, appt0.getStartHour());
		assertEquals(0, appt0.getStartDay());
		assertNotNull(string0);
		assertEquals(0, appt0.getStartYear());

		appt0 = new Appt(150, 150, 15, 150, 15, "test", "testing");
		int int0 = appt0.getStartYear();
		assertEquals("test", appt0.getTitle());
		assertEquals(15, int0);
		assertFalse(appt0.getValid());
		assertEquals(15, appt0.getStartDay());
		assertEquals(150, appt0.getStartMinute());
		assertEquals(150, appt0.getStartHour());
		assertEquals("testing", appt0.getDescription());
		assertEquals(150, appt0.getStartMonth());

		appt0 = new Appt((-69), 2500, (-69), (-69), (-69), "time testing", "description");
		int0 = appt0.getStartYear();
		assertEquals(-69, appt0.getStartHour());
		assertEquals(-69, appt0.getStartMonth());
		assertEquals(2500, appt0.getStartMinute());
		assertFalse(appt0.getValid());
		assertEquals((-69), int0);
		assertEquals("time testing", appt0.getTitle());
		assertEquals(-69, appt0.getStartDay());
		assertEquals("description", appt0.getDescription());

		appt0 = new Appt((-1), (-1), (-1), 0, 0, "The test", "the description");
		int0 = appt0.getStartMonth();
		assertEquals(-1, appt0.getStartHour());
		assertEquals("The test", appt0.getTitle());
		assertEquals(-1, appt0.getStartMinute());
		assertFalse(appt0.getValid());
		assertEquals(0, appt0.getStartYear());
		assertEquals("the description", appt0.getDescription());
		assertEquals(0, int0);
		assertEquals(-1, appt0.getStartDay());

		appt0 = new Appt(69, 69, 69, 69, 69, "test", "descript");
		int0 = appt0.getStartMonth();
		assertEquals(69, appt0.getStartDay());
		assertEquals(69, appt0.getStartMinute());
		assertEquals(69, appt0.getStartYear());
		assertEquals(69, int0);
		assertEquals(69, appt0.getStartHour());
		assertFalse(appt0.getValid());
	}

	@Test
	public void test04()  throws Throwable  {
		Appt appt0 = new Appt((-500), (-500), (-500), (-500), 0, (String) null, (String) null);
		int int0 = appt0.getStartMinute();
		assertEquals(-500, appt0.getStartMonth());
		assertEquals(-500, appt0.getStartHour());
		assertEquals((-500), int0);
		assertEquals(-500, appt0.getStartDay());
		assertEquals(0, appt0.getStartYear());
		assertFalse(appt0.getValid());

		appt0 = new Appt(0, 0, 2500, (-1500), (-1500), "z", "z");
		int0 = appt0.getStartHour();
		assertEquals(0, appt0.getStartMinute());
		assertEquals(2500, appt0.getStartDay());
		assertFalse(appt0.getValid());
		assertEquals(-1500, appt0.getStartYear());
		assertEquals(-1500, appt0.getStartMonth());
		assertEquals(0, int0);
		assertEquals("z", appt0.getDescription());
		assertEquals("z", appt0.getTitle());

		appt0 = new Appt((-500), (-500), (-500), (-500), (-500), "", "");
		appt0.getDescription();
		assertFalse(appt0.getValid());
		assertEquals(-500, appt0.getStartDay());
		assertEquals(-500, appt0.getStartMinute());
		assertEquals(-500, appt0.getStartMonth());
		assertEquals(-500, appt0.getStartYear());
		assertEquals(-500, appt0.getStartHour());
	}

	@Test
	public void test05()  throws Throwable  {
		Appt appt0 = new Appt((-1500), 750, 2500, (-1500), 2500, "", "");
		appt0.setDescription("");
		assertEquals(2500, appt0.getStartYear());
		assertFalse(appt0.getValid());
		assertEquals(750, appt0.getStartMinute());
		assertEquals(-1500, appt0.getStartMonth());
		assertEquals(2500, appt0.getStartDay());
		assertEquals(-1500, appt0.getStartHour());

		appt0 = new Appt(0, 0, (-2500), 0, (-2500), (String) null, (String) null);
		appt0.setDescription((String) null);
		assertEquals(0, appt0.getStartMinute());
		assertEquals(0, appt0.getStartMonth());
		assertEquals(-2500, appt0.getStartDay());
		assertFalse(appt0.getValid());
		assertEquals(-2500, appt0.getStartYear());
		assertEquals(0, appt0.getStartHour());

		appt0 = new Appt(0, 0, 250, 250, 250, "/", "/");
		appt0.setTitle("/");
		assertEquals(250, appt0.getStartYear());
		assertEquals("/", appt0.getDescription());
		assertEquals(250, appt0.getStartDay());
		assertEquals("/", appt0.getTitle());
		assertEquals(0, appt0.getStartMinute());
		assertEquals(0, appt0.getStartHour());
		assertFalse(appt0.getValid());
		assertEquals(250, appt0.getStartMonth());

		appt0 = new Appt((-500), (-500), (-500), (-500), 0, (String) null, (String) null);
		appt0.setTitle((String) null);
		assertEquals(-500, appt0.getStartDay());
		assertEquals(-500, appt0.getStartMonth());
		assertEquals(-500, appt0.getStartHour());
		assertEquals(0, appt0.getStartYear());
		assertEquals(-500, appt0.getStartMinute());
		assertFalse(appt0.getValid());

		appt0 = new Appt(0, 0, 250, 250, 250, "/", "/");
		String string0 = appt0.getDescription();
		assertEquals(250, appt0.getStartYear());
		assertEquals(0, appt0.getStartHour());
		assertFalse(appt0.getValid());
		assertEquals(250, appt0.getStartMonth());
		assertEquals("/", string0);
		assertEquals("/", appt0.getTitle());
		assertEquals(0, appt0.getStartMinute());
		assertEquals(250, appt0.getStartDay());

		appt0 = new Appt(15, 15, 15, (-1500), (-1500), "Dogs are awesome", "Cats are too");
		assertEquals(-1500, appt0.getStartMonth());

		appt0.setStartMonth(15);
		string0 = appt0.toString();
		assertNull(string0);

		appt0 = new Appt(25, 25, 25, 25, 25, "", "");
		assertEquals(25, appt0.getStartMonth());
		assertEquals(25, appt0.getStartDay());
		assertEquals(25, appt0.getStartMinute());
		assertEquals(25, appt0.getStartYear());
		assertEquals(25, appt0.getStartHour());
		assertFalse(appt0.getValid());

		appt0 = new Appt((-500), (-500), (-500), -500, 0, "Tennis is fun", "Football is too");
		int int0 = appt0.getStartYear();
		assertFalse(appt0.getValid());
		assertEquals(0, int0);
		assertEquals(-500, appt0.getStartMinute());
		assertEquals("Tennis is fun", appt0.getTitle());
		assertEquals(-500, appt0.getStartHour());
		assertEquals(-500, appt0.getStartMonth());
		assertEquals("Football is too", appt0.getDescription());
		assertEquals(-500, appt0.getStartDay());

		appt0 = new Appt(15, 15, 15, (-2500), 2500, "", "");
		assertEquals(15, appt0.getStartHour());
		assertEquals(2500, appt0.getStartYear());
		assertEquals(15, appt0.getStartDay());
		assertEquals(15, appt0.getStartMinute());
		assertEquals(-2500, appt0.getStartMonth());
		string0 = appt0.toString();
		assertFalse(appt0.getValid());
		appt0.setStartMonth(1);
		appt0.setStartYear((-500));
	}
	
}