package Model;

import java.util.ArrayList;
import java.util.List;

public class Class {
    private String name;
    private Pair<String, Pair<Integer, Integer>> date;
    private String teacher = "Null";

    public Class(String name) {
        this.name = name;
        this.date = null;
        this.teacher = "Null";
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pair<String, Pair<Integer, Integer>> getDate() {
        return date;
    }

    public void addDate(String date, int start, int end) {
        Pair<Integer, Integer> tiet = new Pair<>(start, end);
        this.date = new Pair<>(date, tiet);
    }
    public String getDateFirst(){
        return this.date.getFirst();
    }
    public String getDateSecond(){
        int x = this.date.getSecond().getFirst();
        int y = this.date.getSecond().getSecond();

        return String.format("%d-%d", x, y);
    }
}

