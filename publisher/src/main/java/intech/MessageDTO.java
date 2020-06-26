package intech;

public class MessageDTO {
    private int msisdn;
    private String action;
    private long timestamp;

    public int getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(int msisdn) {
        this.msisdn = msisdn;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "MessageDTO{" +
                "msisdn=" + msisdn +
                ", action='" + action + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
