package com.company.manager;

import com.company.pojo.PropertyContext;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class PropertyManager {

    public static PropertyContext context;

    public void init() throws IOException {
        JsonReader reader = new JsonReader(new FileReader("./application.json", StandardCharsets.UTF_8));
        //C:\Users\AtApse\Desktop\logs\
        context = new Gson().fromJson(reader,PropertyContext.class);
    }

}
