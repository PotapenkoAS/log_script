package com.company.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PropertyContext {

    private String username;
    private String password;
    private String logDirectory;
    private String ocDirectory;
    private HashMap<String, String> projects;
    private HashMap<String, String> pods;

    public String projectsToString(){
        StringBuilder sb = new StringBuilder();
        projects.forEach((k, v) -> sb.append("\r\n").append(k).append("\t - \t").append(v));
        return sb.toString();
    }

    public String podsToString(){
        StringBuilder sb = new StringBuilder();
        pods.forEach((k, v) -> sb.append("\r\n").append(k).append("\t - \t").append(v));
        return sb.toString();
    }
}
