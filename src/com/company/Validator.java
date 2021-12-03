package com.company;

import java.util.Arrays;

public class Validator {


    public static boolean isProjectValid(String project) {
        return Arrays.asList(PropertyManager.PROJECTS.split(",")).contains(project);
    }
}
