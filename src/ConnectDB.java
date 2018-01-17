import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.*;
import java.util.ArrayList;

public class ConnectDB
{
    /*-- FIELDS --*/
    private Connection conn;


    MysqlDataSource dataSource = new MysqlDataSource();

    /*-- METHODS --*/
    public ConnectDB()
    {
        dataSource.setUser("root");
        dataSource.setPassword("");
        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("java");

        try
        {
            conn = dataSource.getConnection();
        }
        catch(SQLException e)
        {
            System.out.println("Could not connect to database");
        }
    }

    protected ArrayList<User> getUserByName(String nameInput)
    {
        ArrayList<User> foundUsers = new ArrayList<User>();
        String query = "SELECT userID, username, name, status, onlineStatus FROM Users WHERE name = '" + nameInput + "'";
        try
        {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next())
            {
                User u = new User();
                foundUsers.add(u);
                u.setName(rs.getString("name"));
                u.setOnlineStatus(rs.getInt("onlineStatus"));
                u.setStatus(rs.getString("status"));
                u.setUsername(rs.getString("username"));
                u.setUserID(rs.getInt("userID"));
            }
            stmt.close();
            rs.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Something went wrong. Could not retrieve username.");
        }

        return foundUsers;
    }

    protected User getUserByID(int userIDInput)
    {
        User foundUser = new User();
        String query = "SELECT userID, username, name, status, onlineStatus FROM Users WHERE userID = '" + userIDInput + "'";
        try
        {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next())
            {
                foundUser.setName(rs.getString("name"));
                foundUser.setOnlineStatus(rs.getInt("onlineStatus"));
                foundUser.setStatus(rs.getString("status"));
                foundUser.setUsername(rs.getString("username"));
                foundUser.setUserID(rs.getInt("userID"));
            }
            stmt.close();
            rs.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Something went wrong. Could not retrieve username.");
        }

        return foundUser;
    }

    protected User getUserByUsername(String usernameInput)
    {
        User foundUser = new User();
        String query = "SELECT userID, username, name, status, onlineStatus FROM Users WHERE username = '" + usernameInput + "'";
        try
        {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next())
            {
                foundUser.setName(rs.getString("name"));
                foundUser.setOnlineStatus(rs.getInt("onlineStatus"));
                foundUser.setStatus(rs.getString("status"));
                foundUser.setUsername(rs.getString("username"));
                foundUser.setUserID(rs.getInt("userID"));
            }
            stmt.close();
            rs.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Something went wrong. Could not retrieve username.");
        }

        return foundUser;
    }

    
}
