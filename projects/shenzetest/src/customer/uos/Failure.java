package customer.uos;

public class Failure {

    String reason;

    String file;

    String function;

    String line;

    @Override
    public String toString() {
        return reason + " in file: " + file + " function: " + function + " line: " + line;
    }
}
