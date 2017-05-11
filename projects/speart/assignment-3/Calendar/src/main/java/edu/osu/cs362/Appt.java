/*
 * Appt.java
 *
 */

package edu.osu.cs362;

/**
 *  This class represents a single appointment that might be stored in
 *  a timetable.  The appointment consists of startHour, startMinute,
 *   startDay, startMonth, startYear, title, and description
 *   
 *   
 *  Adapted from  Paul Miles
 */
/**
 * Stores the data of an appointment
 */
public class Appt {
    
    /** Used for knowing whether or not an appointment is valid or not */
    private boolean valid;
    
	/** The starting hour of the appointment */
    private int startHour;
    
    /** The starting minute of the appointment */
    private int startMinute;
    
    /** The starting day of the appointment */
    private int startDay;
    
    /** The starting month of the appointment */
    private int startMonth;
    
    /** The starting year of the appointment */
    private int startYear;

    /** The title or caption of the appointment */
    private String title;

    /** The description of the appointment */
    private String description;
    



    // ----------------------------------------------------------
    /**
     * Creates a new Appointment object.
     * @param startHour The hour that the appointment starts on. The hours are
     *      numbered 0-23 to represent 12a.m. to 11pm on the day specified.
     * @param startMinute The minute of the hour the appointment starts on.
     * @param startDay The day of the month the appointment starts on.
     * @param startMonth The month of the year the appointment starts on.
     * @param startYear The year the appointment starts on.
     * @param title The title or caption to give the appointment
     * @param description The appointment's details
     */
    public Appt(int startHour, int startMinute, 
            int startDay, int startMonth, int startYear,String title, String description)
    {
        //Sets all instance variables 
    	this.startHour = startHour;
    	this.startMinute = startMinute; 
    	this.startDay = startDay; 
    	this.startMonth = startMonth;
    	this.startYear = startYear; 
        setTitle(title);
        setDescription(description);
        isValid();
    }


  
    /**
     * @sets valid to true if the appointment is valid
     */
    private void isValid() {
    	if(startHour<0 || startHour>23)
    		this.valid=false;
    	else
        	if(startMinute<0 || startMinute>59)
        		this.valid=false;
        	else
            	if(startDay<1 || startDay>31)
            		this.valid=false;
            	else
                	if(startMonth<1 || startMonth>12)
                		this.valid=false;
                	else
                		this.valid=true;
    }
    


    /** Sets startHour */
    public void setStartHour(int startHour) {
    	this.startHour = startHour;
    	 isValid();
    }
    
    /** Sets startHour */
    public void setStartMinute(int startMinute) {   	
        this.startMinute = startMinute;
        isValid();
    }

    /** Sets startDay */
    public void setStartDay(int startDay) {
        this.startDay = startDay;
        isValid();
    }
    
    /** Sets startMonth */
    public void setStartMonth(int startMonth) {
        this.startMonth = startMonth;
        isValid();
    }
    
    /** Sets startYear */
    public void setStartYear(int startYear) {
        this.startYear = startYear;
        isValid();
    }

    /** Sets title */
    public void setTitle(String title) {
        if (title == null) 
            this.title = "";
        else
            this.title = title;
    }
    
    /** Sets description */
    public void setDescription(String description) {
        if (description == null)
            this.description = "";
        else
            this.description = description;
    }
 
    
    /** Gets startHour */
    public int getStartHour() {
        return startHour;
    }
    
    /** Gets startHour */
    public int getStartMinute() {
        return startMinute;
    }
    
    /** Gets startDay */
    public int getStartDay() {
        return startDay;
    }
    
    /** Gets startMonth */
    public int getStartMonth() {
        return startMonth;
    }
    
    /** Gets startYear */
    public int getStartYear() {
        return startYear;
    }
 
    /** Gets title */
    public String getTitle() {
        return title;
    }
    
    /** Gets description */
    public String getDescription() {
        return description;
    }
    /** Gets description */
    public boolean getValid() {
        return this.valid;
    }
    // ----------------------------------------------------------
    /**
     * Generate a string representation for this appointment, with the
     * form "11am: dentist" or "2:00pm: class".  The string consists of the
     * 12-hour time representation with a (lower case) "am" or "pm"
     * designator, followed by a colon and space, and then the appointment
     * description.
     * @return a printable representation of this appointment
     */
    public String toString()
    {
		if (!getValid()) {
		    return null;
		}
        String half = (getStartHour() > 11) ? "pm" : "am";
        int printableHour = getStartHour();
        if (printableHour > 11)
        {
            printableHour -= 12;
        }
        if (printableHour == 0)
        {
            printableHour = 12;
        }
        String day= this.getStartMonth()+"/"+this.getStartDay()+"/"+this.getStartYear() + " at ";
        return "\t"+ day +   printableHour +":"+ getStartMinute() + half + " ," +  getTitle()+ ", "+  getDescription()+"\n";
    }


}
