package wypozyczalnia.Controllers;

public class SessionUser {

    private String userName;
    private String userType;
    private String userId;

    public SessionUser(String userName, String userType, String userId) {

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

    public String getUserId() {

        return this.userId;

    }

    public void logOut() {

        this.userName = NULL;
        this.userType = NULL;
        this.userId = NULL;

    }

}
