package app;

public class Job {
    private String title;
    private String description;
    private boolean isCompleted;

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public boolean getCompleted() {
        return isCompleted;
    }

    public Job(String title, String description) {
        this.title = title;
        this.description = description;
        this.isCompleted = false;
    }

    public Job(String title, String description, boolean isCompleted) {
        this.title = title;
        this.description = description;
        this.isCompleted = isCompleted;
    }

    public void Done() {
        this.isCompleted = true;
    }

    public String ToString() {
        return title + " " + description + (isCompleted ? " Done" : " Not done");
    }

    public String ToSave() {
        return title + ";" + description + (isCompleted ? ";Done" : ";Not done");
    }
}