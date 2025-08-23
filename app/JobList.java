package app;

import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JobList {
    private ArrayList<Job> jobs;

    public JobList() {
        jobs = new ArrayList<Job>();
        Load();
    }

    public void AddJob(Job job) {
        jobs.add(job);
    }

    public void ReDescribe(int number, String description) throws Exception {
        if (number < jobs.size()) {
            jobs.get(number).setDescription(description);
        }
        else {
            throw new Exception();
        }
    }

    public void ListJobs() {
        for (int i = 0; i < jobs.size(); i++) {
            System.out.printf("%d: %s\n", i, jobs.get(i).ToString());
        }
    }

    public void JobDone(int number) throws Exception {
        if (number < jobs.size() && !jobs.get(number).getCompleted()) {
           jobs.get(number).Done();
        }
        else {
            throw new Exception();
        }
    }

    public void DeleteJob(int number) throws Exception {
        if (number < jobs.size() && jobs.get(number).getCompleted()) {
            jobs.remove(number);
        }
        else {
            throw new Exception();
        }
    }

    static String fileName = "tasks.txt";

    public void Save() {
        try {
            File file = new File(fileName);
            file.createNewFile();
            FileWriter writer = new FileWriter(fileName);
            for (Job job : jobs) {
                writer.write(job.ToSave() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public void Load() {
        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String[] data = reader.nextLine().split(";");
                AddJob(new Job(data[0], data[1], data[2] == "Done"));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            //File doesn't exist, starting with an empty list.
        }
    }
}