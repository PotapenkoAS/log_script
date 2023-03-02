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
        String devServer = "--server=10.12.62.43:6443";
        String testServer = "--server=10.12.62.43:6443";
        String test10Server = "--server=10.12.62.43:6443";
        String ftServer = "--server=10.12.62.43:6443";
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
                loginCommand = "oc login " + devServer + " -u " + PropertyManager.USERNAME + " -p " + PropertyManager.PASSWORD;
                loggedIn = "dev";
                break;
            }
            case "test": {
                loginCommand = "oc login " + testServer + " -u " + PropertyManager.USERNAME + " -p " + PropertyManager.PASSWORD;
                loggedIn = "test";
                break;
            }
            case "test10": {
                loginCommand = "oc login " + test10Server + " -u " + PropertyManager.USERNAME + " -p " + PropertyManager.PASSWORD;
                loggedIn = "test10";
                break;
            }
            case "ft": {
                loginCommand = "oc login " + ftServer + " -u " + PropertyManager.USERNAME + " -p " + PropertyManager.PASSWORD;
                loggedIn = "ft";
                break;
            }

        }

        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", loginCommand);
        String logDir = PropertyManager.LOG_DIR.isEmpty() ? System.getProperty("user.home") + "\\Desktop\\logs" : PropertyManager.LOG_DIR;
       /* if (PropertyManager.LOG_DIR.isEmpty()) {
            logDir = System.getProperty("user.home") + "\\Desktop\\logs";
        } else {
            logDir = PropertyManager.LOG_DIR;
        }*/
        builder.redirectErrorStream(true)
                .directory(new File(PropertyManager.OC_DIR))
                .start().waitFor();

        if (!Manager.selectProject(builder, project)) {
            return;
        }
        String input;
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
                            break;
                        }
                    }
                    case "dev": {
                        if (!loggedIn.equals("dev")) {
                            loginCommand = "oc login " + devServer + " -u " + PropertyManager.USERNAME + " -p " + PropertyManager.PASSWORD;
                            loggedIn = "dev";
                            break;
                        }
                    }
                    case "test": {
                        if (!loggedIn.equals("test")) {
                            loginCommand = "oc login " + testServer + " -u " + PropertyManager.USERNAME + " -p " + PropertyManager.PASSWORD;
                            loggedIn = "test";
                            break;
                        }
                    }
                    case "test10": {
                        if (!loggedIn.equals("test10")) {
                            loginCommand = "oc login " + test10Server + " -u " + PropertyManager.USERNAME + " -p " + PropertyManager.PASSWORD;
                            loggedIn = "test10";
                            break;
                        }
                    }
                    case "ft": {
                        if (!loggedIn.equals("ft")) {
                            loginCommand = "oc login " + ftServer + " -u " + PropertyManager.USERNAME + " -p " + PropertyManager.PASSWORD;
                            loggedIn = "ft";

                            break;
                        }
                    }
                }
                builder.command("cmd.exe", "/c", loginCommand);
                builder.start().waitFor();
                Manager.selectProject(builder, input);
                continue;
            }
            Manager.findPods(builder, logDir, input);
        }
    }
}
