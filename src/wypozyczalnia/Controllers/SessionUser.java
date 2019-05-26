package wypozyczalnia.Controllers;

public class SessionUser {

    private String userName;
    private String userType;
    private int userId;

    public SessionUser(String userName, String userType, int userId) {

        this.userName = userName;
        this.userType = userType;
        this.userId = userId;

    }

    public String getUserName() {

        return this.userName;

    }

    public String getUserType() {

        return this.userType;

    }

    public int getUserId() {

        return this.userId;

    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    public void logOut() {

        this.userName = null;
        this.userType = null;
        this.userId = 0;

    }

}
