package app;

public class Job {
    String title;
    String description;
    boolean isCompleted;

    public Job(int id, String title, String description) {
        this.title = title;
        this.description = description;
        this.isCompleted = false;
    }
    
    public Job(int id, String title) {
        this.title = title;
        this.description = "";
        this.isCompleted = false;
    }

    public void Done() {
        this.isCompleted = true;
    }
}