package com.mobilecomputingdb;

public class Student {
    private int id;
    private String name;
    private int rollNumber;
    private boolean isEnroll;

    public Student(int id, String name, int rollNumber, boolean isEnroll) {
        this.id = id;
        this.name = name;
        this.rollNumber = rollNumber;
        this.isEnroll = isEnroll;
    }

    public Student(String name, int rollNmber, boolean isEnroll) {
        this.name = name;
        this.rollNumber = rollNmber;
        this.isEnroll = isEnroll;
    }

    public Student(boolean isEnroll) {
        this.isEnroll = isEnroll;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public boolean isEnroll() {
        return isEnroll;
    }

    public void setEnroll(boolean enroll) {
        isEnroll = enroll;
    }

    @Override
    public String toString() {
        return "StudentModel{" +
                "name='" + name + '\'' +
                ", rollNmber=" + rollNumber +
                ", isEnroll=" + isEnroll +
                '}';
    }
}
