package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static String loggedIn = "";

    public static void main(String[] args) throws IOException, InterruptedException {
//enter project

        new PropertyManager().init();
        PodsCatalog.init();
        System.out.println("Enter project name. One of: " + PropertyManager.PROJECTS);
        Scanner in = new Scanner(System.in);
        String ftServer = "--server=10.12.62.43:6443";
        String testServer = "--server=10.12.62.43:6443";
        String prodServer = "--server=https://ocp-prod.rccf.ru:8443";
        String project = in.nextLine();
        if (!Validator.isProjectValid(project)) {
            System.out.println("Incorrect project");
            return;
        }
//login
        String loginCommand = "";
        switch (project) {
            case "prod": {
                loginCommand = "oc login " + prodServer + " -u " + PropertyManager.USERNAME + " -p " + PropertyManager.PASSWORD;
                loggedIn = "prod";
                break;
            }
            case "dev": {
                loginCommand = "oc login " + ftServer + " -u " + PropertyManager.USERNAME + " -p " + PropertyManager.PASSWORD;
                loggedIn = "dev";
                break;
            }
            case "test": {
                loginCommand = "oc login " + testServer + " -u " + PropertyManager.USERNAME + " -p " + PropertyManager.PASSWORD;
                loggedIn = "test";
                break;
            }
            case "ft": {
                loginCommand = "oc login " + ftServer + " -u " + PropertyManager.USERNAME + " -p " + PropertyManager.PASSWORD;
                loggedIn = "ft";
                break;
            }

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
                switch (input) {
                    case "prod": {
                        if (!loggedIn.equals("prod")) {
                            loginCommand = "oc login " + prodServer + " -u " + PropertyManager.USERNAME + " -p " + PropertyManager.PASSWORD;
                            loggedIn = "prod";
                            builder.command("cmd.exe", "/c", loginCommand);
                            builder.start().waitFor();
                            break;
                        }
                    }
                    case "dev": {
                        if (!loggedIn.equals("test")) {
                            loginCommand = "oc login " + ftServer + " -u " + PropertyManager.USERNAME + " -p " + PropertyManager.PASSWORD;
                            loggedIn = "dev";
                            builder.command("cmd.exe", "/c", loginCommand);
                            builder.start().waitFor();
                            break;
                        }
                    }
                    case "test": {
                        if (!loggedIn.equals("test")) {
                            loginCommand = "oc login " + testServer + " -u " + PropertyManager.USERNAME + " -p " + PropertyManager.PASSWORD;
                            loggedIn = "test";
                            builder.command("cmd.exe", "/c", loginCommand);
                            builder.start().waitFor();
                            break;
                        }
                    }
                    case "ft": {
                        if (!loggedIn.equals("ft")) {
                            loginCommand = "oc login " + ftServer + " -u " + PropertyManager.USERNAME + " -p " + PropertyManager.PASSWORD;
                            loggedIn = "ft";
                            builder.command("cmd.exe", "/c", loginCommand);
                            builder.start().waitFor();
                            break;
                        }
                    }
                }

                Manager.selectProject(builder, input);
                continue;
            }
            Manager.findPods(builder, logDir, input);
        }
    }
}
