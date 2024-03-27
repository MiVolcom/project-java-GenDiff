package hexlet.code;

public final class Status {

    public static final String DELETED = "deleted";
    public static final String ADDED = "added";
    public static final String CHANGED = "updated";
    public static final String UNCHANGED = "unchanged";

    private Object key;
    private Object oldValue;
    private Object newValue;
    private String status;


    Status(String keykey, Object oldvalue, Object newvalue, String statusname) {
        key = keykey;
        oldValue = oldvalue;
        newValue = newvalue;
        status = statusname;
    }

    public Object getKey() {
        return key;
    }

    public String getStatus() {
        return status;
    }

    public Object getOldValue() {
        return oldValue;
    }

    public Object getNewValue() {
        return newValue;
    }
}

