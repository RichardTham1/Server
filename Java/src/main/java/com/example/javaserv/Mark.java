package com.example.javaserv;

import org.springframework.lang.Nullable;

public class Mark {
    public String name;
    private Float weight;
    @Nullable
    private Float mark;

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Mark() {}

    public Float getMark() {
        return mark;
    }

    public Float getWeight() {
        return weight;
    }

    public void setMark(Float mark) {
        if (mark == null)
            this.mark = null;
        else if (mark > 100)
            this.mark = 100f;
        else
            this.mark = mark;
    }
}
