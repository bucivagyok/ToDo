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
            jobs.get(number).setDescription(description);
        }
    }

    public void ListJobs() {
        for (int i = 0; i < jobs.size(); i++) {
            System.out.printf("%d: %s\n", i, jobs.get(i).ToString());
        }
    }

    public void JobDone(int number) {
        if (number < jobs.size()) {
           jobs.get(number).Done();
        }
    }

    public void DeleteJob(int number) {
        if (number < jobs.size() && jobs.get(number).getCompleted()) {
            jobs.remove(number);
        }
    }
}