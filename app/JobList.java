package app;

import java.util.ArrayList;

public class JobList {
    private ArrayList<Job> jobs;

    public JobList() {
        jobs = new ArrayList<Job>();
    }

    public void AddJob(Job job) {
        jobs.add(job);
    }

    public void ReDescribe(int id, String description) {
        Job toChange = null;
        for (Job job : jobs) {
            if (job.id == id) {
                toChange = job;
            }
        }
        if (toChange != null) {
            toChange.description = description;
        }
    }

    public void ListJobs() {
       for (Job job : jobs) {
            System.out.println(String.format("%d %s %s %s", job.id, job.title, job.description, job.isCompleted ? "Completed" : "Not completed"));
        } 
    }
}