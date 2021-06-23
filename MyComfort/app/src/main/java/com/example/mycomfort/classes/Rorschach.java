package com.example.mycomfort.classes;

public class Rorschach {
    public String name;
    public String question;
    public String answer;
    public int imgSource;

    public Rorschach() {};

    public Rorschach(String name, String question, String answer) {
        this.name = name;
        this.question = question;
        this.answer = answer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setImgSource(int imgSource) {
        this.imgSource = imgSource;
    }

    public int getImgSource() {
        return imgSource;
    }
}
