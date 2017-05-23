package edu.osu.cs362;


import org.junit.Test;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {

	private static final long TestTimeout = 60 * 50 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
	public static String RandomSelectMethod(Random random){
		String[] methodArray = new String[] {"setTitle","setDescription"};// The list of the of methods to be tested in the Appt class

		int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

		return methodArray[n] ; // return the method name
	}

    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void randomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 System.out.println("Start testing...");
		 for (int iteration = 0; elapsed < TestTimeout; iteration++) {

			 Random random = new Random();
			 GregorianCalendar cal = new GregorianCalendar();
			 cal.set(
					 ValuesGenerator.getRandomIntBetween(random, 2000, 2040),        //year
					 ValuesGenerator.getRandomIntBetween(random, 1, 12),            //month
					 ValuesGenerator.getRandomIntBetween(random, 1, 12),            //day
					 ValuesGenerator.getRandomIntBetween(random, 1, 24),            //hour
					 ValuesGenerator.getRandomIntBetween(random, 1, 60),            //minute
					 ValuesGenerator.getRandomIntBetween(random, 1, 60)            //second
			 );

			 CalDay calDay = new CalDay(cal);

			 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			 if ((iteration % 10000) == 0 && iteration != 0)
				 System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);
		 }

		 System.out.println("Done testing...");
	 }
}
