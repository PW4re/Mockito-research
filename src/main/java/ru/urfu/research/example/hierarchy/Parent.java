package ru.urfu.research.example.hierarchy;

public class Parent {
    private final String s;

    protected Parent() {
        this.s = "";
    }

    public Parent(String s) {
        this.s = s;
    }

    public static String getGreetingString() {
        return "Hello world!";
    }

    public String getS() {
        return s;
    }
}
