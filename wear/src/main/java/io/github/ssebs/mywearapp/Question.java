package io.github.ssebs.mywearapp;

/**
 * Created by Sebastian on 12/28/2015.
 */
public class Question {
    private String q;
    private boolean ansBool;

    public Question(String q, boolean ansBool) {
        this.ansBool = ansBool;
        this.q = q;
    }

    public String getQuestion() {
        return q;
    }

    public void setQuestion(String q) {
        this.q = q;
    }

    public boolean getAnsBool() {
        return ansBool;
    }

    public void setAnsBool(boolean ansBool) {
        this.ansBool = ansBool;
    }
}
