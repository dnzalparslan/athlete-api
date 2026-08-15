package com.md.athlete_api;

public class Athlete {

    private Long id;
    private String name;
    private String position;

    public Athlete() {
    }

    public Athlete(Long id, String name, String major) {
        this.id = id;
        this.name = name;
        this.position = major;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
