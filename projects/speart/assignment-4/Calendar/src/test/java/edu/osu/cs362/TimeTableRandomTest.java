package edu.osu.cs362;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {

	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
	public static String RandomSelectMethod(Random random){
		String[] methodArray = new String[] {"delete","Range"};// The list of the of methods to be tested in the Appt class

		int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

		return methodArray[n] ; // return the method name
	}

    /**
     * Generate Random Tests that tests TimeTable Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 System.out.println("Start testing...");
		 for (int iteration = 0; elapsed < TestTimeout; iteration++) {
			 Random random = new Random();

			 Appt appt = new Appt(
					 ValuesGenerator.getRandomIntBetween(random, 1, 24), //hour
					 ValuesGenerator.getRandomIntBetween(random, 1, 60), //min
					 ValuesGenerator.getRandomIntBetween(random, 1, 30), //Day
					 ValuesGenerator.getRandomIntBetween(random, 1, 12), //month
					 ValuesGenerator.getRandomIntBetween(random, 2000, 2050),
					 ValuesGenerator.getString(random), //title
					 ValuesGenerator.getString(random) //description
			 );

			 Appt apptS = new Appt(
					 ValuesGenerator.getRandomIntBetween(random, 1, 24), //hour
					 ValuesGenerator.getRandomIntBetween(random, 1, 60), //min
					 ValuesGenerator.getRandomIntBetween(random, 1, 30), //Day
					 ValuesGenerator.getRandomIntBetween(random, 1, 12), //month
					 ValuesGenerator.getRandomIntBetween(random, 2100, 2120),
					 ValuesGenerator.getString(random), //title
					 ValuesGenerator.getString(random) //description
			 );

			 Appt apptY = new Appt(
					 ValuesGenerator.getRandomIntBetween(random, 1, 24), //hour
					 ValuesGenerator.getRandomIntBetween(random, 1, 59), //min
					 ValuesGenerator.getRandomIntBetween(random, 1, 30), //Day
					 ValuesGenerator.getRandomIntBetween(random, 1, 12), //month
					 ValuesGenerator.getRandomIntBetween(random, 2000, 2050),
					 ValuesGenerator.getString(random), //title
					 ValuesGenerator.getString(random) //description
			 );

			 GregorianCalendar cal = new GregorianCalendar();
			 cal.set(
					 ValuesGenerator.getRandomIntBetween(random, 2000, 2040),		//year
					 ValuesGenerator.getRandomIntBetween(random, 1, 12), 			//month
					 ValuesGenerator.getRandomIntBetween(random, 1, 12), 			//day
					 ValuesGenerator.getRandomIntBetween(random, 1, 24), 			//hour
					 ValuesGenerator.getRandomIntBetween(random, 1, 60), 			//minute
					 ValuesGenerator.getRandomIntBetween(random, 1, 60)     		//second
			 );

			 GregorianCalendar gCal = new GregorianCalendar();
			 gCal.set(
					 ValuesGenerator.getRandomIntBetween(random, 2050, 2060), 	//year
					 ValuesGenerator.getRandomIntBetween(random, 1, 12), 			//month
					 ValuesGenerator.getRandomIntBetween(random, 1, 12), 			//day
					 ValuesGenerator.getRandomIntBetween(random, 1, 24), 			//hour
					 ValuesGenerator.getRandomIntBetween(random, 1, 60), 			//minute
					 ValuesGenerator.getRandomIntBetween(random, 1, 60)     		//second
			 );

			 GregorianCalendar goCal = new GregorianCalendar();
			 goCal.set(
					 ValuesGenerator.getRandomIntBetween(random, 2060, 2070), 	//year
					 ValuesGenerator.getRandomIntBetween(random, 1, 12), 			//month
					 ValuesGenerator.getRandomIntBetween(random, 1, 12), 			//day
					 ValuesGenerator.getRandomIntBetween(random, 1, 24), 			//hour
					 ValuesGenerator.getRandomIntBetween(random, 1, 60), 			//minute
					 ValuesGenerator.getRandomIntBetween(random, 1, 60)     		//second
			 );

			 TimeTable timeTable = new TimeTable();
			 CalDay calDay = new CalDay(cal);
			 calDay.addAppt(appt);
			 calDay.addAppt(apptS);

			 String methodName = TimeTableRandomTest.RandomSelectMethod(random);
			 if (methodName.equals("Range")) {
				 //Get Range
				 timeTable.getApptRange(calDay.getAppts(), cal, gCal);
				 timeTable.getApptRange(calDay.getAppts(), cal, goCal);

			 }else if (methodName.equals("delete")) {
				 //Testing delete
				 timeTable.deleteAppt(calDay.getAppts(), appt);
				 assertEquals(null, timeTable.deleteAppt(calDay.getAppts(), apptY));
				 calDay.addAppt(apptY);
				 timeTable.getApptRange(calDay.getAppts(), cal, gCal);

				 assertEquals(null, timeTable.deleteAppt(null, null));
				 assertEquals(null, timeTable.deleteAppt(calDay.getAppts(), null));

				 apptY = new Appt(
						 ValuesGenerator.getRandomIntBetween(random, 1, 24), //hour
						 ValuesGenerator.getRandomIntBetween(random, 1, 59), //min
						 ValuesGenerator.getRandomIntBetween(random, 1, 30), //Day
						 ValuesGenerator.getRandomIntBetween(random, 1, 12), //month
						 ValuesGenerator.getRandomIntBetween(random, 2000, 2050),
						 ValuesGenerator.getString(random), //title
						 ValuesGenerator.getString(random) //description
				 );

				 assertEquals(null, timeTable.deleteAppt(calDay.getAppts(), apptY));

			 }

			 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			 System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);



		 }

		 System.out.println("Done testing...");
	 }
}
