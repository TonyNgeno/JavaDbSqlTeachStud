package com.tony.ngeno;

import java.sql.SQLException;
import java.util.Map;

public interface SubjectI {

    Map<Integer, Subject> getSubjects() throws SQLException, ClassNotFoundException;

    boolean addSubject(Subject subject) throws SQLException, ClassNotFoundException;

    boolean deleteSubject(int id) throws SQLException;

    boolean updateSubject(int id, Subject subject) throws SQLException;

}
