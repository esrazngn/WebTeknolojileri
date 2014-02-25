package conference;

import java.util.Date;

//*********************************************************
/**
 * This class represents a registration for an
 * conference-registration web application
 *
 * @version 1.0
 * @author krazykoder.com
*/
//*********************************************************
public class RegistrationBean implements java.io.Serializable
{
	
	static final long serialVersionUID = 7152930220458171071L;
	
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private int attendees;
    private int cds;
    private boolean guildmember;
    private Date date;
    private int confirmationNumber;

    private static final double conferencePrice = 1000;
    private static final double cdPrice = 50;
    private static final double guildDiscount = 0.10;

    //*****************************************************
    /** Retrieve the name property
    *
    *   @return The current name
    */
    //*****************************************************
    public String getName()
    {
        return this.name;
    }

    //*****************************************************
    /** Set the name property
    *
    *   @param name The new name
    */
    //*****************************************************
    public void setName ( String name )
    {
        this.name = name;
    }

    //*****************************************************
    /** Retrieve the address property
    *
    *   @return The current address
    */
    //*****************************************************
    public String getAddress()
    {
        return this.address;
    }

    //*****************************************************
    /** Set the address property
    *
    *   @param address The new address
    */
    //*****************************************************
    public void setAddress ( String address )
    {
        this.address = address;
    }

    //*****************************************************
    /** Retrieve the city property
    *
    *   @return The current city
    */
    //*****************************************************
    public String getCity()
    {
        return this.city;
    }

    //*****************************************************
    /** Set the city property
    *
    *   @param city The new city
    */
    //*****************************************************
    public void setCity ( String city )
    {
        this.city = city;
    }

    //*****************************************************
    /** Retrieve the state property
    *
    *   @return The current state
    */
    //*****************************************************
    public String getState()
    {
        return this.state;
    }

    //*****************************************************
    /** Set the state property
    *
    *   @param state The new state
    */
    //*****************************************************
    public void setState ( String state )
    {
        this.state = state;
    }

    //*****************************************************
    /** Retrieve the zip property
    *
    *   @return The current zip
    */
    //*****************************************************
    public String getZip()
    {
        return this.zip;
    }

    //*****************************************************
    /** Set the zip property
    *
    *   @param zip The new zip
    */
    //*****************************************************
    public void setZip ( String zip )
    {
        this.zip = zip;
    }

    //*****************************************************
    /** Retrieve the attendees property
    *
    *   @return The current attendee count
    */
    //*****************************************************
    public int getAttendees()
    {
        return this.attendees;
    }

    //*****************************************************
    /** Set the attendees property
    *
    *   @param attendees The new attendee count
    */
    //*****************************************************
    public void setAttendees ( int attendees )
    {
        this.attendees = attendees;
    }

    //*****************************************************
    /** Retrieve the cds property
    *
    *   @return The current CD count
    */
    //*****************************************************
    public int getCds()
    {
        return this.cds;
    }

    //*****************************************************
    /** Set the cds property
    *
    *   @param cds The new count of CDs
    */
    //*****************************************************
    public void setCds ( int cds )
    {
        this.cds = cds;
    }

    //*****************************************************
    /** Retrieve the guildmember property
    *
    *   @return true if registrant is a JSP guild member
    */
    //*****************************************************
    public boolean getGuildmember()
    {
        return this.guildmember;
    }

    //*****************************************************
    /** Set the guildmember property
    *
    *   @param guildmember true if registrant is a JSP
    *                      guild member
    */
    //*****************************************************
    public void setGuildmember ( boolean guildmember )
    {
        this.guildmember = guildmember;
    }

    //*****************************************************
    /** Retrieve the registration date property
    *
    *   @return The registration date
    */
    //*****************************************************
    public Date getDate()
    {
        return this.date;
    }

    //*****************************************************
    /** Set the registration date property
    *
    *   @param d The new regisration date
    */
    //*****************************************************
    public void setDate ( Date d )
    {
        this.date = d;
    }

    //*****************************************************
    /** Retrieve the confirmation number property
    *
    *   @return The confirmation number
    */
    //*****************************************************
    public int getConfirmationNumber()
    {
    	return this.confirmationNumber;
    }
    
    //*****************************************************
    /** Set the confirmationNumber property
    *
    *   @param confirmationNumber The new confirmation number
    */
    //*****************************************************
    public void setConfirmationNumber(int confirmationNumber)
    {
    	this.confirmationNumber = confirmationNumber;
    }
    
    //*****************************************************
    /** Retrieve total amount, based on:
    *
    *       attendees, cds and guildmember properties
    *
    *   @return The amount due
    */
    //*****************************************************
    public double getAmountDue()
    {
        double discount = 0;

        if ( guildmember == true )
            discount = guildDiscount;

        double amount = ( attendees * conferencePrice ) +
                        ( cds * cdPrice );

        return amount - ( amount * discount );
    }
}

