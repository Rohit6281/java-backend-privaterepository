package main.java;

public class Member {
    private String name;
    private int id;
    public String level;

 public Member (String name,int id,String level){
     this.name = name;
     this.id = id;
     this.level =level;
 }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
