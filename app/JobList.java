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

    public void ReDescribe(int number, String description) {
        if (number < jobs.size()) {
            jobs.get(number).description = description;
        }
    }

    public void ListJobs() {
        for (int i = 0; i < jobs.size(); i++) {
            System.out.println(String.format("%d %s %s %s", i, jobs.get(i).title, jobs.get(i).description, jobs.get(i).isCompleted ? "Completed" : "Not completed"));
        }
    }

    public void JobDone(int number) {
        if (number < jobs.size()) {
           jobs.get(number).isCompleted = true;
        }
    }

    public void DeleteJob(int number) {
        if (number < jobs.size() && jobs.get(number).isCompleted) {
            jobs.remove(number);
        }
    }
}