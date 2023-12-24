package com.example.javaserv;

public class Mark {
    public String name;
    private Integer weight;
    private Integer mark;

    // TODO: 2023-12-23 check how to deal with weight 
    public Mark(String name, Integer weight, Integer mark) {
        this.name = name;
        this.weight = weight;
        this.mark = mark;
    }

    public Integer getMark() {
        return mark;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setMark(Integer mark) {
        if (mark > 100)
            this.mark = 100;
        else
            this.mark = mark;
    }
}
