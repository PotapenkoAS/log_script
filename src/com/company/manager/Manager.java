package com.company.manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Manager {

    private static String selectedProject = "";

    public static boolean selectProject(ProcessBuilder builder, String project) throws IOException, InterruptedException {
        if (!selectedProject.equals(project)) {
            String correctProject = PropertyManager.context.getProjects().get(project);
            builder.command("cmd.exe", "/c", "oc project " + correctProject);
            Process selectProject = builder.start();
            selectProject.waitFor();
            BufferedReader validReader = new BufferedReader(new InputStreamReader(selectProject.getInputStream()));
            String s = validReader.readLine();
            if (s.toLowerCase().contains("error")) {
                System.out.println("Error occurred: ");
                System.out.println(s);
                return false;
            }
            selectedProject = project;
        }
        return true;
    }

    public static void findPods(ProcessBuilder builder, String logDir, String serviceName) throws IOException, InterruptedException {

        serviceName = PropertyManager.context.getPods().getOrDefault(serviceName, serviceName);
        builder.command("cmd.exe", "/c", "oc get pods");
        Process p = builder.start();
        Thread.sleep(2000);
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        int i = 1;
        boolean isCreated = false;
        while (true) {
            line = r.readLine();
            if (line == null) {
                break;
            }
            if (line.matches(serviceName + "-\\d.*") && !line.toLowerCase().contains("evicted") && !line.toLowerCase().contains("deploy")) {
                builder.command("cmd.exe", "/c",
                        "oc logs " + line.split(" ")[0] + " > " + logDir + "\\" + serviceName + i + ".log");
                builder.start();
                System.out.println("file \"" + serviceName + i + ".log\" created\\updated!");
                isCreated = true;
                i++;
            }
        }
        if (isCreated) {
            System.out.println("Done!");
        } else {
            System.out.println("No pods found with name: " + serviceName);
        }
    }
}
