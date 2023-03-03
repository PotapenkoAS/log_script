package com.company.manager;

import com.company.pojo.PropertyContext;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class PropertyManager {

    public static PropertyContext context;

    public void init() throws FileNotFoundException {
        JsonReader reader = new JsonReader(new FileReader("./application.json"));
        context = new Gson().fromJson(reader,PropertyContext.class);
    }

}
