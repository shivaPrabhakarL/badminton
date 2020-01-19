package com.badminton;

public class Player {


    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String team;
    private String image;
    private String phone;
    private String type; //Captain, Offense, Defense, Beginner, Marquee.
    private String shirtSize;
    private int empId;
    private int age;
    private int matchesPlayed;
    private int position;
    private int bidStatus; // 1->Sold 0->NotSold -1->did not face bidding, Set to -1 in database as default, Change to 0 when player faces bidding
    private String password;

    Player(){}

    Player(String firstName, String lastName, String email, String gender, String image,
           String phone, String shirtSize, int empId, int age, String password)
    {
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.gender=gender;
        this.image=image;
        this.phone=phone;
        this.shirtSize=shirtSize;
        this.empId=empId;
        this.age=age;
        this.password=password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getShirtSize() {
        return shirtSize;
    }

    public void setShirtSize(String shirtSize) {
        this.shirtSize = shirtSize;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getBidStatus() {
        return bidStatus;
    }

    public void setBidStatus(int bidStatus) {
        this.bidStatus = bidStatus;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}