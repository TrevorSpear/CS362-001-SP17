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
	
    /**
     * Generate Random Tests that tests TimeTable Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {

		 for(int i = 0; i < 200; i++) {
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

			 //Construct a new Appointment object with the initial data
			 Appt apptS = new Appt(
					 ValuesGenerator.getRandomIntBetween(random, 1, 24), //hour
					 ValuesGenerator.getRandomIntBetween(random, 1, 60), //min
					 ValuesGenerator.getRandomIntBetween(random, 1, 30), //Day
					 ValuesGenerator.getRandomIntBetween(random, 1, 12), //month
					 ValuesGenerator.getRandomIntBetween(random, 2100, 2120),
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

			 CalDay calDay = new CalDay(cal);
			 calDay.addAppt(appt);
			 calDay.addAppt(apptS);

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
			 timeTable.getApptRange(calDay.getAppts(), cal, gCal);
			 timeTable.getApptRange(calDay.getAppts(), cal, goCal);
			 timeTable.deleteAppt(calDay.getAppts(), appt);

			 //Construct a new Appointment object with the initial data
			 Appt apptY = new Appt(
					 ValuesGenerator.getRandomIntBetween(random, 1, 24), //hour
					 ValuesGenerator.getRandomIntBetween(random, 1, 60), //min
					 ValuesGenerator.getRandomIntBetween(random, 1, 30), //Day
					 ValuesGenerator.getRandomIntBetween(random, 1, 12), //month
					 ValuesGenerator.getRandomIntBetween(random, 2000, 2050),
					 ValuesGenerator.getString(random), //title
					 ValuesGenerator.getString(random) //description
			 );


			 assertEquals(null, timeTable.deleteAppt(calDay.getAppts(), apptY));
			 calDay.addAppt(apptY);
			 timeTable.getApptRange(calDay.getAppts(), cal, gCal);

			 assertEquals(null, timeTable.deleteAppt(null, null));
			 assertEquals(null, timeTable.deleteAppt(calDay.getAppts(), null));

			 apptY = new Appt(
					 ValuesGenerator.getRandomIntBetween(random, 1, 24), //hour
					 ValuesGenerator.getRandomIntBetween(random, 1, 60), //min
					 ValuesGenerator.getRandomIntBetween(random, 1, 30), //Day
					 ValuesGenerator.getRandomIntBetween(random, 1, 12), //month
					 ValuesGenerator.getRandomIntBetween(random, 2000, 2050),
					 ValuesGenerator.getString(random), //title
					 ValuesGenerator.getString(random) //description
			 );


			 assertEquals(null, timeTable.deleteAppt(calDay.getAppts(), apptY));
			 calDay.addAppt(apptY);
		 }
	 }
}
