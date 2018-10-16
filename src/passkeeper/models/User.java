package passkeeper.models;

public class User {

    private String login;
    private passkeeper.objects.User user;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public passkeeper.objects.User getUser() {
        return user;
    }

    public void setUser(passkeeper.objects.User user) {
        this.user = user;
    }
}
