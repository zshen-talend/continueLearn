package customer.uos;

class Trace {

    String errorType;

    String errorTrace;

    @Override
    public String toString() {
        return errorType + " = " + errorTrace;
    }
}