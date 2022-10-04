package ru.urfu.research.example;

public class Simple {
    private final int n;
    private final String s;

    public Simple(int n, String s) {
        this.n = n;
        this.s = s;
    }

    public int getN() {
        return n;
    }

    public String getS() {
        return s;
    }

    public void doSomethingJob() {
        System.out.println("Job...");
    }

}
