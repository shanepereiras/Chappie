//STANDARD COLORS | MAIN: 912d2d


public class Main
{
    protected static ConnectDB connection = new ConnectDB();
    private static User currentUser;
    public static void main(String args[])
    {
        connection.registerNewUser("Register Test", "RegisterTest", "registertest", "registertest");
        connection.login("RegisterTest", "registertest");
        currentUser.printUser();
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        Main.currentUser = currentUser;
    }
}
