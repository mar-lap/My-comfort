package com.example.mycomfort.classes;

public class Material {
    public String name;
    public Object text;
    public int imageResource;

    Material(){}

    public Material(String name){
        this.name = name;
    }

    public Material(String name, Object text){
        this.name = name;
        this.text = text;
    }

    Material(String name, Object text, int imageResource) {
        this.name = name;
        this.text = text;
        this.imageResource = imageResource;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setText(Object text) {
        this.text = text;
    }

    public Object getText() {
        return this.text;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public int getImageResource() {
        return imageResource;
    }
}