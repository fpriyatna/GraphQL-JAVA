package com.graphql.code;

public class Student {
    
    private final String id;
    private final String foafName;


    public Student(String foafName) {
        this(null, foafName);
    }
    
    public Student(String id, String foafName) {
        this.id = id;
        this.foafName = foafName;
    }

    public String getId() {
        return id;
    }

    public String getFoafName() {
        return foafName;
    }

}
