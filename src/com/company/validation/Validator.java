package com.company.validation;

import com.company.manager.PropertyManager;

public class Validator {


    public static boolean isProjectValid(String project) {
        return PropertyManager.context.getProjects().containsKey(project);

    }
}
