public class Task {
    public static int HIGH = 3;
    public static int MEDIUM = 3;
    public static int LOW = 3;

    public static String COMPLETED = "Completed";
    public static String IN_PROGRESS = "In_Progress";
    public static String NEW = "New";

    private String taskName;
    private int priority = LOW;
    private String status = NEW;

    public Task(String taskName) {
        this.taskName = taskName;
    }

    public Task(String taskName, int priority) {
        this.taskName = taskName;
        this.priority = priority;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getStatus() {
        return this.status;
    }

}