package edu.osu.cs362;

import java.util.Calendar;
import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;



/**
 * Random Test Generator  for Appt class.
 */

public class ApptRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"setTitle","setDescription","hour","min","day","month"};// The list of the of methods to be tested in the Appt class

    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)
    	            
        return methodArray[n] ; // return the method name 
        }
	
    /**
     * Generate Random Tests that tests Appt Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 
		 System.out.println("Start testing...");
		 
		 
		 for (int iteration = 0; elapsed < TestTimeout; iteration++) {
			 long randomseed = 10;
			 Random random = new Random(randomseed);

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
			 for (int i = 0; i < NUM_TESTS; i++) {
				 String methodName = ApptRandomTest.RandomSelectMethod(random);
				 random = new Random();
				 if (methodName.equals("setDescription")) {
					 String Description = "LOL";
					 appt.setDescription(Description);
					 assertEquals(appt.getDescription(), Description);

				 } else if ( methodName.equals("hour") ) {
					 //hour
					 appt = new Appt(
							 ValuesGenerator.getRandomIntBetween(random, -30, 60), //hour
							 ValuesGenerator.getRandomIntBetween(random, 1, 59), //min
							 ValuesGenerator.getRandomIntBetween(random, 1, 30), //Day
							 ValuesGenerator.getRandomIntBetween(random, 1, 12), //month
							 ValuesGenerator.getRandomIntBetween(random, 2000, 2050),
							 ValuesGenerator.getString(random), //title
							 ValuesGenerator.getString(random) //description
					 );
					 assertEquals(testingValid(0,23, appt.getStartHour()), appt.getValid());

					 appt = new Appt(
							 ValuesGenerator.getRandomIntBetween(random, -30, 60), //hour
							 ValuesGenerator.getRandomIntBetween(random, 1, 59), //min
							 ValuesGenerator.getRandomIntBetween(random, 1, 30), //Day
							 ValuesGenerator.getRandomIntBetween(random, 1, 12), //month
							 ValuesGenerator.getRandomIntBetween(random, 2000, 2050),
							 ValuesGenerator.getString(random), //title
							 ValuesGenerator.getString(random) //description
					 );
					 assertEquals(testingValid(0,23, appt.getStartHour()), appt.getValid());

				 } else if ( methodName.equals("min") ) {

					 //min
					 appt = new Appt(
							 ValuesGenerator.getRandomIntBetween(random, 1, 23), //hour
							 ValuesGenerator.getRandomIntBetween(random, -30, 90), //min
							 ValuesGenerator.getRandomIntBetween(random, 1, 30), //Day
							 ValuesGenerator.getRandomIntBetween(random, 1, 12), //month
							 ValuesGenerator.getRandomIntBetween(random, 2000, 2050),
							 ValuesGenerator.getString(random), //title
							 ValuesGenerator.getString(random) //description
					 );
					 assertEquals(testingValid(0,59, appt.getStartMinute()), appt.getValid());

					 appt = new Appt(
							 ValuesGenerator.getRandomIntBetween(random, 1, 23), //hour
							 ValuesGenerator.getRandomIntBetween(random, -30, 90), //min
							 ValuesGenerator.getRandomIntBetween(random, 1, 30), //Day
							 ValuesGenerator.getRandomIntBetween(random, 1, 12), //month
							 ValuesGenerator.getRandomIntBetween(random, 2000, 2050),
							 ValuesGenerator.getString(random), //title
							 ValuesGenerator.getString(random) //description
					 );
					 assertEquals(testingValid(0,59, appt.getStartMinute()), appt.getValid());

				 } else if ( methodName.equals("day") ) {

					 //Day
					 appt = new Appt(
							 ValuesGenerator.getRandomIntBetween(random, 1, 23), //hour
							 ValuesGenerator.getRandomIntBetween(random, 1, 59), //min
							 ValuesGenerator.getRandomIntBetween(random, -30, 60), //Day
							 ValuesGenerator.getRandomIntBetween(random, 1, 12), //month
							 ValuesGenerator.getRandomIntBetween(random, 2000, 2050),
							 ValuesGenerator.getString(random), //title
							 ValuesGenerator.getString(random) //description
					 );
					 assertEquals(testingValid(1,31, appt.getStartDay()), appt.getValid());

					 appt = new Appt(
							 ValuesGenerator.getRandomIntBetween(random, 1, 23), //hour
							 ValuesGenerator.getRandomIntBetween(random, 1, 59), //min
							 ValuesGenerator.getRandomIntBetween(random, -30, 60), //Day
							 ValuesGenerator.getRandomIntBetween(random, 1, 12), //month
							 ValuesGenerator.getRandomIntBetween(random, 2000, 2050),
							 ValuesGenerator.getString(random), //title
							 ValuesGenerator.getString(random) //description
					 );
					 assertEquals(testingValid(1,31, appt.getStartDay()), appt.getValid());

				 } else if ( methodName.equals("month") ) {

					 //month
					 appt = new Appt(
							 ValuesGenerator.getRandomIntBetween(random, 1, 23), //hour
							 ValuesGenerator.getRandomIntBetween(random, 1, 59), //min
							 ValuesGenerator.getRandomIntBetween(random, 1, 30), //Day
							 ValuesGenerator.getRandomIntBetween(random, -12, 24), //month
							 ValuesGenerator.getRandomIntBetween(random, 2000, 2050),
							 ValuesGenerator.getString(random), //title
							 ValuesGenerator.getString(random) //description
					 );
					 assertEquals(testingValid(1,12, appt.getStartMonth()), appt.getValid());

					 appt = new Appt(
							 ValuesGenerator.getRandomIntBetween(random, 1, 23), //hour
							 ValuesGenerator.getRandomIntBetween(random, 1, 59), //min
							 ValuesGenerator.getRandomIntBetween(random, 1, 30), //Day
							 ValuesGenerator.getRandomIntBetween(random, -100, -1), //month
							 ValuesGenerator.getRandomIntBetween(random, 2000, 2050),
							 ValuesGenerator.getString(random), //title
							 ValuesGenerator.getString(random) //description
					 );
					 assertEquals(testingValid(1,12, appt.getStartMonth()), appt.getValid());

				 }

			 }

			 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			 if ((iteration % 10000) == 0 && iteration != 0)
				 System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);

		 }
	 
		 System.out.println("Done testing...");
	 }

	private boolean testingValid(int Min, int Max, int random){
	 	if(random < Min || random > Max){
	 		return false;
		}
		return true;
	}
	
}
