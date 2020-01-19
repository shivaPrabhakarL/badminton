package com.badminton;

public class Teams {
    int Teamid;
    String Name;
    int MatchesPlayed;
    int wins;
    int losses;
    int position;
    int points;

    public Teams() {
    }

    int empId;

    public int getTeamid() {
        return Teamid;
    }

    public void setTeamid(int teamid) {
        Teamid = teamid ;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getMatchesPlayed() {
        return MatchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        MatchesPlayed = matchesPlayed;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }
}
