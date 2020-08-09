package com.tony.ngeno;

import java.sql.SQLException;

public interface MainClassI {
    void showMainMenu() throws SQLException, ClassNotFoundException;

    void showTeachersMenu() throws SQLException, ClassNotFoundException;

    void viewTeacher() throws SQLException, ClassNotFoundException;

    void addTeacher() throws SQLException, ClassNotFoundException;

    void updateTeacher() throws SQLException, ClassNotFoundException;

    void deleteTeacher() throws SQLException, ClassNotFoundException;

    void showSubjectsMenu() throws SQLException, ClassNotFoundException;

    void viewSubjects() throws SQLException, ClassNotFoundException;

    void addSubject() throws SQLException, ClassNotFoundException;

    void updateSubject() throws SQLException, ClassNotFoundException;

    void deleteSubject() throws SQLException, ClassNotFoundException;

    void showStudentsMenu() throws SQLException, ClassNotFoundException;

    void viewStudents() throws SQLException, ClassNotFoundException;

    void addStudent() throws SQLException, ClassNotFoundException;

    void updateStudent() throws SQLException, ClassNotFoundException;

    void deleteStudent() throws SQLException, ClassNotFoundException;

    void showResultsMenu() throws SQLException, ClassNotFoundException;

    void addResult() throws SQLException, ClassNotFoundException;

    void updateResult() throws SQLException, ClassNotFoundException;

    void deleteResult() throws SQLException, ClassNotFoundException;

    void viewResults() throws SQLException, ClassNotFoundException;

    void viewStudentResult() throws SQLException, ClassNotFoundException;

    void clearResults() throws SQLException, ClassNotFoundException;
}
