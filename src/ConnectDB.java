import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.sql.*;
import java.util.ArrayList;

public class ConnectDB implements Runnable
{
    /*-- FIELDS --*/
    private Connection conn;


    MysqlDataSource dataSource = new MysqlDataSource();

    /*-- METHODS --*/
    public void run()
    {

    }

    public ConnectDB(){
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

    protected void login(String usernameInput, String passwordInput)
    {
        String passwordRetreived = "";
        String query = "SELECT password FROM Users WHERE username = '" + usernameInput + "'";
        try
        {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next())
            {
                passwordRetreived  = rs.getString("password");
            }

            if(passwordInput.equals(passwordRetreived))
            {
                Main.setCurrentUser(this.getUserByUsername(usernameInput));
                System.out.println("Logged in successfully.");
            }
            else
            {
                System.out.println("Passwords did not match.");
                //PROBABLY CHANGE LABEL TEXT.
            }
        }
        catch(SQLException e)
        {
            System.out.println("Something went wrong. Could not find the username.");
            //PLACE LOGIN ERROR FOR USERNAME IN LOGIN SCREEN LABEL
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

    public boolean setNewUserStatusInDB(String newStatusInput)
    {
        String query = "UPDATE Users SET status = '" + newStatusInput + "' WHERE userID = '" + Main.getCurrentUser().getUserID() + "'"; // CHANGE TO CURRENT USER ID
        try
        {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            return true;
        }
        catch(SQLException e)
        {
            System.out.println("Something went wrong. We could not update the status");
            e.printStackTrace();
            return false;
        }
    }

    public boolean setOnlineStatusInDB(int newUserOnlineStatusInput)
    {
        String query = "UPDATE Users SET status = '" + newUserOnlineStatusInput + "' WHERE userID = '" + Main.getCurrentUser().getUserID() + "'"; // CHANGE TO CURRENT USER ID
        try
        {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            return true;
        }
        catch(SQLException e)
        {
            System.out.println("Something went wrong. We could not update the online status.");
            e.printStackTrace();
            return false;
        }
    }

    public boolean setNewNameInDB(String newNameInput)
    {
        String query = "UPDATE Users SET name = '" + newNameInput + "' WHERE userID = '" + Main.getCurrentUser().getUserID() + "'"; // CHANGE TO CURRENT USER ID
        try
        {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            return true;
        }
        catch(SQLException e)
        {
            System.out.println("Something went wrong. We could not update the name.");
            e.printStackTrace();
            return false;
        }
    }

    public void registerNewUser(String nameInput, String usernameInput, String passwordInput, String password2Input)
    {
        if(usernameInput.length() <= 25 && passwordInput.length() <= 25 && password2Input.length() <= 25)
        {
            if(passwordInput.equals(password2Input))
            {
                String query = "INSERT INTO Users(name, username, password) VALUES('" + nameInput + "','" + usernameInput + "','" + passwordInput + "')";

                try {
                    Statement stmt = conn.createStatement();
                    stmt.executeUpdate(query);
                    stmt.close();

                    //CLOSE REGISTER SCREEN.
                    //OPEN LOGIN SCREEN.
                } catch (SQLException e) {
                    System.out.println("Something went wrong. We could not update the name.");
                    e.printStackTrace();
                    //CHANGE TEXT LABEL IN GUI.
                }
            }
            else
            {
                System.out.println("Passwords don't match");
                //SET TEXT LABEL PASSWORDS DON'T MATCH.
            }
        }
        else
        {
            System.out.println("Username, password and name are too long.");
            //SET TEXT LABEL INPUT TOO LONG.
        }
    }



}
