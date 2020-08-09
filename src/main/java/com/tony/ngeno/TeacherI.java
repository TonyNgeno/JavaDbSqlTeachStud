package com.tony.ngeno;

import java.sql.SQLException;
import java.util.Map;

public interface TeacherI {
    Map<Integer, Teacher> getTeachers() throws SQLException, ClassNotFoundException;

    boolean addTeacher(Teacher teacher) throws SQLException, ClassNotFoundException;

    boolean deleteTeacher(int id) throws SQLException;

    boolean updateTeacher(int id, Teacher teacher) throws SQLException;
}
