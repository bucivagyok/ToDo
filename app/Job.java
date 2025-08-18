package app;

public class Job {
    int id;
    String title;
    String description;
    boolean isCompleted;

    public Job(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.isCompleted = false;
    }
    
    public Job(int id, String title) {
        this.id = id;
        this.title = title;
        this.description = "";
        this.isCompleted = true;
    }
}