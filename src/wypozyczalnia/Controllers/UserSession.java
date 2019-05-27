package wypozyczalnia.Controllers;

public final class UserSession {

    private static UserSession instance;

    private String userName;
    private String userType;
    private int userId;

    private UserSession(String userName, String userType, int userId) {
        this.userName = userName;
        this.userType = userType;
        this.userId = userId;
    }

    public static UserSession getInstace(String userName, String userType, int userId) {
        if(instance == null) {
            instance = new UserSession(userName, userType, userId);
        }
        return instance;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserType() {
        return userType;
    }

    public int getUserId() {
        return userId;
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

    public void cleanUserSession() {
        userName = "";// or null
        userType = "";// or null
        userId = 0;
    }

    @Override
    public String toString() {
        return "UserSession{" +
                "userName='" + userName + '\'' +
                ", userType=" + userType +
                ", user_id=" + userId +
                '}';
    }
}