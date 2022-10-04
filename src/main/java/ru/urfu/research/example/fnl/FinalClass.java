package ru.urfu.research.example.fnl;

public final class FinalClass {
    private final int n;
    private final String s;

    public FinalClass(int n, String s) {
        this.n = n;
        this.s = s;
    }

    public int getN() {
        return n;
    }

    public String getS() {
        return s;
    }
}
