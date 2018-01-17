import java.util.ArrayList;

public class Main
{
    public static void main(String args[])
    {
        System.out.println("Welcome to Chappie version 0.1");
        System.out.println("Testing the find user methods");
        ConnectDB connection = new ConnectDB();
        User userByUsername = connection.getUserByUsername("admin");
        userByUsername.printUser();
        System.out.println();
        User userByUserID = connection.getUserByID(2);
        userByUserID.printUser();
        System.out.println();
        ArrayList<User> searchresults = connection.getUserByName("admin");

        for(int i = 0; i<searchresults.size(); i++)
        {
            searchresults.get(i).printUser();
            System.out.println();
        }
    }
}
