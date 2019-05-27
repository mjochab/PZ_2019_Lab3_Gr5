package wypozyczalnia;

public final class UserSession {

    private static UserSession instance;

    private static String login;
    private static String haslo;
    private static String rola;
    private static int user_id;

    private UserSession(String login, String haslo, String rola, int user_id) {
        this.login = login;
        this.haslo = haslo;
        this.rola = rola;
        this.user_id = user_id;
    }

    public static UserSession getInstance(String login, String haslo, String rola, int user_id) {
        if(instance == null) {
            instance = new UserSession(login, haslo, rola, user_id);
        }
        return instance;
    }

    public static String getUsername() {
        return login;
    }

    public static String getHaslo() {
        return haslo;
    }

    public static String getRola() {
        return rola;
    }

    public static int getID() {
        return user_id;
    }


    public static void cleanUserSession() {
        login = "";
        haslo = "";
        rola = "";
        user_id = 0;
    }

    @Override
    public String toString() {
        return "Sesja użytkownika{" +
                "login ='" + login + '\'' +
                ", rola =" + rola + '\'' +
                ", user_id =" + user_id +
                '}';
    }
}
