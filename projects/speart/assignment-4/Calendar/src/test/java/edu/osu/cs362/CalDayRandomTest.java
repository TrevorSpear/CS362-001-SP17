package edu.osu.cs362;


import org.junit.Test;


import java.util.GregorianCalendar;
import java.util.Random;

import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	
    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void randomtest()  throws Throwable  {
		 Random random = new Random();
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
	 }


	
}
