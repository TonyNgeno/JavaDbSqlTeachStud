package com.tony.ngeno;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/*
   A class to create object for subject details and teachers
 */
public class Subject implements SubjectI {
    private String title;
    private double score;
    private Teacher teacher;

    private DbConnection dbConnection;

    public Subject() throws SQLException, ClassNotFoundException {
        this.dbConnection = DbConnection.getInstance();
    }

    //initialize variables
    public Subject(String title, Teacher teacher) {
        this.title = title;
        this.teacher = teacher;
    }

    /*
       set the score to zero if score>100
     */
    public void setScore(double score) {
        if (Math.abs(score) > 100)
            score = 0;
        this.score = Math.abs(score);
    }

    String getTitle() {
        return title;
    }

    double getScore() {
        return score;
    }

    private Teacher getTeacher() {
        return teacher;
    }

    @Override
    public String toString() {
        return String.format("%s-%s Teacher- %s", this.getTitle(), this.getScore(), this.getTeacher().getName());
    }

    @Override
    public Map<Integer, Subject> getSubjects() throws SQLException {
        ResultSet resultSet = dbConnection.executeQuery("SELECT * FROM subjects");
        Map<Integer, Subject> subjects = new HashMap<Integer, Subject>();
        while (resultSet.next()) {
            subjects.put(
                    resultSet.getInt(1),
                    new Subject(
                            resultSet.getString(2),
                            new Teacher(
                                    resultSet.getString(3)
                            )
                    )
            );
        }
        return subjects;
    }

    @Override
    public boolean addSubject(Subject subject) throws SQLException {
        PreparedStatement preparedStatement = dbConnection
                .getPreparedStatement("INSERT INTO subjects(title,teachername) VALUES(?,?)");
        preparedStatement.setString(1, subject.getTitle());
        preparedStatement.setString(2, subject.getTeacher().getName());
        return dbConnection.execute(preparedStatement);
    }

    @Override
    public boolean deleteSubject(int id) throws SQLException {
        PreparedStatement preparedStatement = dbConnection
                .getPreparedStatement("DELETE FROM subjects WHERE id=?");
        preparedStatement.setInt(1, id);
        return dbConnection.execute(preparedStatement);
    }

    @Override
    public boolean updateSubject(int id, Subject subject) throws SQLException {
        PreparedStatement preparedStatement = dbConnection
                .getPreparedStatement("UPDATE subjects SET title=?,teachername=? WHERE id=?");
        preparedStatement.setString(1, subject.getTitle());
        preparedStatement.setString(2, subject.getTeacher().getName());
        preparedStatement.setInt(3, id);
        return dbConnection.execute(preparedStatement);
    }

}
