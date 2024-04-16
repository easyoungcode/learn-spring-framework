package com.in28minutes.learnspringframework;

import java.io.Serializable;

class Pojo {
    private String text;
    private int number;
    public String toString() {
        return text + " " + number;
    }
}

// JAVA Bean : 클래스에 public no-arg 생성자가 포함되어 있고, getter/setter 존재
class JavaBean implements Serializable {   // EJB, 인수생성자가 존재하면 X!

    // public no-arg constructor
    public JavaBean() {

    }
    private String text;
    private int number;

    //getters and setters
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

public class SpringBeanVsJavaBean {



}
