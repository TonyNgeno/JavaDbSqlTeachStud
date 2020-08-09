package com.tony.ngeno;

import java.sql.SQLException;
import java.util.Map;

public interface StudentI {

    Map<Integer, Student> getStudents() throws SQLException, ClassNotFoundException;

    boolean addStudent(Student student) throws SQLException, ClassNotFoundException;

    boolean deleteStudent(int id) throws SQLException;

    boolean updateStudent(int id, Student student) throws SQLException;
}
