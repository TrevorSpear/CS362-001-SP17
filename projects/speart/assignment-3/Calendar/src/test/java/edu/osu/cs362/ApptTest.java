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
		Appt appt0 = new Appt(1, 1, 1, 11, 11, "Trial", "test");
		String string0 = appt0.toString();
		assertEquals("\t11/1/11 at 1:1am ,Trial, test\n", string0);
		assertNotNull(string0);
		assertEquals(1, appt0.getStartDay());
		appt0.setStartDay(31);
		assertEquals(31, appt0.getStartDay());
		assertEquals(1, appt0.getStartMinute());
		assertEquals("test", appt0.getDescription());
		assertEquals(11, appt0.getStartYear());
		assertEquals("Trial", appt0.getTitle());
		assertEquals(1, appt0.getStartHour());
		assertEquals(11, appt0.getStartMonth());
		appt0.setStartMinute(818);
		assertEquals(818, appt0.getStartMinute());

		appt0 = new Appt(0, 0, 0, 0, 0, (String) null, (String) null);
		string0 = appt0.getTitle();
		assertEquals(0, appt0.getStartMinute());
		assertEquals(0, appt0.getStartMonth());
		assertFalse(appt0.getValid());
		assertEquals(0, appt0.getStartHour());
		assertEquals(0, appt0.getStartDay());
		assertNotNull(string0);
		assertEquals(0, appt0.getStartYear());

		appt0 = new Appt(109, 109, 12, 109, 12, "test", "testing");
		int int0 = appt0.getStartYear();
		assertEquals("test", appt0.getTitle());
		assertEquals(12, int0);
		assertFalse(appt0.getValid());
		assertEquals(12, appt0.getStartDay());
		assertEquals(109, appt0.getStartMinute());
		assertEquals(109, appt0.getStartHour());
		assertEquals("testing", appt0.getDescription());
		assertEquals(109, appt0.getStartMonth());

		appt0 = new Appt((-79), 2328, (-79), (-709), (-709), "time testing", "description");
		int0 = appt0.getStartYear();
		assertEquals(-79, appt0.getStartHour());
		assertEquals(-709, appt0.getStartMonth());
		assertEquals(2328, appt0.getStartMinute());
		assertFalse(appt0.getValid());
		assertEquals((-709), int0);
		assertEquals("time testing", appt0.getTitle());
		assertEquals(-79, appt0.getStartDay());
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

		appt0 = new Appt(0, 59, 59, 59, 23, "test", "descript");
		int0 = appt0.getStartMonth();
		assertEquals(59, appt0.getStartDay());
		assertEquals(59, appt0.getStartMinute());
		assertEquals(23, appt0.getStartYear());
		assertEquals(59, int0);
		assertEquals(0, appt0.getStartHour());
		assertFalse(appt0.getValid());
	}

	@Test(timeout = 4000)
	public void test04()  throws Throwable  {
		Appt appt0 = new Appt((-538), (-538), (-538), (-538), 0, (String) null, (String) null);
		int int0 = appt0.getStartMinute();
		assertEquals(-538, appt0.getStartMonth());
		assertEquals(-538, appt0.getStartHour());
		assertEquals((-538), int0);
		assertEquals(-538, appt0.getStartDay());
		assertEquals(0, appt0.getStartYear());
		assertFalse(appt0.getValid());

		appt0 = new Appt(0, 0, 2714, (-1030), (-1030), "z", "z");
		int0 = appt0.getStartHour();
		assertEquals(0, appt0.getStartMinute());
		assertEquals(2714, appt0.getStartDay());
		assertFalse(appt0.getValid());
		assertEquals(-1030, appt0.getStartYear());
		assertEquals(-1030, appt0.getStartMonth());
		assertEquals(0, int0);
		assertEquals("z", appt0.getDescription());
		assertEquals("z", appt0.getTitle());

		appt0 = new Appt(1, 1, 1, 11, 11, "BasketBall is awesome to play with friends", "");
		int0 = appt0.getStartDay();
		assertEquals(1, appt0.getStartMinute());
		assertEquals(1, int0);
		assertEquals("", appt0.getDescription());
		assertTrue(appt0.getValid());
		assertEquals(11, appt0.getStartYear());
		assertEquals(11, appt0.getStartMonth());
		assertEquals("BasketBall is awesome to play with friends", appt0.getTitle());
		assertEquals(1, appt0.getStartHour());

		appt0 = new Appt((-599), (-599), (-599), (-599), (-599), "", "");
		appt0.getDescription();
		assertFalse(appt0.getValid());
		assertEquals(-599, appt0.getStartDay());
		assertEquals(-599, appt0.getStartMinute());
		assertEquals(-599, appt0.getStartMonth());
		assertEquals(-599, appt0.getStartYear());
		assertEquals(-599, appt0.getStartHour());
	}

	@Test(timeout = 4000)
	public void test05()  throws Throwable  {
		Appt appt0 = new Appt((-1078), 744, 3973, (-1078), 3973, "", "");
		appt0.setDescription("");
		assertEquals(3973, appt0.getStartYear());
		assertFalse(appt0.getValid());
		assertEquals(744, appt0.getStartMinute());
		assertEquals(-1078, appt0.getStartMonth());
		assertEquals(3973, appt0.getStartDay());
		assertEquals(-1078, appt0.getStartHour());

		appt0 = new Appt(0, 0, (-2371), 0, (-2686), (String) null, (String) null);
		appt0.setDescription((String) null);
		assertEquals(0, appt0.getStartMinute());
		assertEquals(0, appt0.getStartMonth());
		assertEquals(-2371, appt0.getStartDay());
		assertFalse(appt0.getValid());
		assertEquals(-2686, appt0.getStartYear());
		assertEquals(0, appt0.getStartHour());

		appt0 = new Appt(0, 0, 316, 316, 316, "/", "/");
		appt0.setTitle("/");
		assertEquals(316, appt0.getStartYear());
		assertEquals("/", appt0.getDescription());
		assertEquals(316, appt0.getStartDay());
		assertEquals("/", appt0.getTitle());
		assertEquals(0, appt0.getStartMinute());
		assertEquals(0, appt0.getStartHour());
		assertFalse(appt0.getValid());
		assertEquals(316, appt0.getStartMonth());

		appt0 = new Appt((-538), (-538), (-538), (-538), 0, (String) null, (String) null);
		appt0.setTitle((String) null);
		assertEquals(-538, appt0.getStartDay());
		assertEquals(-538, appt0.getStartMonth());
		assertEquals(-538, appt0.getStartHour());
		assertEquals(0, appt0.getStartYear());
		assertEquals(-538, appt0.getStartMinute());
		assertFalse(appt0.getValid());

		appt0 = new Appt(0, 0, 316, 316, 316, "/", "/");
		String string0 = appt0.getDescription();
		assertEquals(316, appt0.getStartYear());
		assertEquals(0, appt0.getStartHour());
		assertFalse(appt0.getValid());
		assertEquals(316, appt0.getStartMonth());
		assertEquals("/", string0);
		assertEquals("/", appt0.getTitle());
		assertEquals(0, appt0.getStartMinute());
		assertEquals(316, appt0.getStartDay());

		appt0 = new Appt(12, 12, 12, (-1023), (-1023), "Dogs are awesome", "Cats are too");
		assertEquals(-1023, appt0.getStartMonth());

		appt0.setStartMonth(12);
		string0 = appt0.toString();
		assertEquals("\t12/12/-1023 at 12:12pm ,Dogs are awesome, Cats are too\n", string0);

		appt0 = new Appt(23, 23, 23, 23, 23, "", "");
		assertEquals(23, appt0.getStartMonth());
		assertEquals(23, appt0.getStartDay());
		assertEquals(23, appt0.getStartMinute());
		assertEquals(23, appt0.getStartYear());
		assertEquals(23, appt0.getStartHour());
		assertFalse(appt0.getValid());

		appt0 = new Appt((-413), (-413), (-413), -1984, 0, "Tennis is fun", "Football is too");
		int int0 = appt0.getStartYear();
		assertFalse(appt0.getValid());
		assertEquals(0, int0);
		assertEquals(-413, appt0.getStartMinute());
		assertEquals("Tennis is fun", appt0.getTitle());
		assertEquals(-413, appt0.getStartHour());
		assertEquals(-1984, appt0.getStartMonth());
		assertEquals("Football is too", appt0.getDescription());
		assertEquals(-413, appt0.getStartDay());

		appt0 = new Appt(11, 1, 1, (-1078), 2907, "", "");
		assertEquals(11, appt0.getStartHour());
		assertEquals(2907, appt0.getStartYear());
		assertEquals(1, appt0.getStartDay());
		assertEquals(1, appt0.getStartMinute());
		assertEquals(-1078, appt0.getStartMonth());
		string0 = appt0.toString();
		assertFalse(appt0.getValid());
		appt0.setStartMonth(1);
		appt0.setStartYear((-1078));
	}
	
}