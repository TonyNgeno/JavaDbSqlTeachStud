package com.tony.ngeno;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

//a class for student

public class Student implements StudentI {
    private String name;
    private String id;

    private DbConnection dbConnection;

    public Student() throws SQLException, ClassNotFoundException {
        this.dbConnection = DbConnection.getInstance();
    }

    //initialize variables
    public Student(String name, String id) {
        this.name = name;
        this.id = id;
    }

    private String getName() {
        return name;
    }

    private String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student name: " + this.getName() +
                "\n" +
                "Student Adm No: " + this.getId() +
                "\n";
    }

    @Override
    public Map<Integer, Student> getStudents() throws SQLException {
        ResultSet resultSet = dbConnection.executeQuery("SELECT * FROM students");
        Map<Integer, Student> students = new HashMap<Integer, Student>();
        while (resultSet.next()) {
            students.put(
                    resultSet.getInt("id"),
                    new Student(
                            resultSet.getString("studName"),
                            resultSet.getString("studAdmNo")
                    )
            );
        }
        return students;
    }

    @Override
    public boolean addStudent(Student student) throws SQLException {
        PreparedStatement preparedStatement = dbConnection
                .getPreparedStatement("INSERT INTO students(studName,studAdmNo) VALUES(?,?)");
        preparedStatement.setString(1, student.getName());
        preparedStatement.setString(2, student.getId());
        return dbConnection.execute(preparedStatement);
    }

    @Override
    public boolean deleteStudent(int id) throws SQLException {
        PreparedStatement preparedStatement = dbConnection
                .getPreparedStatement("DELETE FROM students WHERE id=?");
        preparedStatement.setInt(1, id);
        return dbConnection.execute(preparedStatement);
    }

    @Override
    public boolean updateStudent(int id, Student student) throws SQLException {
        PreparedStatement preparedStatement = dbConnection
                .getPreparedStatement("UPDATE students SET studName=?,studAdmNo=? WHERE id=?");
        preparedStatement.setString(1, student.getName());
        preparedStatement.setString(2, student.getId());
        preparedStatement.setInt(3, id);
        return dbConnection.execute(preparedStatement);
    }
}
