package com.tony.ngeno;

public class ResultM {
    private int id;
    private String studentadmno;
    private String subject;
    private double score;

    public ResultM(int id, String studentAdmNo, String subject, double score) {
        this.setId(id);
        this.setStudentadmno(studentAdmNo);
        this.setSubject(subject);
        this.setScore(score);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentadmno() {
        return studentadmno;
    }

    public void setStudentadmno(String studentAdmNo) {
        this.studentadmno = studentAdmNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("%s    %s  %s  %s", getId(), getStudentadmno(), getSubject(), getScore());
    }
}
