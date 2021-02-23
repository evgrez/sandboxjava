package model;

import java.util.List;
import java.util.Objects;

public class Question {
    private Integer id;
    private String msq;
    private List<AnswerOption> answerOptions;
    private AnswerOption res;

    public Question() {
    }

    public Question(Integer id, String msq, List<AnswerOption> answerOptions, AnswerOption res) {
        this.id = id;
        this.msq = msq;
        this.answerOptions = answerOptions;
        this.res = res;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMsq() {
        return msq;
    }

    public void setMsq(String msq) {
        this.msq = msq;
    }

    public List<AnswerOption> getAnswerOptions() {
        return answerOptions;
    }

    public void setAnswerOptions(List<AnswerOption> answerOptions) {
        this.answerOptions = answerOptions;
    }

    public AnswerOption getRes() {
        return res;
    }

    public void setRes(AnswerOption res) {
        this.res = res;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return id.equals(question.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", msq='" + msq + '\'' +
                ", answerOptions=" + answerOptions +
                ", res=" + res +
                '}';
    }
}
