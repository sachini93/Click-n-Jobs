package com.example.stp.findjob;

public class Candidate {
    private int _id;
    private String name;
    private String age;
    private String gender;
    private String qualifications;
    private String email;

    public Candidate(){

    }

    public Candidate(String name, String age, String gender, String qualifications, String email) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.qualifications = qualifications;
        this.email = email;
    }

    public int get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getQualifications() {
        return qualifications;
    }

    public String getEmail() {
        return email;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
