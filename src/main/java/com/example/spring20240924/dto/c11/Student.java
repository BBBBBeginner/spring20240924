package com.example.spring20240924.dto.c11;

public class Student {
    private Integer number;
    private String name;
    private Integer age;
    private Double score;
    private String email;

    public Student(Integer number, String name, Integer age, Double score, String email) {
        this.number = number;
        this.name = name;
        this.age = age;
        this.score = score;
        this.email = email;
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
