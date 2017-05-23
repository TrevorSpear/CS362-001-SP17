
/*
 * TimeTable.java
 *
 */
package edu.osu.cs362;
/**
 * 
* This class collects appointments between given two dates.
* 
* adapted from Paul Miles
*/
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;






public class TimeTable {

	
    public TimeTable() {

    }
	
    
    /**
     * Retrieves a range of appointments between two dates.
     * @return A list of all of the CalDays between firstDate (inclusive)
     *  and lastDate (exclusive) with their respective appointments. 
     * @throws IllegalArgumentException If any of the days constructed by the
     *  given values are invalid, or if lastDay is not after firstDay.
     **/
	  public LinkedList<CalDay> getApptRange(LinkedList<Appt> appts,GregorianCalendar firstDay, GregorianCalendar lastDay){
		  
		     //Create a linked list of calendar days <CalDay> to return
	        LinkedList<CalDay> calDays = new LinkedList<CalDay>();
	     
	        //Make sure that the first day is before the last day
	        if (!firstDay.before(lastDay)) {
	        	throw new IllegalArgumentException ("Second date specified is not " +
	                "before the first date specified.");
	        }
	        
	        
	        //Create the first CalDay object with the starting date and add to list
	        GregorianCalendar nextDay = (GregorianCalendar) firstDay.clone();
	        while (nextDay.before(lastDay)) {
	            calDays.add(new CalDay(nextDay));
	            nextDay.add(nextDay.DAY_OF_MONTH, 1);
	        }
	        
	        //Retrieve the appts - <appt> 
		for (int i = 0; i < appts.size(); i++) {
			Appt appt=appts.get(i);
			if(!appt.getValid()) continue;
			// Figure out which days the appointment occurs on
			LinkedList<GregorianCalendar> apptOccursOnDays = getApptOccurences(
					appt, firstDay, lastDay);

			// For each day in the list, calculate the difference between the
			// first day and the day of occurrence and add the appointment to
			// the correct CalDay
			int daysDifference = 0;
			nextDay = (GregorianCalendar) firstDay.clone();
			Iterator<GregorianCalendar> itr = apptOccursOnDays.iterator();
			while (itr.hasNext()) {
				GregorianCalendar apptOccursOn = (GregorianCalendar) itr.next();

				while (nextDay.before(apptOccursOn)) {
					daysDifference++;
					nextDay.add(nextDay.DAY_OF_MONTH, 1);
				}

				CalDay calDayOfAppt = (CalDay) calDays.get(daysDifference);
				calDayOfAppt.addAppt(appt);

			}

		}
		  return calDays;
	  }
	   /**
	     * This takes the given appointment and constructs a linked list of 
	     * GregorianCalendar's, each of which represent a day when the appointment
	     * occurs. The days are guaranteed to be between firstDay (inclusive) and
	     * lastDay (exclusive). They are guaranteed to be in order.
	     **/
	    private static LinkedList<GregorianCalendar> getApptOccurences(Appt appt, 
	        GregorianCalendar firstDay, GregorianCalendar lastDay) {
	        
	        LinkedList<GregorianCalendar> result = new LinkedList<GregorianCalendar>();
	        
	        //Make sure that the firstDay is before the last day
	        if (!firstDay.before(lastDay)) {
	            return result;
	        }
	        
	        //Get the first recurrence taken care of
	        GregorianCalendar occurrenceDay = 
	                new GregorianCalendar(appt.getStartYear(), appt.getStartMonth(), 
	                    appt.getStartDay());
	        
	        //If the first occurrence is after the last day, then it doesn't matter
	        //when it recurs because those dates must be after the last day too
	        if (!occurrenceDay.before(lastDay)) {
	            return result;
	        }
	        
	            
	            //Add the day of occurrence to the list if it is after the first day
	            if (!occurrenceDay.before(firstDay)) {
	                result.add(occurrenceDay);
	            }
	        
	        return result;
	    }
	    /**
	     * Deletes the appointment's information from the appointments data list. 
	     * @return updated list of appointments if the appointment is deleted successfully, otherwise null.
	     **/
	    public LinkedList<Appt> deleteAppt(LinkedList<Appt> appts,Appt appt) {
	    	//Do not do anything to appts equals to null 
	        if(appts==null||appt==null)
        		return null;
	    	//Do not do anything to invalid appointments
	        if (!appt.getValid()) {
	            return null;
	        }

	        //Remove the appointment from the list appts if applicable
	        
	        for(int i=0;i<appts.size();i++){
	        	Appt tempAppt=appts.get(i);
	        	if(tempAppt.equals(appt)){
	        		appts.remove(i);
	        		return appts;
	        	}
	        		
	        }
	        return null;
	    }
}
