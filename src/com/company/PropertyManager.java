package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {
    private InputStream inputStream;

    public static String USERNAME = "";
    public static String PASSWORD = "";
    public static String LOG_DIR = "";
    public static String PROJECTS = "";
    public static String OC_DIR = "";

    public void init() throws IOException {

        try {
            Properties prop = new Properties();
            String propFileName = "./application.properties";
                // "C:\\Users\\alpotapenko\\IP\\log_script\\src\\resources\\application.properties";
                // "./application.properties";
                // "C:\\Users\\AtApse\\IdeaProjects\\log_script\\src\\resources\\application.properties";

            inputStream = new FileInputStream(propFileName);
            prop.load(inputStream);
            USERNAME = prop.getProperty("username");
            PASSWORD = prop.getProperty("password");
            LOG_DIR = prop.getProperty("log.directory");
            PROJECTS = prop.getProperty("projects");
            OC_DIR = prop.getProperty("oc.directory");

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }

    }


}
