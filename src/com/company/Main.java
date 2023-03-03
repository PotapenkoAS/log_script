package com.company;

import com.company.manager.Manager;
import com.company.manager.PropertyManager;
import com.company.validation.Validator;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
//enter project
        new PropertyManager().init();

        System.out.println("Enter project name. One of: " + PropertyManager.context.projectsToString());
        Scanner in = new Scanner(System.in);
        String testServer = "--server=10.12.62.43:6443";
        String project = in.nextLine();
        if (!Validator.isProjectValid(project)) {
            System.out.println("Incorrect project");
            return;
        }
//login

        String loginCommand = "oc login " + testServer + " -u " + PropertyManager.context.getUsername() + " -p " + PropertyManager.context.getPassword();

        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", loginCommand);
        String logDir = PropertyManager.context.getLogDirectory().isEmpty() ? System.getProperty("user.home") + "\\Desktop\\logs" : PropertyManager.context.getLogDirectory();
        builder.redirectErrorStream(true)
                .directory(new File(PropertyManager.context.getOcDirectory()))
                .start().waitFor();

        if (!Manager.selectProject(builder, project)) {
            return;
        }
// read inputs, select project, get logs
        String input;
        while (true) {
            System.out.println("Enter pod name, or new project name.");
            input = in.nextLine().trim();
            if (input.equals("exit")) {
                break;
            }
            if (Validator.isProjectValid(input)) {
                Manager.selectProject(builder, input);
                continue;
            }
            Manager.findPods(builder, logDir, input);
        }
    }
}
