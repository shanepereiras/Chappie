public class User {

    /*FIELDS*/
    protected int onlineStatus;
    protected int userID;
    protected String username;
    protected String name;
    protected String status;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(int onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void printUser()
    {
        System.out.println("username = " + this.username);
        System.out.println("name = " + this.name);
        System.out.println("status = " + this.status);
        System.out.println("onlineStatus = " + this.onlineStatus);
    }

    public void changeUserStatus(String newUserStatus)
    {
        if(Main.connection.setNewUserStatusInDB(newUserStatus))
        {
            this.setStatus(newUserStatus);
        }
    }

    public void changeUserOnlineStatus(int statusNumber)
    {
        if(Main.connection.setOnlineStatusInDB(statusNumber))
        {
            this.setOnlineStatus(statusNumber);
        }

    }

    public void changeUserName(String newName)
    {
        if(Main.connection.setNewNameInDB(newName))
        {
            this.setName("newName");
        }

    }

    public void changePassword(String oldPassword, String newPassword, String newPassword2)
    {

    }
}
