package mutilThread;

public class WrongUser {
    private final String name;
    public WrongUser(String name) {
        UserHolder.user = this;
        this.name = name;
    }
}
