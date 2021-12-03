package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    private static String loggedIn = "";

    public static void main(String[] args) throws IOException, InterruptedException {
//enter project

        new PropertyManager().init();
        PodsCatalog.init();
        System.out.println("Enter project name. One of: " + PropertyManager.PROJECTS);
        Scanner in = new Scanner(System.in);
        String testServer = "--server=https://api.test.k8s.rccf.ru:6443";
        String prodServer = "--server=https://ocp-prod.rccf.ru:8443";
        String project = in.nextLine();
        if (!Validator.isProjectValid(project)) {
            System.out.println("Incorrect project");
            return;
        }
//login
        String loginCommand;
        if (project.equals("prod")) {
            loginCommand = "oc login " + prodServer + " -u " + PropertyManager.USERNAME + " -p " + PropertyManager.PASSWORD;
            loggedIn = "prod";
        } else {
            loginCommand = "oc login " + testServer + " -u " + PropertyManager.USERNAME + " -p " + PropertyManager.PASSWORD;
            loggedIn = "test";
        }
        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", loginCommand);
        String logDir;
        if (PropertyManager.LOG_DIR.isEmpty()) {
            logDir = System.getProperty("user.home") + "\\Desktop\\logs";
        } else {
            logDir = PropertyManager.LOG_DIR;
        }
        builder.redirectErrorStream(true);
        builder.directory(new File(PropertyManager.OC_DIR));
        builder.start().waitFor();
       // Thread.sleep(2000);

        if (!Manager.selectProject(builder, project)) {
            return;
        }
        String input = "";
        while (true) {
            System.out.println("Enter pod name, or new project name.");
            input = in.nextLine().trim();
            if (input.equals("exit")) {
                break;
            }
            if (Validator.isProjectValid(input)) {
                if (!loggedIn.equals("prod") && input.equals("prod")) {
                    loginCommand = "oc login " + prodServer + " -u " + PropertyManager.USERNAME + " -p " + PropertyManager.PASSWORD;
                    loggedIn = "prod";
                    builder.command("cmd.exe", "/c", loginCommand);
                    builder.start().waitFor();
                    //Thread.sleep(2000);
                } else if (loggedIn.equals("prod") && !input.equals("prod")) {
                    loginCommand = "oc login " + testServer + " -u " + PropertyManager.USERNAME + " -p " + PropertyManager.PASSWORD;
                    loggedIn = "test";
                    builder.command("cmd.exe", "/c", loginCommand);
                    builder.start().waitFor();
                    //Thread.sleep(2000);
                }

                Manager.selectProject(builder, input);
                continue;
            }
            Manager.findPods(builder, logDir, input);
        }
    }
}
