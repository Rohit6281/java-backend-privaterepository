package main.java;

public class Team {
    Member member;
    State state;

    public Team(Member member,State state) {
        this.member = member;
        this.state = state;
    }

    public static void main(String[] args){
Member mymember = new Member("rohit",1,"5");
State st = new State("karnataka",560085);

Team team = new Team(mymember,st);
System.out.println(team.member.getName());
System.out.println(team.member.level);
System.out.println(team.state.getPinCode());



}

}
