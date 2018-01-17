//STANDARD COLORS | MAIN RED: 912d2d
//STANDARD COLORS | LIGHT RED: ea5353
//STANDARD COLORS | DARK RED: 902626
//STANDARD COLORS | DARKEST RED: 271c1c


public class Main
{
    protected static ConnectDB connection = new ConnectDB();
    private static User currentUser;
    public static void main(String args[])
    {
        connection.login("test", "test");
        currentUser.printUser();

    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        Main.currentUser = currentUser;
    }
}
