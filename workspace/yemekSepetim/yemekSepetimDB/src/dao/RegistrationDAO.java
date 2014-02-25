package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import conference.RegistrationBean;

public class RegistrationDAO
{
    private DataSource ds;

    public List getAllRegistrations() throws SQLException, NamingException,
            ParseException
    {
        List<RegistrationBean> regList = 
            new ArrayList<RegistrationBean>();
        SimpleDateFormat df = new SimpleDateFormat();
        df.applyPattern("mm-DD-yyyy");

        Connection con = null;
        try
        {
            // retrieve a connection
            con = connect();

            ResultSet rs = null;
            Statement stmt = null;

            try
            {
                // query all registrations
                stmt = con.createStatement();
                rs = stmt.executeQuery("SELECT * FROM yemekler");

                // iterate result set
                // - create a RegistrationBean for each result
                // and initialize its properties
                // - add the RegistrationBean to the list
                while (rs.next())
                {
                    conference.RegistrationBean rb = new conference.RegistrationBean();
                    rb.setAddress(rs.getString("address"));
                    rb.setAttendees(rs.getInt("attendees"));
                    rb.setCds(rs.getInt("cds"));
                    rb.setCity(rs.getString("city"));
                    rb.setConfirmationNumber(rs.getInt("confirmNum"));
                    rb.setName(rs.getString("name"));
                    rb.setState(rs.getString("state"));
                    rb.setZip(rs.getString("zip"));

                    int guildMember = rs.getInt("guildmember");
                    if (guildMember == 0)
                        rb.setGuildmember(false);
                    else
                        rb.setGuildmember(true);

                    String dateStr = rs.getString("regdate");
                    Date date = df.parse(dateStr);
                    rb.setDate(date);
                    
                    regList.add(rb);
                }

            } finally
            {
                if (rs != null)
                    rs.close();
            }
        } finally
        {
            if (con != null)
                con.close();
        }

        return regList;
    }

    private Connection connect() throws SQLException, NamingException
    {
        if (ds == null)
        {
            InitialContext ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
        }

        return ds.getConnection();
    }
}
